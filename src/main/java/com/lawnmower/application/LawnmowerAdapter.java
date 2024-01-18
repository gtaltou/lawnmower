package com.lawnmower.application;

import com.lawnmower.domain.Position;

import java.util.List;

public class LawnmowerAdapter {

    private final SurfaceExamination surfaceExamination;

    public LawnmowerAdapter() {
        this.surfaceExamination = new SurfaceExamination();
    }

    public List<Position> explore() {
        return surfaceExamination.process();
    }
}
