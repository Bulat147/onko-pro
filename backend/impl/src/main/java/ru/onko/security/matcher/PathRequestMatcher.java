package ru.onko.security.matcher;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpMethod;

import java.util.List;

public class PathRequestMatcher {

    private final String path;

    private final List<HttpMethod> methods;

    public PathRequestMatcher(String path, HttpMethod... methods) {
        this.path = path;
        this.methods = List.of(methods);
    }

    public boolean match(HttpServletRequest request) {
        if (!request.getServletPath().equals(path)) {
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
