package ru.onko.security.matcher;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;

import java.util.List;

public class PrefixPathRequestMatcher {

    private final String prefix;

    private final List<HttpMethod> methods;

    public PrefixPathRequestMatcher(String prefix, HttpMethod... methods) {
        this.prefix = prefix;
        this.methods = List.of(methods);
    }

    public boolean matchStart(HttpServletRequest request) {
        if (!request.getServletPath().startsWith(prefix)) {
            return false;
        }
        for (HttpMethod method : methods) {
            if (request.getMethod().equals(method.toString())) {
                return true;
            }
        }
        return false;
    }
}
