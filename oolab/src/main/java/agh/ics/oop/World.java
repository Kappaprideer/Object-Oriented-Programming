package agh.ics.oop;
import java.util.Arrays;

public class World {
    public static void main (String[] args){
        System.out.println("system wystartował");

        //run(Direction.change(args));

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println("system zakończył działanie");

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


