package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {

    @Test
    public void equalsTest(){
        Assertions.assertTrue(new Vector2d(-10,20).equals(new Vector2d(-10,20)));
        Assertions.assertFalse(new Vector2d(0,0).equals(new Vector2d(100,0)));
      }

      @Test
    public void toStringTest(){
        Assertions.assertEquals(new Vector2d(88,55).toString(),"(88,55)");
        Assertions.assertEquals(new Vector2d(-10,-99).toString(),"(-10,-99)");
      }

      @Test
    public void precedesTest(){
        Assertions.assertTrue(new Vector2d(5,10).precedes(new Vector2d(6,11)));
        Assertions.assertFalse(new Vector2d(10,8).precedes(new Vector2d(0,8)));
      }

      @Test
    public void followsTest(){
          Assertions.assertTrue(new Vector2d(20,0).follows(new Vector2d(0,-11)));
          Assertions.assertFalse(new Vector2d(10,8).follows(new Vector2d(11,8)));
      }

      @Test
    public void upperRightTest(){
        Assertions.assertEquals(new Vector2d(2,5).upperRight(new Vector2d(1,10)),new Vector);
      }

      @Test
    public void lowerLeftTest(){

      }

      @Test
    public void addTest(){

      }

      @Test
    public void subtractTest(){

      }

      @Test
    public void oppositeTest(){

      }
}
