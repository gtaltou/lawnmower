package com.lawnmower.infrastructure;

import com.lawnmower.domain.*;
import com.lawnmower.application.CommandProvider;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class CommandFileAdapter implements CommandProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommandFileAdapter.class);
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(CommandFileAdapter.class);
    @Override
    public List<Command> buildCommand() {
        BufferedReader reader = null;
        List<Command> commands = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader("src/main/resources/input_lawnmower.txt"));
            String line = reader.readLine();
            if (line == null) {
                String emptyFile = "The file is empty.";
                LOGGER.info(emptyFile);
                throw new UnsupportedOperationException(emptyFile);

            }
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
                    String missingCommands = "missing mower commands ";
                    LOGGER.info(missingCommands);
                    throw new UnsupportedOperationException(missingCommands);
                }
                commands.add(command);
                line = reader.readLine();
            }

        } catch (IOException e) {
           e.printStackTrace();
            String readingError = "error reading file.";
            LOGGER.info(readingError);

        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    String fileClosed = "The file was closed after reading.";
                    LOGGER.info(fileClosed);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return commands;
    }
}
