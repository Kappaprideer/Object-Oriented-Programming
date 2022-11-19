package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrassFIeldTest {

    @Test
    public void placeCorrectlyTest(){
        String[] args = {"f", "b", "f", "b"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(10,5)};
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        Assertions.assertEquals(engine.getAnimals().size(),2);
        Assertions.assertEquals(engine.getAnimals().get(0).getPosition(), new Vector2d(0,2));
        Assertions.assertEquals(engine.getAnimals().get(1).getPosition(), new Vector2d(10,3));
    }

    @Test
    public void placeThrowsTest(){
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String[] args = {"f", "b", "f", "b"};
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(5,5), new Vector2d(0,0), new Vector2d(5,5), new Vector2d(10,5)};
            SimulationEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();});
        Assertions.assertEquals(exception.getMessage(),"Can't add animal, positoin: (5,5) is currently occupied.");

    }

    @Test
    public void objecAtTest(){
        IWorldMap map = new GrassField(5);
        Animal animal = new Animal(map, new Vector2d(5,5));
        map.place(animal);
        Assertions.assertEquals(map.objectAt(new Vector2d(5,5)), animal);
    }

    @Test
    public void isOccupiedTest(){
        IWorldMap map = new GrassField(20);
        Animal animal_1 = new Animal(map, new Vector2d(0,0));
        Animal animal_2 = new Animal(map, new Vector2d(10,5));
        map.place(animal_1);
        map.place(animal_2);
        Assertions.assertTrue(map.isOccupied(new Vector2d(0,0)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(10, 5)));
    }

    @Test
    public void canMoveTest(){
        IWorldMap map = new GrassField(30);
        Animal animal_1 = new Animal(map, new Vector2d(0,0));
        Animal animal_2 = new Animal(map, new Vector2d(1,0));
        map.place(animal_1);
        map.place(animal_2);
        Assertions.assertTrue(map.canMoveTo(new Vector2d(0,1)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(1,0)));
    }


}
