package agh.ics.oop;

public class Animal {

    private IWorldMap map;
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    public Animal(IWorldMap map){
        this.map=map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        if(!map.isOccupied(initialPosition)) {
            this.map=map;
            position=initialPosition;
        }
    }


    public String toString() {
        return switch (this.orientation) {
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }

    public boolean isAt(Vector2d position){
        return this.position.x==position.x && this.position.y==position.y;
    }

    public void move(MoveDirection direction){
        switch (direction){
            case LEFT -> this.orientation=this.orientation.previous();
            case RIGHT -> this.orientation=this.orientation.next();
            case FORWARD -> {
                if(this.map.canMoveTo(this.position.add(orientation.toUnitVector()))){
                    this.position=this.position.add(orientation.toUnitVector());
                }
            }
            case BACKWARD -> {
                if(this.map.canMoveTo(this.position.add(orientation.toUnitVector().opposite()))) {
                    this.position = this.position.add(orientation.toUnitVector().opposite());
                }
            }
        }
    }








}
