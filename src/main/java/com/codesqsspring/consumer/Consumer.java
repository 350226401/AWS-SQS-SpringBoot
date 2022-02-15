package com.codesqsspring.consumer;

import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @SqsListener("MyQueue")
    public void loadMessagesFromQueue(String message) {
        System.out.println("Queue Messages: " + message);
    }
}
