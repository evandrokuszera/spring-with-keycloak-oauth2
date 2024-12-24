package br.edu.utfpr.keycloak_spring.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    @GetMapping("/public/hello")
    public String publicHello() {
        return "Hello World, public";
    }

    @GetMapping("/user/hello")
    @PreAuthorize("hasRole('USER')")
    public String userHello() {
        return "Hello World, user";
    }

    @GetMapping("/admin/hello")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminHello(JwtAuthenticationToken jwt) {

        return "Hello World, admin. " + jwt.getToken().getClaimAsString("preferred_username");
    }

}
