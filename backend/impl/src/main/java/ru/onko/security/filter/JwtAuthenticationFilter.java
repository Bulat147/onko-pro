package ru.onko.security.filter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.onko.model.jooq.tables.pojos.AccountEntity;
import ru.onko.security.authentication.JwtAuthentication;
import ru.onko.security.details.UserDetailsImpl;
import ru.onko.security.matcher.PathRequestMatcher;
import ru.onko.security.matcher.PrefixPathRequestMatcher;
import ru.onko.security.util.JwtUtil;
import ru.onko.service.AccountService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String AUTHENTICATION_HEADER = "Authorization";

    private final List<PathRequestMatcher> requestMatchers;

    private final List<PrefixPathRequestMatcher> prefixRequestMatchers;

    private final AccountService accountService;

    private final JwtUtil jwtUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        for (PathRequestMatcher matcher : requestMatchers) {
            if (matcher.match(request)) {
                if (authenticate(request, response)) {
                    filterChain.doFilter(request, response);
                }
                return;
            }
        }

        for (PrefixPathRequestMatcher matcher : prefixRequestMatchers) {
            if (matcher.matchStart(request)) {
                if (authenticate(request, response)) {
                    filterChain.doFilter(request, response);
                }
                return;
            }
        }

        filterChain.doFilter(request, response);
    }

    private boolean authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String jwt = request.getHeader(AUTHENTICATION_HEADER);
        if (jwt == null || jwt.isEmpty()) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        try {
            DecodedJWT decodedJWT = jwtUtil.verify(jwt);
            UUID id = UUID.fromString(decodedJWT.getClaim("id").asString());

            Optional<AccountEntity> optionalAccount = accountService.findById(id);
            if (optionalAccount.isEmpty()) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                return false;
            }
            AccountEntity account = optionalAccount.get();
            UserDetails userDetails = new UserDetailsImpl(account, accountService.findRolesById(account.getId()));

            JwtAuthentication jwtAuthentication = new JwtAuthentication(account, true, userDetails);
            SecurityContextHolder.getContext().setAuthentication(jwtAuthentication);
            return true;
        } catch (JWTVerificationException e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
    }
}
