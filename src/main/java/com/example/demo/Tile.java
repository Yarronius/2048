package com.example.demo;

import javafx.scene.paint.Color;

import java.util.Objects;

public class Tile {
    private int value = 0;

    public Tile(int value) {
        this.value = value;
    }

    public Tile() {

    }


    public Color getTileColor() {
        switch (value) {
            case 0 : return new Color(0.65,0.6,0.55,1);
            case 2 : return new Color(0.8,0.75,0.65,1);
            case 4 : return new Color(0.9,0.85,0.75,1);
            case 8 : return new Color(0.9,0.65,0.45,1);
            case 16 : return new Color(0.9,0.55,0.35,1);
            case 32 : return new Color(1,0.5,0.35,1);
            case 64 : return new Color(1,0.4,0.35,1);
            case 128 : return new Color(1,0.9,0.5,1);
            case 256 : return new Color(1,0.85,0.5,1);
            case 512 : return new Color(1,0.8,0.4,1);
            case 1024 : return new Color(1,0.65,0.35,1);
            case 2048 : return new Color(1,0.65,0.0,1);
            default : return new Color(1,0.0,0.0,1);
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj != null && getClass().equals(obj.getClass())) {
            Tile o = (Tile) obj;
            return this.getValue() == o.getValue();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
