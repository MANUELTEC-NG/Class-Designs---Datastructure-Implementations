package com.manuel.decadev.multithreading.ThroughPutDemo;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThroughputServer {
/**
 *  Thread throughput maximization of a backend http server
 *  An example of counting the occurrence of a word in a large text file
 *  By listening in a port and taking a query from the client
 **/
    private static final String INPUT_FILE = "/Users/dec/IdeaProjects/Java|Models|Concepts/src/main/java/com/manuel/decadev/multithreading/ThroughPutDemo/resources/war_and_peace.txt";
    private static int NUMBER_OF_THREADS = 4;

    public static void main(String[] args) throws IOException {
        // get the text file
        // read the bytes
        // form a string from it
        String text = new String( Files.readAllBytes( Paths.get(INPUT_FILE)));

        // pass the read book to the server
        System.out.println("Listening at port: 8000");
        startServer(text);
    }

    private static void startServer(String text) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        WordHandler handler = new WordHandler(text);
        server.createContext("/search", handler);

        // create a pool of executors
        Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        server.setExecutor(executor);
        server.start();
    }

}
