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
import javafx.stage.Stage;

public class Game2048 extends Application {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];

    @Override
    public void start(Stage stage) throws Exception {
        Stage window = new Stage();
        Scene scene = new Scene(drawScene(), 480, 480);


        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                /*switch (keyEvent.getCode()) {
                    case UP:
                        for(Node node : tiles) {
                            Rectangle rec = (Rectangle)node;
                        }
                        break;
                    case DOWN:
                        for(Node node : tiles) {
                            node.setStyle("-fx-background-color: gold");
                        }
                        break;
                    case LEFT:
                        for(Node node : tiles) {
                            node.setStyle("-fx-background-color: gold");
                        }
                        break;
                    case RIGHT:
                        for(Node node : tiles) {
                            node.setStyle("-fx-background-color: gold");
                        }
                        break;
                    case ESCAPE:
                        for(Node node : tiles) {
                            node.setStyle("-fx-background-color: gold");
                        }
                        break;
                    default:
                        break;
                }*/
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

    public void initialize() {
        createGame();
        drawScene();
    }

    public void createGame()  {

    }

    private Pane drawScene() {
        Pane root = new Pane();
        int coordinateX = 0;
        int coordinateY = 0;
        for (int i = 1; i <= 16; i++) {
            Rectangle rectangle = new Rectangle(120, 120);
            rectangle.setFill(Color.BEIGE);
            rectangle.setStroke(Color.BLACK);
            rectangle.setStrokeType(StrokeType.INSIDE);
            rectangle.setLayoutX(coordinateX);
            rectangle.setLayoutY(coordinateY);
            root.getChildren().add(rectangle);
            coordinateX = i % 4 == 0 ? (coordinateX + 120) : coordinateX;
            coordinateY = i % 4 == 0 ? 0 : (coordinateY + 120);
        }
        return root;
    }

    public static void main(String[] args) {
        launch();
    }
}