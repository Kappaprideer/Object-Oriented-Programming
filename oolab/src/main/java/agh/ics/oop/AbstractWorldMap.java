package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected final IWorldMap map = this;
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;
    MapVisualizer visualizer = new MapVisualizer(this.map);

    protected Map<Vector2d, Animal> animals = new HashMap<>();


    public boolean isOccupied(Vector2d position) {
        Animal animal = animals.get(position);
        return animal != null;
    }

    public boolean place(Animal animal) {
        if(animals.get(animal.getPosition())!=null || !map.canMoveTo(animal.getPosition())){
            throw new IllegalArgumentException("Can't add animal, positoin: " + animal.getPosition().toString() + " is currently occupied.");
        }
        this.animals.put(animal.getPosition(),animal);
        animal.addObserver(this);
        return true;
    }

    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    abstract void boardCorners();

    public Vector2d getLowerLeft(){
        return this.lowerLeft;
    }
    public Vector2d getUpperRight(){
        return this.upperRight;
    }


    public String toString(){
        boardCorners();
        return visualizer.draw(this.lowerLeft,this.upperRight);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal=animals.remove(oldPosition);
        animals.put(newPosition,animal);
    }

}
