package com.example.app.controller;

import com.example.app.dto.EventRequest;
import com.example.app.kafka.EventProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventProducer eventProducer;

    @PostMapping
    public ResponseEntity<String> publishEvent(@RequestBody EventRequest event,
                                               @AuthenticationPrincipal UserDetails userDetails) {
        event.setUser(userDetails.getUsername());
        eventProducer.sendEvent(event);
        return ResponseEntity.ok("Event sent");
    }
}
