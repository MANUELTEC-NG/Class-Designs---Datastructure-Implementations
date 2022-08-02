package com.manuel.decadev.Networking;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MultiTiClientConnection extends Application {
    TextArea tArea = new TextArea();
    private int clientNo = 0;

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new ScrollPane(tArea), 450, 200);
        stage.setTitle("MultiThreaded Server ");
        stage.setScene(scene);
        stage.show();

        // instance of new thread
        new Thread(()->{
            try {
                // create a server socket
                ServerSocket serverSocket = new ServerSocket(8000);
                tArea.appendText("Multithreaded Server started at "+
                        new Date() + '\n');

                // server do a continuous listening for connection
                while (true){
                    Socket socket = serverSocket.accept();
                    clientNo += 1;

                    // this is run in another thread
                    Platform.runLater(()->{
                        tArea.appendText("Starting thread for client "+
                                clientNo + " at" + new Date() + '\n');
                        // get the client host name and IP Address
                        InetAddress address = socket.getInetAddress();
                        tArea.appendText("Client Host "+ clientNo + " "+ address.getHostName() + '\n');
                        tArea.appendText("Client "+ clientNo + " "+ address.getHostAddress() + '\n');


                    });

                    new Thread(new HandleClients(socket, tArea))
                            .start();
                }

            }catch (IOException ioe){
                System.out.println("Exception thrown in server socket thread");

            }


        }).start();

    }
}
