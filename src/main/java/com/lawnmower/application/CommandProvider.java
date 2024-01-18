package com.lawnmower.application;

import com.lawnmower.domain.Command;

import java.util.List;

public interface CommandProvider {

    List<Command> buildCommand();
}
