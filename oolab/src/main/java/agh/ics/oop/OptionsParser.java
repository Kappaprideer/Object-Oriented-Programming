package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {

    public MoveDirection[] parse(String[] args){
        int lenght=0;
        MoveDirection[] move_directions = new MoveDirection[args.length];
        for(String argument : args) {
            switch (argument) {
                case "f", "forward" -> {
                    move_directions[lenght] = MoveDirection.FORWARD;
                    lenght++;
                }
                case "b", "backward" -> {
                    move_directions[lenght] = MoveDirection.BACKWARD;
                    lenght++;
                }
                case "r", "right" -> {
                    move_directions[lenght] = MoveDirection.RIGHT;
                    lenght++;
                }
                case "l", "left" -> {
                    move_directions[lenght] = MoveDirection.LEFT;
                    lenght++;
                }
                default -> throw new IllegalArgumentException(argument + " is not legal move specification");
            }

        }
        return Arrays.copyOfRange(move_directions,0,lenght);
    }

}
