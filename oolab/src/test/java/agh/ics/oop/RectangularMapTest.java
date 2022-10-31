package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.List;
import java.util.LinkedList;

public class RectangularMapTest {


    @Test
    public void placeTest(){

        String[] args = {"f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(0,4)};
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
//        List<Animal> animals = engine.animals;
//        Assertions.assertEquals(animals.size(),2);
    }


}
