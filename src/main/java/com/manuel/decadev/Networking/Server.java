 package com.manuel.decadev.Networking;


import java.util.*;
import java.io.*;
import java.net.*;
import java.util.Date;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class Server extends Application {

    ServerSocket serverSocket = null;
    DataInputStream inputFromClient = null;
    DataOutputStream outPutToClient = null;
    InetAddress clientInfo = null;

    @Override
    public void start( Stage primaryStage){
    TextArea ta = new TextArea();

    Scene scene = new Scene(new ScrollPane(ta), 450, 200);
    primaryStage.setTitle("Server");
    primaryStage.setScene(scene);
    primaryStage.show();

    new Thread(()->{
        try {
             serverSocket = new ServerSocket(8000);
            Platform.runLater(()->{
                ta.appendText("Server started at \n"+ new Date() + '\n');
                 clientInfo = serverSocket.getInetAddress();

            });
            Socket socket = serverSocket.accept();

             inputFromClient = new DataInputStream (socket.getInputStream());
             outPutToClient = new DataOutputStream(socket.getOutputStream());


            while (true){

                Double radius = inputFromClient.readDouble();

                Double area = radius.doubleValue() * radius.doubleValue() * Math.PI;
                outPutToClient.writeDouble(Math.floor (area.doubleValue()));

                Platform.runLater(()->{
                    ta.appendText("Client Host Name: "+ clientInfo.getHostName() +'\n');
                    ta.appendText("Client IP: "+ clientInfo.getHostAddress() + '\n');

                    ta.appendText("Radius received from client: "+ radius + ":\n");
                   // ta.appendText("Calc result from server is: "+ area +'\n');
                });
            }
        } catch (IOException ioException){
            System.out.println("Interrupted exception thrown");
        }
    }).start();
    }


}
