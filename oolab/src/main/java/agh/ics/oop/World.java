package agh.ics.oop;

import java.util.Arrays;

public class World {
    public static void main (String[] args){
        System.out.println("system wystartował");
        run(directions(args));
        System.out.println("system zakończył działanie");

    }
    static Direction[] directions(String[] arg){
        Direction[] dir = Direction.values();
        int real_lenght=0;
        for(int i=0; i<arg.length; i++){
            if(arg[i].equals("f") || arg[i].equals("b") || arg[i].equals("r") || arg[i].equals("l")){
                switch (arg[i]) {
                    case "f" -> dir[real_lenght] = Direction.FORWARD;
                    case "b" -> dir[real_lenght] = Direction.BACKWARD;
                    case "r" -> dir[real_lenght] = Direction.RIGHT;
                    case "l" -> dir[real_lenght] = Direction.LEFT;
                }
                real_lenght++;
            }
        }
        return Arrays.copyOfRange(dir, 0, real_lenght);
    }

    static void run(Direction[] arg){
        for(int i=0; i<arg.length; i++)
        {
            switch (arg[i]) {
                case FORWARD -> System.out.print("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.print("Zwierzak idzie do tyłu");
                case RIGHT -> System.out.print("Zwierzak skręca w prawo");
                case LEFT -> System.out.print("Zwierzak skręca w lewo");
            }
            if(i+1<arg.length)
                System.out.print(",\n");
        }
        System.out.println();
    }

}


