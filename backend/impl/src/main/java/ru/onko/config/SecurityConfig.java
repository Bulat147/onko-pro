package ru.onko.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.HeaderWriterFilter;
import ru.onko.security.filter.JwtAuthenticationFilter;
import ru.onko.security.filter.JwtAuthorizationFilter;
import ru.onko.security.matcher.PathRequestMatcher;
import ru.onko.security.matcher.PrefixPathRequestMatcher;
import ru.onko.security.util.JwtUtil;
import ru.onko.service.AccountService;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AccountService accountService;

    private final JwtUtil jwtUtil;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(Collections.emptyList(), authenticationPrefixPathRequestMatchers(), accountService, jwtUtil);
    }

    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter() {
        return new JwtAuthorizationFilter(authorizationPathRequestMatchers(), Collections.emptyList());
    }

    private List<PrefixPathRequestMatcher> authenticationPrefixPathRequestMatchers() {
        return List.of(new PrefixPathRequestMatcher("/user", HttpMethod.GET, HttpMethod.POST));
    }

    private List<PathRequestMatcher> authorizationPathRequestMatchers() {
        return List.of(new PathRequestMatcher("/article", HttpMethod.POST));
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.rememberMe(AbstractHttpConfigurer::disable);
        http.logout(AbstractHttpConfigurer::disable);
        http.sessionManagement(customizer -> customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterAfter(jwtAuthenticationFilter(), HeaderWriterFilter.class);
        http.addFilterAfter(jwtAuthorizationFilter(), JwtAuthenticationFilter.class);

        return http.build();
    }
}
