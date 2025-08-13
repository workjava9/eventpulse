package com.example.app;

import org.junit.jupiter.api.Test;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import static org.assertj.core.api.Assertions.assertThat;

class RedisTemplateTest {

    @Test
    void stringSerializer_roundtrip() {
        StringRedisSerializer s = new StringRedisSerializer();
        byte[] bytes = s.serialize("hello");
        String value = s.deserialize(bytes);
        assertThat(value).isEqualTo("hello");
    }
}