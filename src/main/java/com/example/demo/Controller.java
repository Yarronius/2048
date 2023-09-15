package com.example.demo;

import com.example.demo.Model;
import com.example.demo.Tile;
import com.example.demo.View;
import javafx.scene.input.KeyEvent;

public class Controller {
    private Model model;
    private View view;
    private int WINNING_TILE = 2048;
    private KeyEvent keyEvent;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
    }
    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public int getScore() {
        return model.score;
    }

    public void resetGame() {
        view.isGameLost = false;
        view.isGameWon = false;
        model.resetGameTiles();
    }
}
