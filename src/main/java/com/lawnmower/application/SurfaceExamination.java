package com.lawnmower.application;

import com.lawnmower.application.CommandProvider;
import com.lawnmower.domain.Command;
import com.lawnmower.domain.Instruction;
import com.lawnmower.domain.Lawnmower;
import com.lawnmower.domain.Position;
import com.lawnmower.infrastructure.CommandFileAdapter;

import java.util.List;
import java.util.stream.Collectors;

public class SurfaceExamination {

    private final CommandProvider commandProvider;

    public SurfaceExamination() {
        commandProvider = new CommandFileAdapter();
    }

    public List<Position> process() {
        List<Command> commands = commandProvider.buildCommand();
        return commands.stream()
                .map(command -> new Lawnmower(command.getStartPosition()).executeInstructions(command.getInstructions()
                        .toArray(new Instruction[0])))
                .collect(Collectors.toList());
    }
}
