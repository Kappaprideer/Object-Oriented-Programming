package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class OptionsParserTest {

    @Test
    public void ParseTest_1(){
        Animal animal = new Animal();
        String[] arguments = {"f", "b", "r", "right", "f", "backward", "b", "left", "l", "b", "right", "f"};
        OptionsParser parser= new OptionsParser();
        MoveDirection[] moves = parser.parse(arguments);
        for(MoveDirection move : moves){
            animal.move(move);
        }
        Assertions.assertEquals(animal.toString(),"pozycja: (3,2) orientacja: Wschód");
    }

}
