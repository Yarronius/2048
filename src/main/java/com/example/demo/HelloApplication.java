package com.example.demo;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Stage window = new Stage();
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


        ObservableList<Node> tiles = root.getChildren();

        Scene scene = new Scene(root, 480, 480);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case UP:
                    for(Node node : tiles) {
                        Rectangle rec = (Rectangle)node;
                        rec.setFill(Color.GOLD);
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

    public static void main(String[] args) {
        launch();
    }
}