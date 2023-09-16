package com.example.demo;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
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

            Rectangle rectangle = new Rectangle(120, 120);
            Text text = new Text(textCoordinateX, textCoordinateY, "");
            text.setFont(new Font(98));
            rectangle.setFill(Color.BEIGE);
            rectangle.setStroke(Color.BLACK);
            rectangle.setStrokeType(StrokeType.INSIDE);
            rectangle.setLayoutX(coordinateX);
            rectangle.setLayoutY(coordinateY);
            this.getChildren().add(rectangle);
            this.getChildren().add(text);
            coordinateX = i % 4 == 0 ? (coordinateX + 120) : coordinateX;
            coordinateY = i % 4 == 0 ? 0 : (coordinateY + 120);
            textCoordinateX = i % 4 == 0 ? (textCoordinateX + 120) : textCoordinateX;
            textCoordinateY = i % 4 == 0 ? 90 : (textCoordinateY + 120);
        }
    }

    public void draw(Tile[][] tiles) {
        List<Node> tileList = this.getChildren();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int tileListIndex = Tile.getListIndexFromCoordinates(i, j);
                Rectangle rectangle = (Rectangle) tileList.get(tileListIndex);
                rectangle.setFill(tiles[i][j].getTileColor());
                Text text = (Text) tileList.get(tileListIndex + 1);
                if (tiles[i][j].value != 0) {
                    text.setText(String.valueOf(tiles[i][j].value));
                } else {
                    text.setText("");

                    //System.out.println(Tile.getListIndexFromCoordinates(i, j) + " " + tileList.get(Tile.getListIndexFromCoordinates(i, j)));
                    //System.out.println(Tile.getListIndexFromCoordinates(i, j) + 1 + " " + tileList.get(Tile.getListIndexFromCoordinates(i, j) + 1));
                }
            }
        }
    }
}