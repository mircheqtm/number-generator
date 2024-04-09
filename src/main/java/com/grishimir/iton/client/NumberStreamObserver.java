package com.grishimir.iton.client;

import com.grishmir.iton.numbergenerator.NumberGeneratorOuterClass;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberStreamObserver implements StreamObserver<NumberGeneratorOuterClass.NumberResponse> {
    private static final Logger logger = LoggerFactory.getLogger(NumberStreamObserver.class);

    private final ReceivedValue receivedValue;

    public NumberStreamObserver(ReceivedValue receivedValue) {
        this.receivedValue = receivedValue;

    }

    @Override
    public void onNext(NumberGeneratorOuterClass.NumberResponse numberResponse) {
        logger.info("Received: " + numberResponse.getNumber());
        receivedValue.updateValue(numberResponse.getNumber());
    }

    @Override
    public void onError(Throwable t) {
        logger.error("An exception occurred", t);
    }

    @Override
    public void onCompleted() {
        logger.info("Stream completed.");
    }
}
