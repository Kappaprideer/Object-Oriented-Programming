package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public String toString() {
        return "pozycja: " + position.toString() + " orientacja: " + orientation.toString();
    }

    public boolean isAt(Vector2d position){
        return this.position.x==position.x && this.position.y==position.y;
    }

    public void move(MoveDirection direction){
        switch (direction){
            case LEFT -> this.orientation=this.orientation.previous();
            case RIGHT -> this.orientation=this.orientation.next();
            case FORWARD -> {
                if(this.position.add(orientation.toUnitVector()).precedes(new Vector2d(4,4))
                        && this.position.add(orientation.toUnitVector()).follows(new Vector2d(0,0))){
                    this.position=this.position.add(orientation.toUnitVector());
                }
            }
            case BACKWARD -> {
                if(this.position.add(orientation.toUnitVector().opposite()).precedes(new Vector2d(4,4))
                        && this.position.add(orientation.toUnitVector().opposite()).follows(new Vector2d(0,0))){
                    this.position = this.position.add(orientation.toUnitVector().opposite());
                }
            }
        }
    }








}
