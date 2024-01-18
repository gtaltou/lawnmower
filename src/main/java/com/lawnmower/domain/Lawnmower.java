package com.lawnmower.domain;

public class Lawnmower {

    private Position position;

    public Lawnmower(Position position) {
        this.position = position;
    }

    public Position executeInstructions(Instruction... instructions) {
        for (Instruction instruction :
                instructions) {
            switch (instruction) {
                case D:
                case G :
                    this.position.rotate(instruction);
                    break;
                case A :
                    this.position.move();
                    break;
                default: throw new UnsupportedOperationException(instruction + "Is not a managed command");
            }
        }
        return this.position;
    }



    public Position getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        return "Tondeuse{" +
                "position=" + position +
                '}';
    }
}
