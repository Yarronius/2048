package com.example.demo;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class View extends Pane {
    private static Color BGCOLOR = new Color(0.6,0.6,0.6,1);
    private static String FONT = "Arial";
    private static int TILE_SIZE = 96;
    private static int TILE_MARGIN = 12;

    private Controller controller;
    boolean isGameWon = false;
    boolean isGameLost = false;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void resetGame() {

    }
}
