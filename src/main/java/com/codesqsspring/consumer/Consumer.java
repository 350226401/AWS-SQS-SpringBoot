package com.codesqsspring.consumer;

import com.codesqsspring.common.GenericLambdaInvoke;
import com.codesqsspring.model.ClientRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Consumer {


    private final GenericLambdaInvoke genericLambdaInvoke;
    private final String lambdaFuncktion;

    public Consumer(final GenericLambdaInvoke genericLambdaInvoke, @Value("${app.lambda.client.register}") final String lambdaFuncktion) {

        this.genericLambdaInvoke = genericLambdaInvoke;
        this.lambdaFuncktion = lambdaFuncktion;
    }


//    @SqsListener("myQueueTest")
//    public void loadMessagesFromQueue(final ClientRequest message) throws Exception {
//        ClientRequest c = message;
//    }

}
