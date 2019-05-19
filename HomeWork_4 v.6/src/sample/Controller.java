package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Controller {

    @FXML
    VBox vBox;

    @FXML
    TextField messageWindow;

    @FXML
    Button butSend;

    public void sendMessage(){
        if(messageWindow.getText().isEmpty()){
            butSend.isDisabled();
        } else {
            vBox.setFillWidth(false);
            vBox.setSpacing(10);
            vBox.getChildren().add(new MessageTextArea(messageWindow.getText()));
            messageWindow.clear();
            messageWindow.requestFocus();
        }
    }
}
