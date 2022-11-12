package agh.ics.oop;


import java.util.ArrayList;
import java.util.List;

public class Animal implements IMapElement{

    private IWorldMap map;
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private List<IPositionChangeObserver> observerList = new ArrayList<>();

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

    public Boolean isOriented(MapDirection orientation){
        return this.orientation==orientation;
    }
    public boolean isAt(Vector2d position){
        return this.position.x==position.x && this.position.y==position.y;
    }

    public void move(MoveDirection direction){
        switch (direction){
            case LEFT -> this.orientation=this.orientation.previous();
            case RIGHT -> this.orientation=this.orientation.next();
            case FORWARD -> {
                Vector2d newPosition= this.position.add(orientation.toUnitVector());
                if(this.map.canMoveTo(newPosition)){
                    positionChanged(this.position,newPosition);
                    this.position=newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = this.position.add(orientation.toUnitVector().opposite());
                if(this.map.canMoveTo(newPosition)) {
                    positionChanged(this.position,newPosition);
                    this.position = newPosition;
                }
            }
        }
    }


    void removeObserver(IPositionChangeObserver observer){
        observerList.remove(observer);
    }
    void addObserver(IPositionChangeObserver observer){
        observerList.add(observer);
    }

    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer : observerList){
            observer.positionChanged(oldPosition,newPosition);
        }
    }
}