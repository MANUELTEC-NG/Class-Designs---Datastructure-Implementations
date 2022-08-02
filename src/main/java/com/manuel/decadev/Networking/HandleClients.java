package com.manuel.decadev.Networking;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class HandleClients implements Runnable {
private Socket socket;
private TextArea ta;
//DataInputStream inputStream;
//DataOutputStream outputStream;


public HandleClients(Socket socket, TextArea ta){
    this.socket = socket;
    this.ta = ta;
}




    @Override
    public void run() {
    StringBuilder str = new StringBuilder();
        try {
           // inputStream = new DataInputStream(socket.getInputStream());
           // outputStream = new DataOutputStream(socket.getOutputStream());

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            while (true) {
                ta.appendText("Client is typing...");
                String word = inputStream.readLine();
                while (!word.equals("")) {
                    str.append(inputStream.readLine());

                }
                writer.write(word);
                Platform.runLater(()->{
                    ta.appendText("Response sent to client");
                });
            }

        } catch (IOException ioe){

        }
    }
}
