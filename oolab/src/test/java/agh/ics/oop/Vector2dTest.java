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
        Assertions.assertEquals(new Vector2d(2,5).upperRight(new Vector2d(1,10)),new Vector2d(2,10));
      }

      @Test
    public void lowerLeftTest(){
        Assertions.assertEquals(new Vector2d(2,5).lowerLeft(new Vector2d(1,10)),new Vector2d(1,5));
      }

      @Test
    public void addTest(){
          Assertions.assertEquals(new Vector2d(-1,1).add(new Vector2d(1,-1)),new Vector2d(0,0));
          Assertions.assertEquals(new Vector2d(5,5).add(new Vector2d(6,6)),new Vector2d(11,11));
      }

      @Test
    public void subtractTest(){
          Assertions.assertEquals(new Vector2d(5,5).subtract(new Vector2d(5,5)),new Vector2d(0,0));
          Assertions.assertEquals(new Vector2d(10,0).subtract(new Vector2d(15,10)),new Vector2d(-5,-10));
    }

      @Test
    public void oppositeTest(){
          Assertions.assertEquals(new Vector2d(2,5).opposite(),new Vector2d(-2,-5));
      }
}
