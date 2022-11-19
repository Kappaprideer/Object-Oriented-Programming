package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {
    public static void main (String[] args){
        try {

//            Application.launch(App.class, args);

            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        // pkt 10
//        Stworzyć publiczną  tablice wypełnioną zerami, jeśli na jakimś polu znajduje się zwierze
//        to w tablicy pod indeksami odpowiadającymi pozycji zwierzęcia znajduje się jedynka lub wskaźnik na zwierze
//        które znajduje się na danym polu.
//        Dodać warunek w Animal.move, aby na danym polu nie mogły stanąć dwa zwierzęta.

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


