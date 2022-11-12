package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class AnimalTest {

    @Test
    public void Righ_and_Up_Border_Test(){
        IWorldMap map = new RectangularMap(4,4);
        Animal animal = new Animal(map);
        map.place(animal);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.RIGHT);
        Assertions.assertTrue(animal.isAt(new Vector2d(2,4)));
        Assertions.assertTrue(animal.isOriented(MapDirection.EAST));
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.RIGHT);
        Assertions.assertTrue(animal.isAt(new Vector2d(4,4)));
        Assertions.assertTrue(animal.isOriented(MapDirection.SOUTH));
    }

    @Test
    public void Lef_and_Bottom_Border_Test(){
        IWorldMap map = new RectangularMap(4,4);
        Animal animal = new Animal(map);
        map.place(animal);
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        Assertions.assertTrue(animal.isAt(new Vector2d(0,2)));
        Assertions.assertTrue(animal.isOriented(MapDirection.WEST));
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        Assertions.assertTrue(animal.isAt(new Vector2d(0,0)));
        Assertions.assertTrue(animal.isOriented(MapDirection.NORTH));
    }
    @Test
    public void OrientationTest_1(){
        IWorldMap map = new RectangularMap(4,4);
        Animal animal = new Animal(map);
        map.place(animal);
        animal.move(MoveDirection.RIGHT);
        Assertions.assertTrue(animal.isAt(new Vector2d(2,2)));
        Assertions.assertTrue(animal.isOriented(MapDirection.EAST));
        animal.move(MoveDirection.RIGHT);
        Assertions.assertTrue(animal.isAt(new Vector2d(2,2)));
        Assertions.assertTrue(animal.isOriented(MapDirection.SOUTH));
        animal.move(MoveDirection.RIGHT);
        Assertions.assertTrue(animal.isAt(new Vector2d(2,2)));
        Assertions.assertTrue(animal.isOriented(MapDirection.WEST));
        animal.move(MoveDirection.RIGHT);
        Assertions.assertTrue(animal.isAt(new Vector2d(2,2)));
        Assertions.assertTrue(animal.isOriented(MapDirection.NORTH));
    }
    @Test
    public void OrientationTest_2(){
        IWorldMap map = new RectangularMap(4,4);
        Animal animal = new Animal(map);
        map.place(animal);
        animal.move(MoveDirection.LEFT);
        Assertions.assertTrue(animal.isAt(new Vector2d(2,2)));
        Assertions.assertTrue(animal.isOriented(MapDirection.WEST));
        animal.move(MoveDirection.LEFT);
        Assertions.assertTrue(animal.isAt(new Vector2d(2,2)));
        Assertions.assertTrue(animal.isOriented(MapDirection.SOUTH));
        animal.move(MoveDirection.LEFT);
        Assertions.assertTrue(animal.isAt(new Vector2d(2,2)));
        Assertions.assertTrue(animal.isOriented(MapDirection.EAST));
        animal.move(MoveDirection.LEFT);
        Assertions.assertTrue(animal.isAt(new Vector2d(2,2)));
        Assertions.assertTrue(animal.isOriented(MapDirection.NORTH));
    }
    @Test
    public void movingTest(){
        IWorldMap map = new RectangularMap(4,4);
        Animal animal = new Animal(map);
        map.place(animal);
        animal.move(MoveDirection.FORWARD);
        Assertions.assertTrue(animal.isAt(new Vector2d(2,3)));
        Assertions.assertTrue(animal.isOriented(MapDirection.NORTH));
        animal.move(MoveDirection.LEFT);
        Assertions.assertTrue(animal.isAt(new Vector2d(2,3)));
        Assertions.assertTrue(animal.isOriented(MapDirection.WEST));
        animal.move(MoveDirection.BACKWARD);
        Assertions.assertTrue(animal.isAt(new Vector2d(3,3)));
        Assertions.assertTrue(animal.isOriented(MapDirection.WEST));
        animal.move(MoveDirection.BACKWARD);
        Assertions.assertTrue(animal.isAt(new Vector2d(4,3)));
        Assertions.assertTrue(animal.isOriented(MapDirection.WEST));
        animal.move(MoveDirection.RIGHT);
        Assertions.assertTrue(animal.isAt(new Vector2d(4,3)));
        Assertions.assertTrue(animal.isOriented(MapDirection.NORTH));
        animal.move(MoveDirection.FORWARD);
        Assertions.assertTrue(animal.isAt(new Vector2d(4,4)));
        Assertions.assertTrue(animal.isOriented(MapDirection.NORTH));
        animal.move(MoveDirection.RIGHT);
        Assertions.assertTrue(animal.isAt(new Vector2d(4,4)));
        Assertions.assertTrue(animal.isOriented(MapDirection.EAST));
        animal.move(MoveDirection.BACKWARD);
        Assertions.assertTrue(animal.isAt(new Vector2d(3,4)));
        Assertions.assertTrue(animal.isOriented(MapDirection.EAST));
    }





}
