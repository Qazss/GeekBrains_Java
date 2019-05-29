package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    VBox vBox;

    @FXML
    TextField messageWindow;

    @FXML
    Button butSend;

    Socket socket;
    DataInputStream inputStream;
    DataOutputStream outputStream;

    final String IP = "localhost";
    final int port = 7189;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vBox.setFillWidth(false);
        vBox.setSpacing(10);

        try {
            socket = new Socket(IP, port);
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while(true) {
                            String text = inputStream.readUTF();
                            //vBox.getChildren().add(new MessageTextArea(text));
                            //System.out.println(text);
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    vBox.getChildren().add(new MessageTextArea(text));
                                }
                            });
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(){
        if(messageWindow.getText().isEmpty()){
            butSend.isDisabled();
        } else {
            try {
                outputStream.writeUTF(messageWindow.getText());
                messageWindow.clear();
                messageWindow.requestFocus();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
