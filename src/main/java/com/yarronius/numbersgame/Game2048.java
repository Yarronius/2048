package com.yarronius.numbersgame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Game2048 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        view.initialize();
        view.draw(model.getGameTiles());
        Scene scene = new Scene(view, 480, 480);
        stage.addEventHandler(KeyEvent.KEY_PRESSED, controller.getEventHandler());
        stage.setTitle("2048");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setOnCloseRequest(event -> Platform.exit());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}