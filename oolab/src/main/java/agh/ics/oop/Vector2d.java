package agh.ics.oop;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString(){
        String s = "(" + this.x + "," + this.y + ")";
        return s;
    }

    boolean precedes(Vector2d other){
        return this.x <= other.x && this.y <= other.y;
    }

    boolean follows(Vector2d other){
        return this.x >= other.x && this.y >= other.y;
    }

    Vector2d upperRight(Vector2d other){
        return new Vector2d(Math.max(this.x,other.x),Math.max(this.y,other.y));
    }

    Vector2d lowerLeft(Vector2d other){
        return new Vector2d(Math.min(this.x,other.x),Math.min(this.y,other.y));
    }

    Vector2d add(Vector2d other){
        return new Vector2d(this.x+other.x, this.y+other.y);
    }

    Vector2d subtract(Vector2d other){
        return new Vector2d(this.x-other.x,this.y-other.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector2d vector2d = (Vector2d) o;

        if (x != vector2d.x) return false;
        return y == vector2d.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    Vector2d opposite(){
        return new Vector2d(-this.x,-this.y);
    }

    public static Vector2d getRandomIntPosition(double min,double max){
        min = (int) Math.ceil(min);
        max = (int) Math.floor(max);
        int x= (int) Math.floor(Math.random() * (max - min + 1) + min);
        int y = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return new Vector2d(x,y);
    }

}
