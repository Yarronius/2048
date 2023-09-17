package com.example.demo;

import com.example.demo.Model;
import com.example.demo.Tile;
import com.example.demo.View;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Arrays;

public class Controller {
    private Model model;
    private View view;
    private int WINNING_TILE = 64;
    private EventHandler<KeyEvent> eventHandler;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
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

    public EventHandler<KeyEvent> getEventHandler() {
        eventHandlerProcessor();
        return eventHandler;
    }

    private void eventHandlerProcessor() {
        eventHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                switch (keyEvent.getCode()) {
                    case UP:
                        model.up();
                        gameCheckout();
                        break;
                    case DOWN:
                        model.down();
                        gameCheckout();
                        break;
                    case LEFT:
                        model.left();
                        gameCheckout();
                        break;
                    case RIGHT:
                        model.right();
                        gameCheckout();
                        break;
                    default:
                        break;
                }
            }
        };
    }

    private boolean isGameWon() {
        Tile tiles[][] = getGameTiles();
        for (Tile[] tile : tiles) {
            for (Tile t : tile) {
                if(t.getValue() == WINNING_TILE) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isGameLost() {
        if(!model.canMove() && !isGameWon()) {
            return true;
        }
        return false;
    }

    private void gameCheckout() {
        view.draw(model.getGameTiles());
        String result = "";
        if(isGameWon() || isGameLost()) {
            result = isGameWon() ? "Вы выграли!" : "Вы проиграли!";
            view.gameEnded(getGameTiles(), result, String.valueOf(model.score), String.valueOf(model.maxTile));
            resetGame();
        }
    }
}
