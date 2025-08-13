package com.example.app;

import com.example.app.controller.EventController;
import com.example.app.kafka.EventProducer;
import com.example.app.security.JwtFilter;
import com.example.app.security.JwtTokenProvider;
import com.example.app.security.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EventController.class)
@AutoConfigureMockMvc()
class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EventProducer eventProducer;

    @MockitoBean private JwtFilter jwtFilter;
    @MockitoBean private JwtTokenProvider jwtTokenProvider;
    @MockitoBean private UserDetailsServiceImpl userDetailsService;

    @Test
    void shouldDenyAccessToSecuredEndpointWithoutToken() throws Exception {
        mockMvc.perform(get("/events"))
                .andExpect(status().isUnauthorized());
    }
}
