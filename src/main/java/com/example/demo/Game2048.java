package com.example.demo;

import javafx.application.Application;
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
        stage.setResizable(true);
        stage.show();
    }

    @Override
    public void init() {

    }

    @Override
    public void stop() throws Exception {

    }

    private int getRandomNumber(int num) {
        return (int)(Math.random()*num);
    }

    public static void main(String[] args) {
        launch();
    }
}