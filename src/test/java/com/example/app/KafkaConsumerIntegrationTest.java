//package com.example.app;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.testcontainers.containers.KafkaContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//import org.testcontainers.utility.DockerImageName;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//@SpringBootTest
//@ActiveProfiles("test")
//@Testcontainers
//class KafkaConsumerIntegrationTest {
//
//    @Container
//    static final KafkaContainer kafkaContainer = new KafkaContainer(
//            DockerImageName.parse("confluentinc/cp-kafka:7.2.1")
//    );
//
//    @DynamicPropertySource
//    static void setKafkaProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.kafka.bootstrap-servers", kafkaContainer::getBootstrapServers);
//    }
//
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//    @Test
//    void shouldSendMessageToKafka() {
//        kafkaTemplate.send("test-topic", "hello-world");
//        assertThat(true).isTrue();
//    }
//}
