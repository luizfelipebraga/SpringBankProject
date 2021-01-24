package com.orange.talent.account.kafka.producer;

import com.orange.talent.account.dto.response.ClientResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class ClientProducer {
 
    @Value("${client-kafka.topic}")
    private String clientTopic;
 
    @Autowired
    KafkaTemplate kafkaTemplate;
 
 
    public void send(final @RequestBody ClientResponseDTO client) {
        kafkaTemplate.send(clientTopic, client.getId(), client);
    }
}
