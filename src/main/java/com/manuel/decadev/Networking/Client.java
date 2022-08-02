package com.manuel.decadev.Networking;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Application {
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setPadding(new Insets(5,5,5,5));
        paneForTextField.setStyle("-fx-border-color: green");
        paneForTextField.setLeft(new Label("Enter a radius"));

        TextField textField = new TextField();
        textField.setAlignment(Pos.BOTTOM_RIGHT);

        paneForTextField.setCenter(textField);

        BorderPane mainPane = new BorderPane();
        TextArea textArea = new TextArea();
        mainPane.setCenter(new ScrollPane(textArea));

        mainPane.setTop(paneForTextField);

        // create a scene and place it in the stage

        Scene scene = new Scene(mainPane, 450, 200);
        stage.setTitle("Client");
        stage.setScene(scene);
        stage.show();

        textField.setOnAction( e -> {
            try {
                Double radius = Double.parseDouble(textField.getText());
                toServer.writeDouble(radius);
                toServer.flush();
                 Double calResFromServer = fromServer.readDouble();

                // textArea.appendText("Radius input is : "+ radius + '\n');
                 textArea.appendText("Calculated Result from server is :" + calResFromServer + '\n');

            } catch (IOException io){
                System.out.println("IO Exception thrown at onAction handler");
            }
        });

        try {
            // create a socket to connect to server
            Socket socket = new Socket("localhost", 8000);
            //Socket socket = new Socket("130.254.204.36", 8000);
            //Socket socket = new Socket("scholardemy.com", 8000);

           fromServer = new DataInputStream (socket.getInputStream());
           toServer = new DataOutputStream(socket.getOutputStream());


        } catch (IOException ioe){
            System.out.println("Exception thrown while reading from server");
            textArea.appendText(ioe.toString());
        }
    }
}
