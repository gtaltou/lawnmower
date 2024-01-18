package com.lawnmower.domain;

public class Position {

    private Coordination cordination;
    private Orientation orientation;

    public Position(Coordination cordination, Orientation orientation) {
        this.cordination = cordination;
        this.orientation = orientation;
    }

    public void move() {
        switch (this.orientation) {
            case E : cordination.moveX(1); break;
            case W : cordination.moveX(-1); break;
            case N : cordination.moveY(1); break;
            case S : cordination.moveY(-1); break;
        }
    }

    public int getY() {
        return this.cordination.getY();
    }

    public int getX() {
        return this.cordination.getX();
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public void rotate(Instruction instruction) {
        this.orientation = this.orientation.rotate(instruction);
    }

    @Override
    public String toString() {
        return cordination.getX() + " " + cordination.getY() + " " + orientation;
    }
}
