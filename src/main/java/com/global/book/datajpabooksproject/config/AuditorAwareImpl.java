package com.global.book.datajpabooksproject.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
//        should get username from spring security
        return Optional.of("test user");
    }
}
