package com.lawnmower;

import com.lawnmower.application.LawnmowerAdapter;
import com.lawnmower.domain.Position;

import java.util.stream.Collectors;

public class runLawnmower {

    public static void main(String[] args) {
        System.out.println(new LawnmowerAdapter().explore().stream().map(Position::toString).collect(Collectors.joining(" ")));
    }
}
