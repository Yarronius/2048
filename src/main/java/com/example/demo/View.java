package com.example.demo;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.List;

public class View extends Pane {
    private static Color BGCOLOR = new Color(0.6, 0.6, 0.6, 1);
    private static String FONT = "Arial";
    private static int TILE_SIZE = 96;
    private static int TILE_MARGIN = 12;

    private Controller controller;
    boolean isGameWon = false;
    boolean isGameLost = false;

    public View() {

    }

    public void initialize() {
        int coordinateX = 0;
        int coordinateY = 0;
        int textCoordinateX = 35;
        int textCoordinateY = 90;
        for (int i = 1; i <= 16; i++) {
            Pane pane = new Pane();
            pane.setPrefSize(120, 120);
            pane.setLayoutX(coordinateX);
            pane.setLayoutY(coordinateY);
            Rectangle rectangle = new Rectangle(120, 120);
            Text text = new Text("");
            text.setFont(new Font(98));
            rectangle.setFill(Color.BEIGE);
            rectangle.setStroke(Color.BLACK);
            rectangle.setStrokeType(StrokeType.INSIDE);
            pane.getChildren().add(rectangle);
            pane.getChildren().add(text);
            text.setLayoutX(textCoordinateX);
            text.setLayoutY(textCoordinateY);
            this.getChildren().add(pane);
            coordinateX = i % 4 == 0 ? (coordinateX + 120) : coordinateX;
            coordinateY = i % 4 == 0 ? 0 : (coordinateY + 120);
            //textCoordinateX = i % 4 == 0 ? (textCoordinateX + 120) : textCoordinateX;
            //textCoordinateY = i % 4 == 0 ? 90 : (textCoordinateY + 120);
        }
    }

    public void draw(Tile[][] tiles) {
        List<Node> tileList = this.getChildren();
        for (int i = 0; i < 16; i++) {
            Tile tile = tiles[i%4][i/4];
            Pane pane = (Pane) tileList.get(i);
            Rectangle rectangle = (Rectangle) pane.getChildren().get(0);
            rectangle.setFill(tile.getTileColor());
            Text text = (Text) pane.getChildren().get(1);
            if (tile.getValue() != 0) {
                text.setText(String.valueOf(tile.getValue()));
            } else {
                text.setText("");
            }
            if(tile.getValue() < 9) {
                text.setLayoutX(35);
                text.setLayoutY(90);
                text.setFont(new Font(98));
            } else if(tile.getValue() > 8 && tile.getValue() < 65) {
                text.setLayoutX(5);
                text.setLayoutY(90);
                text.setFont(new Font(98));
            } else if (tile.getValue() > 64 && tile.getValue() < 1024) {
                text.setLayoutX(0);
                text.setLayoutY(80);
                text.setFont(new Font(72));
            } else {
                text.setLayoutX(0);
                text.setLayoutY(75);
                text.setFont(new Font(54));
            }
        }
    }
}