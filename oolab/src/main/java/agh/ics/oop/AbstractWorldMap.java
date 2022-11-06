package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {

    protected final IWorldMap map = this;
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;
    MapVisualizer visualizer = new MapVisualizer(this.map);

    protected List<Animal> animals = new LinkedList<>();


    public boolean isOccupied(Vector2d position) {
        for(Animal animal : this.animals){
            if(animal.isAt(position)){
                return true;
            }
        }
        return false;
    }

    public boolean place(Animal animal) {
        for(Animal livingAnimal : this.animals){
            if(livingAnimal.isAt(animal.getPosition()) || !map.canMoveTo(animal.getPosition())){
                return false;
            }
        }
        this.animals.add(animal);
        return true;
    }

    public Object objectAt(Vector2d position) {
        for(Animal animal : this.animals){
            if(animal.isAt(position))
                return animal;
        }
        return null;
    }

    abstract void boardCorners();
    public String toString(){
        boardCorners();
        return visualizer.draw(this.lowerLeft,this.upperRight);
    }

}
