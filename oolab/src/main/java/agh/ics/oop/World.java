package agh.ics.oop;
import java.util.Arrays;


public class World {
    public static void main (String[] args){
        System.out.println("system wystartował");
        run(directions(args));
        System.out.println("system zakończył działanie");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-5,3);
        System.out.println(position2);
        Vector2d position3 = new Vector2d(3,5);
        System.out.println(position1.upperRight(position2));
        System.out.println();

    }
    static Direction[] directions(String[] arg){
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


