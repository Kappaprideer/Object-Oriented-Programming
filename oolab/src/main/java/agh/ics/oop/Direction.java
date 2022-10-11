package agh.ics.oop;

import java.util.Arrays;

public enum Direction {
    FORWARD,
    BACKWARD,
    RIGHT,
    LEFT;

    public static Direction[] change(String[] arg){
        Direction[] dir = new Direction[arg.length];
        int real_length=0;
        for (String s : arg) {
            if (s.equals("f") || s.equals("b") || s.equals("r") || s.equals("l")) {
                switch (s) {
                    case "f" -> dir[real_length] = Direction.FORWARD;
                    case "b" -> dir[real_length] = Direction.BACKWARD;
                    case "r" -> dir[real_length] = Direction.RIGHT;
                    case "l" -> dir[real_length] = Direction.LEFT;
                }
                real_length++;
            }
        }
        return Arrays.copyOfRange(dir, 0, real_length);
    }


}
