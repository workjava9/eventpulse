package com.example.app;

import com.example.app.security.JwtTokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;

class JwtTokenProviderTest {

    private JwtTokenProvider jwtTokenProvider;

    @BeforeEach
    void setUp() {
        jwtTokenProvider = new JwtTokenProvider();
        ReflectionTestUtils.setField(jwtTokenProvider, "secret", "myverysecretjwtkey00000000000000000000000000000000");
        ReflectionTestUtils.setField(jwtTokenProvider, "expirationMillis", 900000L);
    }

    @Test
    void shouldGenerateAndValidateToken() {
        String token = jwtTokenProvider.generateToken("testuser");
        assertThat(jwtTokenProvider.validateToken(token)).isTrue();
        assertThat(jwtTokenProvider.getUsername(token)).isEqualTo("testuser");
    }
}
