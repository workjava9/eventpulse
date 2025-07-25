package com.example.app.kafka;

import com.example.app.dto.EventRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendEvent(EventRequest event) {
        kafkaTemplate.send("user-events", event.getUser(), event);
    }
}
