package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.sqrt;

public class GrassField implements IWorldMap{
    private int numOfFields;
    private Vector2d lowerLeft = new Vector2d(0,0);
    private Vector2d upperRight;

    private List<Grass> grassList = new LinkedList<>();
    private List<Animal> animals = new LinkedList<>();

    public GrassField(int numOfFields){
        this.numOfFields=numOfFields;
        for(int i=0; i<numOfFields; i++){

        }


        int board= (int) Math.sqrt(10*this.numOfFields);
        this.upperRight=new Vector2d(board,board);
    }

    @Override
    public boolean place(Animal animal) {

        return false;
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
        return !isOccupied(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal: animals) {
            if (animal.getPosition().equals(position)) {
                return true;
            }
        }
    return false;
    }
}
