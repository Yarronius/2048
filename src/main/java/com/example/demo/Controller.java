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
    private int WINNING_TILE = 2048;
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
                        view.draw(model.getGameTiles());
                        break;
                    case DOWN:
                        model.down();
                        view.draw(model.getGameTiles());
                        break;
                    case LEFT:
                        model.left();
                        view.draw(model.getGameTiles());
                        break;
                    case RIGHT:
                        model.right();
                        view.draw(model.getGameTiles());
                        break;
                    default:
                        break;
                }
            }
        };
    }
}