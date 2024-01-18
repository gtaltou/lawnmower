package com.lawnmower.domain;

import static com.lawnmower.domain.Instruction.G;

public enum Orientation {

    N () {
        Orientation rotate(Instruction instruction) {
            return instruction == G ? W : E;
        }
    },
    S () {
        Orientation rotate(Instruction instruction) {
            return instruction == G ? E : W;
        }
    },
    W () {
        Orientation rotate(Instruction instruction) {
            return instruction == G ? S : N;
        }
    },
    E() {
        Orientation rotate(Instruction instruction) {
            return instruction == G ? N : S;
        }
    };

    abstract Orientation rotate(Instruction instruction);

}
