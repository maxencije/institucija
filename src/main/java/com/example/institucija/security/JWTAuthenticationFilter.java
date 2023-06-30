package com.example.institucija.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.institucija.domain.User;
import com.example.institucija.repo.UserRepo;
import com.example.institucija.security.filter.SpringContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private UserRepo userRepo = SpringContext.getBean(UserRepo.class);
    private AuthenticationManager authenticationManager;
    private User credentials;
    private Gson gson = new GsonBuilder()
            .setExclusionStrategies(new ExclusionStrategy() {
                private Set<Class> usedClasses = new HashSet<>();

                public boolean shouldSkipClass(Class<?> clazz) {
                    return false;
                }

                /**
                 * Custom field exclusion goes here
                 */
                public boolean shouldSkipField(FieldAttributes f) {
                    if (usedClasses.contains(f.getDeclaredClass())) {
                        return false;
                    }
                    usedClasses.add(f.getDeclaredClass());
                    return true;
                }
            })
            /**
             * Use serializeNulls method if you want To serialize null values
             * By default, Gson does not serialize null values
             */
            .serializeNulls()
            .create();

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            credentials = new ObjectMapper().readValue(request.getInputStream(), User.class);
            User u = userRepo.findByUsername(credentials.getUsername());
            if(u == null) {
                throw new RuntimeException("User not found");
            }
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    credentials.getUsername(),
                    credentials.getPassword(),
                    new ArrayList<>())
            );
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String token = JWT.create()
                .withSubject(((org.springframework.security.core.userdetails.User) authResult.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()));
        User user = userRepo.findByUsername(credentials.getUsername());
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("token", SecurityConstants.TOKEN_PREFIX + token);
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(jsonObject));
        response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
    }
}
