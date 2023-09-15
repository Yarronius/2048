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
        Stage window = new Stage();
        Pane root = new Pane();
        drawScene(root);
        Scene scene = new Scene(root, 480, 480);



        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                Rectangle rectangle = (Rectangle) root.getChildren().get(0);
                Text text = (Text) root.getChildren().get(1);
                switch (keyEvent.getCode()) {
                    case UP:
                    rectangle.setFill(Color.ALICEBLUE);
                    text.setText("4");
                        break;
                    case DOWN:
                        rectangle.setFill(Color.BLANCHEDALMOND);
                        break;
                    case LEFT:
                        rectangle.setFill(Color.ANTIQUEWHITE);
                        break;
                    case RIGHT:
                        rectangle.setFill(Color.BISQUE);
                        break;
                    case ESCAPE:rectangle.setFill(Color.DARKMAGENTA);
                        break;
                    default:
                        break;
                }
            }
        });
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

   /* public void initialize() {
        createGame();
        drawScene();
    }*/

    public void createGame()  {

    }

    private void drawScene(Pane root) {
        int coordinateX = 0;
        int coordinateY = 0;
        int textCoordinateX = 35;
        int textCoordinateY = 90;
        for (int i = 1; i <= 16; i++) {
            Rectangle rectangle = new Rectangle(120, 120);
            Text text = new Text(textCoordinateX, textCoordinateY, "2");
            text.setFont(new Font(98));
            rectangle.setFill(Color.BEIGE);
            rectangle.setStroke(Color.BLACK);
            rectangle.setStrokeType(StrokeType.INSIDE);
            rectangle.setLayoutX(coordinateX);
            rectangle.setLayoutY(coordinateY);
            root.getChildren().add(rectangle);
            root.getChildren().add(text);
            coordinateX = i % 4 == 0 ? (coordinateX + 120) : coordinateX;
            coordinateY = i % 4 == 0 ? 0 : (coordinateY + 120);
            textCoordinateX = i % 4 == 0 ? (textCoordinateX + 120) : textCoordinateX;
            textCoordinateY = i % 4 == 0 ? 90 : (textCoordinateY + 120);
        }
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