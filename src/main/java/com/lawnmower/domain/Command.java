package com.lawnmower.domain;

import java.util.List;

public class Command {

    private Position startPosition;
    private List<Instruction> instructions;

    public Command(Position position) {
        this.startPosition = position;
    }

    public void setCommands(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public List<Instruction> getInstructions() {
        return this.instructions;
    }
}
