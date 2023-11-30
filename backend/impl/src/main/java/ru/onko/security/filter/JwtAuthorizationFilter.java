package ru.onko.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.onko.model.jooq.enums.AccountRole;
import ru.onko.security.authentication.JwtAuthentication;
import ru.onko.security.details.UserDetailsImpl;
import ru.onko.security.matcher.PathRequestMatcher;
import ru.onko.security.matcher.PrefixPathRequestMatcher;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final List<PathRequestMatcher> requestMatchers;

    private final List<PrefixPathRequestMatcher> prefixRequestMatchers;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        for (PathRequestMatcher matcher : requestMatchers) {
            if (matcher.match(request)) {
                if (!(authentication instanceof JwtAuthentication)) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
                if (!authorize(response)) {
                    return;
                }
                filterChain.doFilter(request, response);
                return;
            }
        }

        for (PrefixPathRequestMatcher matcher : prefixRequestMatchers) {
            if (matcher.matchStart(request)) {
                if (!(authentication instanceof JwtAuthentication)) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
                if (!authorize(response)) {
                    return;
                }
                filterChain.doFilter(request, response);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private boolean authorize(HttpServletResponse response) throws IOException {
        JwtAuthentication jwtAuthentication = (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) jwtAuthentication.getDetails();
        if (!userDetails.getAuthorities().contains(new SimpleGrantedAuthority(AccountRole.ADMIN.toString()))) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }
        return true;
    }
}
