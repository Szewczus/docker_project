package com.example.docker_project.services;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String topic, String key, Object message) {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, key, message);
        //acknowledge:
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, Object> result) {
                RecordMetadata metadata = result.getRecordMetadata();

                System.out.println("Message sent successfully to topic " + metadata.topic() +
                        " partition " + metadata.partition() +
                        " with offset " + metadata.offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Message failed to send: " + ex.getMessage());
            }
        });
    }
}
