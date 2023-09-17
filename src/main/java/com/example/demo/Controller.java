package com.example.demo;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.util.EmptyStackException;

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


    public void resetGame() {
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
                        model.logStep();
                        gameCheckout();
                        break;
                    case DOWN:
                        model.down();
                        model.logStep();
                        gameCheckout();
                        break;
                    case LEFT:
                        model.left();
                        model.logStep();
                        gameCheckout();
                        break;
                    case RIGHT:
                        model.right();
                        model.logStep();
                        gameCheckout();
                        break;
                    case ESCAPE:
                        System.exit(0);
                    case Z :
                        if(keyEvent.isControlDown()) {
                            oneStepBack();
                            view.draw(model.getGameTiles());
                        }
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
            view.gameEnded(getGameTiles(), result, String.valueOf(model.getScore()), String.valueOf(model.getMaxTile()));
            resetGame();
        }
    }

    private void oneStepBack() {
        try {
            Tile[][] oneStepBackState = model.getGameLogger().pop();
            model.setGameTiles(oneStepBackState);
        } catch (EmptyStackException e) {

        }
    }
}
