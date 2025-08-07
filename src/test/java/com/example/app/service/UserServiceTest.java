package com.example.app.service;

import com.example.app.model.User;
import com.example.app.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testFindUserById_WhenUserExists() {
        User user = new User();
        user.setId(1L);
        user.setUsername("test_user");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<User> result = userService.findUserById(1L);

        assertTrue(result.isPresent());
        assertEquals("test_user", result.get().getUsername());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testFindUserById_WhenUserNotFound() {
        when(userRepository.findById(2L)).thenReturn(Optional.empty());

        Optional<User> result = userService.findUserById(2L);

        assertFalse(result.isPresent());
        verify(userRepository, times(1)).findById(2L);
    }
}
