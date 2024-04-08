package com.grishimir.iton.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.grishimir.iton.util.Constants.PORT;

public class GeneratorServer {
    private static final Logger logger = LoggerFactory.getLogger(GeneratorServer.class);
    private final Server server;

    public GeneratorServer() {
        server = ServerBuilder.forPort(PORT)
                .addService(new NumberGeneratorImpl())
                .build();
    }

    public void start() throws IOException {
        server.start();
        logger.info("Server started, listening on " + PORT);
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

}
