package com.lawnmower.domain;


import java.util.List;

public class Coordination {

    private int x;
    private int y;
    private final int MAX_X;
    private final int MAX_Y;

    public Coordination(int x, int y, int max_x, int max_y) {
        this.x = x;
        this.y = y;
        MAX_X = max_x;
        MAX_Y = max_y;
    }

    public void moveY(int step) {
        if(isValidY(step + this.y)) {
            this.y += step;
        }
    }

    public int getY() {
        return this.y;
    }

    public void moveX(int step) {
        if(isValidX(this.x + step)) {
            this.x += step;
        }
    }

    public int getX() {
        return this.x;
    }

    private boolean isValidX(int newX) {
        return newX >= 0 && newX <= MAX_X;
    }

    private boolean isValidY(int newY) {
        return newY >= 0 && newY <= MAX_Y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                ", MAX_X=" + MAX_X +
                ", MAX_Y=" + MAX_Y +
                '}';
    }
}
