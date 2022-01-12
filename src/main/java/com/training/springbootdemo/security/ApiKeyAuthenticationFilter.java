package com.training.springbootdemo.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Component
public class ApiKeyAuthenticationFilter extends BasicAuthenticationFilter {

    @Value("${api-key}")
    private String apiKey;

    public ApiKeyAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    public void doFilterInternal(HttpServletRequest httpServletRequest,
                                 HttpServletResponse httpServletResponse,
                                 FilterChain filterChain)
        throws IOException, ServletException {
        String header = httpServletRequest.getHeader("x-api-key");

        if(header == null || !header.equals(apiKey)) {
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(null, null, Collections.emptyList());
        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
