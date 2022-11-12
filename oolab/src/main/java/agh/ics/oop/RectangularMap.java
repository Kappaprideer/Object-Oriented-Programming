package agh.ics.oop;

public class RectangularMap  extends AbstractWorldMap {

    public RectangularMap(int width, int height){
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(this.upperRight) && position.follows(this.lowerLeft) && !this.isOccupied(position);
    }
    void boardCorners(){
    }



}