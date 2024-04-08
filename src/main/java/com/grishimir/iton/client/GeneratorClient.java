package com.grishimir.iton.client;

import com.grishmir.iton.numbergenerator.NumberGeneratorGrpc;
import com.grishmir.iton.numbergenerator.NumberGeneratorOuterClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeneratorClient {
    private static final Logger logger = LoggerFactory.getLogger(GeneratorClient.class);
    private final NumberGeneratorGrpc.NumberGeneratorStub stub;

    public GeneratorClient(NumberGeneratorGrpc.NumberGeneratorStub stub) {
        this.stub = stub;
    }

    public void printNumbers(int firstValue, int lastValue, int iterations) throws InterruptedException {
        NumberGeneratorOuterClass.GenerateRequest request = NumberGeneratorOuterClass.GenerateRequest
                .newBuilder()
                .setFirstValue(firstValue)
                .setLastValue(lastValue)
                .build();

        ReceivedValue receivedValue = new ReceivedValue();
        stub.generateNumbers(request, new NumberStreamObserver(receivedValue));
        int currentValue = 0;
        for (int i = 0; i < iterations; i++) {
            currentValue += receivedValue.getValue() + 1;
            logger.info("currentValue " + currentValue);
            Thread.sleep(1000);
        }
    }
}
