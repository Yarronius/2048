package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private static Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];;
    int score = 0;
    int maxTile = 0;

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
        System.out.println("Shift not done" + Arrays.equals(tiles, result));
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
                i++;
                if (scoreIncrement > maxTile) maxTile = scoreIncrement;
            }
        }
        return isChanged;
    }

    void left() {
        boolean isCompressed = false;
        boolean isMerged = false;
        boolean isNewNumberNeeded = false;
        for (int i = 0; i < 4; i++) {
            isCompressed = compressTiles(gameTiles[i]);
            isMerged = mergeTiles(gameTiles[i]);
            if(isCompressed || isMerged) {
                isNewNumberNeeded = true;
            }
        }
        if (isNewNumberNeeded) {
            System.out.println("NEW TILE ADDED");
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
        if (!getEmptyTiles().isEmpty()) return true;
        return false;
    }
}
