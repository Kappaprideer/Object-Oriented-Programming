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
        Assertions.assertEquals(animal.toString(), "pozycja: (2,4) orientacja: Wschód");
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.RIGHT);
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
        Assertions.assertEquals(animal.toString(), "pozycja: (0,2) orientacja: Zachód");
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
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

    public void Animal_5(){
        Animal animal = new Animal();
        String[] input = {"f", "f", "forward", "right", "f", "f", "f", "left", "l"};
        OptionsParser parser = new OptionsParser();
        MoveDirection[] moves = parser.parse(input);
        for(MoveDirection move : moves)
            animal.move(move);
        Assertions.assertEquals(animal.toString(), "pozycja: (4,4) orientacja: Zachód");
    }





}
