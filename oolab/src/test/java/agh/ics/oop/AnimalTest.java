package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class AnimalTest {

    @Test
    public void Righ_and_Up_Border_Test(){
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.RIGHT);
        Assertions.assertTrue(animal.isAt(new Vector2d(2,4)));
        Assertions.assertEquals(animal.toString(), "pozycja: (2,4) orientacja: Wschód");
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.RIGHT);
        Assertions.assertTrue(animal.isAt(new Vector2d(4,4)));
        Assertions.assertEquals(animal.toString(), "pozycja: (4,4) orientacja: Południe");
    }

    @Test
    public void Lef_and_Bottom_Border_Test(){
        Animal animal = new Animal();
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        Assertions.assertTrue(animal.isAt(new Vector2d(0,2)));
        Assertions.assertEquals(animal.toString(), "pozycja: (0,2) orientacja: Zachód");
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        Assertions.assertTrue(animal.isAt(new Vector2d(0,0)));
        Assertions.assertEquals(animal.toString(), "pozycja: (0,0) orientacja: Północ");
    }
    @Test
    public void OrientationTest_1(){
        Animal animal = new Animal();
        animal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(animal.toString(),"pozycja: (2,2) orientacja: Wschód");
        animal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(animal.toString(),"pozycja: (2,2) orientacja: Południe");
        animal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(animal.toString(),"pozycja: (2,2) orientacja: Zachód");
        animal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(animal.toString(),"pozycja: (2,2) orientacja: Północ");
    }
    @Test
    public void OrientationTest_2(){
        Animal animal = new Animal();
        animal.move(MoveDirection.LEFT);
        Assertions.assertEquals(animal.toString(),"pozycja: (2,2) orientacja: Zachód");
        animal.move(MoveDirection.LEFT);
        Assertions.assertEquals(animal.toString(),"pozycja: (2,2) orientacja: Południe");
        animal.move(MoveDirection.LEFT);
        Assertions.assertEquals(animal.toString(),"pozycja: (2,2) orientacja: Wschód");
        animal.move(MoveDirection.LEFT);
        Assertions.assertEquals(animal.toString(),"pozycja: (2,2) orientacja: Północ");
    }
    @Test
    public void movingTest(){
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        Assertions.assertTrue(animal.isAt(new Vector2d(2,3)));
        Assertions.assertEquals(animal.toString(), "pozycja: (2,3) orientacja: Północ");
        animal.move(MoveDirection.LEFT);
        Assertions.assertTrue(animal.isAt(new Vector2d(2,3)));
        Assertions.assertEquals(animal.toString(), "pozycja: (2,3) orientacja: Zachód");
        animal.move(MoveDirection.BACKWARD);
        Assertions.assertTrue(animal.isAt(new Vector2d(3,3)));
        Assertions.assertEquals(animal.toString(), "pozycja: (3,3) orientacja: Zachód");
        animal.move(MoveDirection.BACKWARD);
        Assertions.assertTrue(animal.isAt(new Vector2d(4,3)));
        Assertions.assertEquals(animal.toString(), "pozycja: (4,3) orientacja: Zachód");
        animal.move(MoveDirection.RIGHT);
        Assertions.assertTrue(animal.isAt(new Vector2d(4,3)));
        Assertions.assertEquals(animal.toString(), "pozycja: (4,3) orientacja: Północ");
        animal.move(MoveDirection.FORWARD);
        Assertions.assertTrue(animal.isAt(new Vector2d(4,4)));
        Assertions.assertEquals(animal.toString(), "pozycja: (4,4) orientacja: Północ");
        animal.move(MoveDirection.RIGHT);
        Assertions.assertTrue(animal.isAt(new Vector2d(4,4)));
        Assertions.assertEquals(animal.toString(), "pozycja: (4,4) orientacja: Wschód");
        animal.move(MoveDirection.BACKWARD);
        Assertions.assertTrue(animal.isAt(new Vector2d(3,4)));
        Assertions.assertEquals(animal.toString(), "pozycja: (3,4) orientacja: Wschód");
    }





}
