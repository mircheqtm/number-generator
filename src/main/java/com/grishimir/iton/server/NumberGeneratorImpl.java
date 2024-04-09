package com.grishimir.iton.server;

import com.grishmir.iton.numbergenerator.NumberGeneratorGrpc;
import com.grishmir.iton.numbergenerator.NumberGeneratorOuterClass;
import io.grpc.stub.StreamObserver;

public class NumberGeneratorImpl extends NumberGeneratorGrpc.NumberGeneratorImplBase {
    @Override
    public void generateNumbers(NumberGeneratorOuterClass.GenerateRequest req, StreamObserver<NumberGeneratorOuterClass.NumberResponse> responseObserver) {
        try {
            for (int i = req.getFirstValue(); i < req.getLastValue(); ++i) {
                NumberGeneratorOuterClass.NumberResponse number = NumberGeneratorOuterClass.NumberResponse
                        .newBuilder()
                        .setNumber(i).build();
                responseObserver.onNext(number);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            responseObserver.onCompleted();
        }
    }
}