package com.grishimir.iton.client;

import com.grishmir.iton.numbergenerator.NumberGeneratorGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import static com.grishimir.iton.util.Constants.HOST;
import static com.grishimir.iton.util.Constants.PORT;
import static java.lang.String.format;

public class ClientMain {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forTarget(format("%s:%s", HOST, PORT))
                .usePlaintext()
                .build();

        NumberGeneratorGrpc.NumberGeneratorStub asyncStub = NumberGeneratorGrpc.newStub(channel);
        GeneratorClient client = new GeneratorClient(asyncStub);
        client.printNumbers(2, 30, 50);

    }
}
