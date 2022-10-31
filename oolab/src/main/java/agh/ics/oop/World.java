package agh.ics.oop;
import java.util.Arrays;

public class World {
    public static void main (String[] args){

        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

//        Animal animal = new Animal();
//
//        System.out.println(animal);
//
//        OptionsParser parsing = new OptionsParser();
//        MoveDirection[] moves = parsing.parse(args);
//        for(MoveDirection current_move : moves){
//            animal.move(current_move);
//        }

        // pkt. 10
//        Stworzyć publiczną  tablice wypełnioną zerami, jeśli na jakimś polu znajduje się zwierze
//        to w tablicy pod indeksami odpowiadającymi pozycji zwierzęcia znajduje się jedynka lub wskaźnik na zwierze
//        które znajduje się na danym polu.
//        Dodać warunek w Animal.move, aby na danym polu nie mogły stanąć dwa zwierzęta.


//        animal.move(MoveDirection.RIGHT);
//        animal.move(MoveDirection.FORWARD);
//        animal.move(MoveDirection.FORWARD);
//        animal.move(MoveDirection.FORWARD);

//        System.out.println(animal);

//        System.out.println("system wystartował");
//        run(Direction.change(args));
//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));
//        System.out.println("system zakończył działanie");

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


