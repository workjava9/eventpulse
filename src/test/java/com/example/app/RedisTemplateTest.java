package com.example.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RedisTemplateTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void shouldWriteAndReadValue() {
        redisTemplate.opsForValue().set("foo", "bar");
        Object value = redisTemplate.opsForValue().get("foo");
        assertThat(value).isEqualTo("bar");
    }
}
