package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private static Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    private Stack<Tile[][]> gameLogger = new Stack<>();
    private int score = 0;
    private int maxTile = 0;

    public Model() {
        resetGameTiles();
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (Tile[] tiles : gameTiles) {
            for (Tile tile : tiles) {
                if (tile.getValue() == 0) emptyTiles.add(tile);
            }
        }
        return emptyTiles;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (!emptyTiles.isEmpty()) {
            emptyTiles.get((int) (emptyTiles.size() * Math.random())).setValue((Math.random() < 0.9 ? 2 : 4));
        }
    }

    void resetGameTiles() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile(0);
            }
        }
        addTile();
        addTile();
        logStep();
    }

    private boolean compressTiles(Tile[] tiles) {
        Tile[] result = new Tile[FIELD_WIDTH];
        for (int i = 0 ; i < 4; i++) {
            result[i] = new Tile();
        }
        for (int i = 0, j = 0, k = 0; i < FIELD_WIDTH; i++) {
            if (tiles[i].getValue() == 0) {
                result[FIELD_WIDTH - 1 - j++] = tiles[i];
            } else {
                result[k++] = tiles[i];
            }
        }
        if (Arrays.equals(tiles, result)) return false;
        for (int i = 0; i < 4; i++) {
            tiles[i] = result[i];
        }
        return true;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].getValue() != 0 && tiles[i].getValue() == tiles[i + 1].getValue()) {
                isChanged = true;
                int scoreIncrement = tiles[i].getValue() * 2;
                tiles[i].setValue(tiles[i].getValue() * 2);
                tiles[i + 1].setValue(0);
                compressTiles(tiles);
                score += scoreIncrement;
                if (scoreIncrement > maxTile) maxTile = scoreIncrement;
            }
        }
        return isChanged;
    }

    void left() {
        boolean isCompressed;
        boolean isMerged;
        boolean isNewNumberNeeded = false;
        for (int i = 0; i < 4; i++) {
            isCompressed = compressTiles(gameTiles[i]);
            isMerged = mergeTiles(gameTiles[i]);
            if(isMerged) {
                compressTiles(gameTiles[i]);
            }

            if(isCompressed || isMerged) {
                isNewNumberNeeded = true;
            }
        }
        if (isNewNumberNeeded) {
            addTile();
        }
    }

    void up() {
        turn();
        turn();
        turn();
        left();
        turn();
    }

    void right() {
        turn();
        turn();
        left();
        turn();
        turn();
    }

    void down() {
        turn();
        left();
        turn();
        turn();
        turn();
    }

    void turn() {
        Tile[][] temp = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                temp[j][FIELD_WIDTH - i - 1] = gameTiles[i][j];
            }
        }
        gameTiles = temp;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (gameTiles[y][x].getValue() == 0) {
                    return true;
                } else if (y < 3 && gameTiles[y][x].getValue() == gameTiles[y + 1][x].getValue()) {
                    return true;
                } else if (x < 3 && gameTiles[y][x].getValue() == gameTiles[y][x + 1].getValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getScore() {
        return score;
    }

    public int getMaxTile() {
        return maxTile;
    }

    public void logStep() {
        Tile[][] logArray = new Tile[4][4];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                logArray[i][j] = new Tile(gameTiles[i][j].getValue());
            }
        }
        gameLogger.add(logArray);
    }

    public Stack<Tile[][]> getGameLogger() {
        return gameLogger;
    }

    public void setGameTiles(Tile[][] gameTiles) {
        Model.gameTiles = gameTiles;
    }
}
