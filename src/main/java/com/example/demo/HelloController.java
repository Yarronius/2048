package com.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML private Rectangle rec1;
    @FXML private Button button2;
    @FXML private Button button3;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EventHandler<KeyEvent> keyEvent = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case UP : ;
                    case DOWN : ;
                    case LEFT : ;
                    case RIGHT : ;
                }
            }
        };
    }
}