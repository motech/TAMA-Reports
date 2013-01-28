package org.motechproject.tama.reports.web.security;


import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class IPAuthenticationProvider implements AuthenticationProvider {


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if ("127.0.0.1".equalsIgnoreCase(authentication.getPrincipal().toString())) {
            return authentication;
        } else {
            throw new AccessDeniedException("Access denied");
        }

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
