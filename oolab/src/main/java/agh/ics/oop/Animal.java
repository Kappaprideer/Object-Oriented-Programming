package agh.ics.oop;

import java.util.Objects;

public class Animal implements IMapElement{

    private IWorldMap map;
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public Animal(){
    }

    public Animal(IWorldMap map){
        this.map=map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map=map;
        this.position=initialPosition;

    }

    public String toString() {
        return this.orientation.toString();
    }

    public Vector2d getPosition() {
        return position;
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