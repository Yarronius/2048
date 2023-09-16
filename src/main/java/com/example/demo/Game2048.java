package com.example.demo;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class Game2048 extends Application {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];

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
        stage.show();
    }


    @Override
    public void init() {
        System.out.println("getRaw(): " +
                this.getParameters().getRaw());
        System.out.println("getNamed(): " +
                this.getParameters().getNamed().keySet());
        System.out.println("getUnnamed(): " +
                this.getParameters().getUnnamed());
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Метод stop()" + " " +
                Thread.currentThread().getName());
    }


    public void createGame()  {

    }



    private void setCellColor(Color color) {

    }

    private void createNewNumber() {
        int x = getRandomNumber(SIDE);
        int y = getRandomNumber(SIDE);
        while (gameField[x][y] != 0) {
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        }
        if(getRandomNumber(10) == 9) {
            gameField[x][y] = 4;
        } else {
            gameField[x][y] = 2;
        }
    }

    private int getRandomNumber(int num) {
        return (int)(Math.random()*num);
    }

    private Color getColorByValue(int value) {
        switch (value) {
            case 2 :
                return Color.ALICEBLUE;
            case 4 :
                return Color.BLUEVIOLET;
            case 8 :
                return Color.BROWN;
            case 16 :
                return Color.DARKGRAY;
            case 32 :
                return Color.DARKBLUE;
            case 64 :
                return Color.CADETBLUE;
            case 128 :
                return Color.BURLYWOOD;
            case 256 :
                return Color.AZURE;
            case 512 :
                return Color.AQUA;
            case 1024 :
                return Color.ANTIQUEWHITE;
            case 2048 :
                return Color.GOLDENROD;
        }
        return Color.BEIGE;
    }

    private void setCellColoredNumber(int x, int y, int value) {

    }

    private void setCellValueEx(int x, int y, Color color, String str) {

    }

    public static void main(String[] args) {
        launch();
    }
}