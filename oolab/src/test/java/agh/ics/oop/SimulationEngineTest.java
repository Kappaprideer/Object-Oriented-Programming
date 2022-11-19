package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimulationEngineTest {

    @Test
    public void overallTest_1(){
        String[] args = {"f", "b","r","l","f","f","r","r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        Assertions.assertEquals(engine.getAnimals().size(), 2);
        Assertions.assertEquals(engine.getAnimals().get(0).getPosition(), new Vector2d(2,0));
        Assertions.assertEquals(engine.getAnimals().get(1).getPosition(), new Vector2d(3,5));
    }

    @Test
    public void overallTest_2(){
        String[] args = {"f", "b","r","l","f","f","r","r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 20);
        Vector2d[] positions = { new Vector2d(1,2), new Vector2d(10,10)};
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        Assertions.assertEquals(engine.getAnimals().size(), 2);
        Assertions.assertEquals(engine.getAnimals().get(0).getPosition(), new Vector2d(2,0));
        Assertions.assertEquals(engine.getAnimals().get(1).getPosition(), new Vector2d(9,13));
    }
}
