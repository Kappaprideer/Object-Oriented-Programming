package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class OptionsParserTest {

    @Test
    public void parseTestRectangularMap(){
        IWorldMap map = new RectangularMap(100,100);
        Animal animal = new Animal(map);
        map.place(animal);
        String[] arguments = {"forward","f","r","right","l","left","b","backward"};
        OptionsParser parser= new OptionsParser();
        MoveDirection[] moves = parser.parse(arguments);
        for(MoveDirection move : moves){
            animal.move(move);
        }
        Assertions.assertEquals(animal.getPosition(),new Vector2d(2,2));
        Assertions.assertTrue(animal.isOriented(MapDirection.NORTH));
    }
    @Test
    public void parseTestRectangularMap_2(){
        IWorldMap map = new RectangularMap(100,100);
        Animal animal = new Animal(map);
        map.place(animal);
        String[] arguments = {"f","r","f","f", "r", "b", "b", "l", "f"};
        OptionsParser parser= new OptionsParser();
        MoveDirection[] moves = parser.parse(arguments);
        for(MoveDirection move : moves){
            animal.move(move);
        }
        Assertions.assertEquals(animal.getPosition(),new Vector2d(5,5));
        Assertions.assertTrue(animal.isOriented(MapDirection.EAST));
    }

    @Test
    public void parseTestGrassField(){
        IWorldMap map = new GrassField(100);
        Animal animal = new Animal(map);
        map.place(animal);
        String[] arguments = {"forward","f","r","right","l","left","b","backward", "b"};
        OptionsParser parser= new OptionsParser();
        MoveDirection[] moves = parser.parse(arguments);
        for(MoveDirection move : moves){
            animal.move(move);
        }
        Assertions.assertEquals(new Vector2d(2,1),animal.getPosition());
        Assertions.assertTrue(animal.isOriented(MapDirection.NORTH));

    }

    @Test
    public void parseTestGrassField_2(){
        IWorldMap map = new GrassField(100);
        Animal animal = new Animal(map);
        map.place(animal);
        String[] arguments = {"f","r","f","f", "r", "b", "b", "l", "f"};
        OptionsParser parser= new OptionsParser();
        MoveDirection[] moves = parser.parse(arguments);
        for(MoveDirection move : moves){
            animal.move(move);
        }
        Assertions.assertEquals(animal.getPosition(),new Vector2d(5,5));
        Assertions.assertTrue(animal.isOriented(MapDirection.EAST));
    }

    @Test
    public void parseThrowsTestRectangularMap() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IWorldMap map = new RectangularMap(100, 100);
            Animal animal = new Animal(map);
            map.place(animal);
            String[] arguments = {"f", "f", "foo", "b", "b", "l", "b"};
            OptionsParser parser = new OptionsParser();
            MoveDirection[] moves = parser.parse(arguments);
            for (MoveDirection move : moves)
                animal.move(move);
        });
        Assertions.assertEquals(exception.getMessage(),"foo is not legal move specification");
    }

    @Test
    public void parseThrowsTestGrassField() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IWorldMap map = new GrassField(10);
            Animal animal = new Animal(map);
            map.place(animal);
            String[] arguments = {"f", "f", "f", "beck", "b", "l", "b"};
            OptionsParser parser = new OptionsParser();
            MoveDirection[] moves = parser.parse(arguments);
            for (MoveDirection move : moves)
                animal.move(move);
        });
        Assertions.assertEquals(exception.getMessage(),"beck is not legal move specification");
    }

}
