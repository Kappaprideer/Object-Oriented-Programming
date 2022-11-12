package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class OptionsParserTest {

    @Test
    public void ParseTest_1(){
        IWorldMap map = new RectangularMap(100,100);
        Animal animal = new Animal(map);
        map.place(animal);
        String[] arguments = {"f", "b", "r", "right", "f", "backward", "b", "left", "l", "b", "right", "f"};
        OptionsParser parser= new OptionsParser();
        MoveDirection[] moves = parser.parse(arguments);
        for(MoveDirection move : moves){
            animal.move(move);
        }
        Assertions.assertEquals(animal.getPosition(),new Vector2d(3,2));
        Assertions.assertTrue(animal.isOriented(MapDirection.EAST));
    }

    @Test
    public void ParseTest_2(){
        IWorldMap map = new RectangularMap(100,100);
        Animal animal = new Animal(map);
        map.place(animal);
        String[] arguments = {"f","f","r","f","f","r","f","f","g","foo","r"};
        OptionsParser parser= new OptionsParser();
        MoveDirection[] moves = parser.parse(arguments);
        for(MoveDirection move : moves){
            animal.move(move);
        }
        Assertions.assertEquals(animal.getPosition(),new Vector2d(4,2));
        Assertions.assertTrue(animal.isOriented(MapDirection.WEST));
    }

    @Test
    public void ParseTest_3() {
        IWorldMap map = new RectangularMap(100,100);
        Animal animal = new Animal(map);
        map.place(animal);
        String[] arguments = {"foo", "feee", "fr", "bl", "bb", "ll", "lb"};
        OptionsParser parser = new OptionsParser();
        MoveDirection[] moves = parser.parse(arguments);
        for (MoveDirection move : moves)
            animal.move(move);
        Assertions.assertEquals(animal.getPosition(), new Vector2d(2,2));
        Assertions.assertTrue(animal.isOriented(MapDirection.NORTH));
    }


}
