package com.example.app;

import com.example.app.controller.EventController;
import com.example.app.kafka.EventProducer;
import com.example.app.security.JwtFilter;
import com.example.app.security.JwtTokenProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EventController.class)
@AutoConfigureMockMvc(addFilters = false)
class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EventProducer eventProducer;

    @MockitoBean
    private JwtTokenProvider jwtTokenProvider;

    @MockitoBean
    private JwtFilter jwtFilter;

    @Test
    @WithMockUser(username = "tester")
    void shouldAcceptEventAndCallService() throws Exception {
        doNothing().when(eventProducer).sendEvent(any());

        mockMvc.perform(post("/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"type\":\"LOGIN\",\"user\":\"ignored\"}"))
                .andExpect(status().isOk());

        verify(eventProducer).sendEvent(argThat(ev -> "tester".equals(ev.getUser())));
    }
}
