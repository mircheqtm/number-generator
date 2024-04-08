package com.grishimir.iton.server;

import java.io.IOException;

public class ServerMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        GeneratorServer server = new GeneratorServer();
        server.start();
        server.blockUntilShutdown();
    }
}
