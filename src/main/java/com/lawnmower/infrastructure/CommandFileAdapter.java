package com.lawnmower.infrastructure;

import com.lawnmower.domain.*;
import com.lawnmower.application.CommandProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandFileAdapter implements CommandProvider {

    @Override
    public List<Command> buildCommand() {
        BufferedReader reader = null;
        List<Command> commands = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/input_lawnmower.txt"));
            String line = reader.readLine();
            if (line == null) throw new UnsupportedOperationException("The file is empty.");
            Scanner lineScan = new Scanner(line);
            int max_x = lineScan.nextInt();
            int max_y = lineScan.nextInt();

            line = reader.readLine();
            while (line != null && !line.isEmpty()) {
                //read origin
                lineScan = new Scanner(line);
                int x = lineScan.nextInt();
                int y = lineScan.nextInt();
                String orientation = lineScan.next();
                Command command = new Command(new Position(new Coordination(x,y,max_x,max_y), Orientation.valueOf(orientation)));
                line = reader.readLine();
                if (line != null && !line.isEmpty()) {
                    List<Instruction> instructions = new ArrayList<>();
                    for (String s : line.split("")) {
                        instructions.add(Instruction.valueOf(s));
                    }
                    command.setCommands(instructions);
                } else {
                    throw new UnsupportedOperationException("mower commands are missing");
                }
                commands.add(command);
                line = reader.readLine();
            }

        } catch (IOException e) {
           e.printStackTrace();

        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return commands;
    }
}
