package com.example.app.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.example.app.dto.EventRequest;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendEvent(EventRequest event) {
        kafkaTemplate.send("events", event);
    }
}
