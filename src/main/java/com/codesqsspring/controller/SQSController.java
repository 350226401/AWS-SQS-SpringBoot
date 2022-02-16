package com.codesqsspring.controller;

import com.codesqsspring.model.ClientRequest;
import com.codesqsspring.model.ClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client/save")
public class SQSController {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String endPoint;

    @PostMapping
    public ClientResponse putMessagedToQueue(@RequestBody ClientRequest message) {
        queueMessagingTemplate.send(endPoint, MessageBuilder.withPayload(message).build());

        return ClientResponse.builder()
                .id(1)
                .name(message.getName())
                .empresa(message.getEmpresa())
                .build();
    }

}
