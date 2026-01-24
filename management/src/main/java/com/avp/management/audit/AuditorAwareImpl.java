package com.avp.management.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component("auditorProvider")
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // 1. Get the authentication object from the Security Context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 2. Check if the user is authenticated
        if (authentication == null || !authentication.isAuthenticated()
                || authentication.getPrincipal().equals("anonymousUser")) {
            return Optional.of("SYSTEM"); // Default for actions like "Self-Registration"
        }

        // 3. Return the username/email of the logged-in user
        // This value will be automatically inserted into the 'createdBy' and 'modifiedBy' fields
        return Optional.of(authentication.getName());
    }
}