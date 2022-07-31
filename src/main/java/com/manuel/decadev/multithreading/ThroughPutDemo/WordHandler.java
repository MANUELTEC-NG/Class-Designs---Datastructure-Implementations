package com.manuel.decadev.multithreading.ThroughPutDemo;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class WordHandler implements HttpHandler {
    private String text;
    public WordHandler(String text){
        this.text = text;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
    String query = exchange.getRequestURI().getQuery();
    String[] keyValue = query.split("=");
    String action = keyValue[0];
    String word = keyValue[1];
        System.out.println(word);
    if (!action.equals("word")){
        exchange.sendResponseHeaders(400, 0);

        return;
    }
    long count = countWord(word);
        System.out.println(count);

    byte[] response = Long.toString(count).getBytes();
    exchange.sendResponseHeaders(200, response.length);
    OutputStream outputStream = exchange.getResponseBody();
    outputStream.write(response);
    outputStream.close();

    }

    private long countWord(String word){
        int count = 0;
        int index = 0;

        while (index >= 0){
            index = text.indexOf(word, index);
            if (index >= 0){
                count += 1;
                index += 1;
            }
        }
        return count;
    }

}
