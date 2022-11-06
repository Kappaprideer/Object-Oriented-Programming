package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import static java.lang.Math.min;
import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{

    private final IWorldMap map = this;
    private final int numOfFields;

    private Vector2d lowerLeft = new Vector2d(0,0);
    private Vector2d upperRight = new Vector2d(0,0);

    private List<Grass> grassList = new LinkedList<>();
    private List<Animal> animals = new LinkedList<>();



    public GrassField(int numOfFields){
        this.numOfFields=numOfFields;
        for(int i=0; i<numOfFields; i++){
            Vector2d position = Vector2d.getRandomIntPosition(0,Math.sqrt(this.numOfFields*10));
            while(objectAt(position) != null){
                position = Vector2d.getRandomIntPosition(0,Math.sqrt(this.numOfFields*10));
            }
            grassList.add(new Grass(position));
        }
    }

    @Override
    public boolean place(Animal animal) {
        for(Animal livingAnimal : this.animals){
            if(livingAnimal.isAt(animal.getPosition()) || !map.canMoveTo(animal.getPosition())){
                return false;
            }
        }
        this.animals.add(animal);
        return true;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal: animals){
            if(animal.getPosition().equals(position))
                return animal;
        }
        for(Grass grass : grassList){
            if(grass.getPosition().equals(position))
                return grass;
        }
        return null;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(this.objectAt(position) instanceof Animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal: animals) {
            if (animal.getPosition().equals(position)) {
                return true;
            }
        }
        for(Grass grass : grassList) {
            if (grass.getPosition().equals(position)){
                return true;
            }
        }
    return false;
    }

    private void getBoardCorners(){
        for(Animal animal : animals){
            this.lowerLeft = this.lowerLeft.lowerLeft(animal.getPosition());
            this.upperRight = this.upperRight.upperRight(animal.getPosition());
        }
        for(Grass grass : grassList){
            this.lowerLeft = this.lowerLeft.lowerLeft(grass.getPosition());
            this.upperRight = this.upperRight.upperRight(grass.getPosition());
        }
    }
    @Override
    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this.map);
        this.getBoardCorners();
        return visualizer.draw(this.lowerLeft,this.upperRight);
    }
}
