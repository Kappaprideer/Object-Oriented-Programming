package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class GrassField extends AbstractWorldMap{
    private final int numOfFields;
    private final List<Grass> grassList = new LinkedList<>();



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
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if(object instanceof Animal)
            return object;
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
        if(super.isOccupied(position))
            return true;
        for(Grass grass : grassList) {
            if (grass.getPosition().equals(position)){
                return true;
            }
        }
    return false;
    }

    void boardCorners() {
        this.lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (Animal animal : animals) {
            this.lowerLeft = this.lowerLeft.lowerLeft(animal.getPosition());
            this.upperRight = this.upperRight.upperRight(animal.getPosition());
        }
        for (Grass grass : grassList) {
            this.lowerLeft = this.lowerLeft.lowerLeft(grass.getPosition());
            this.upperRight = this.upperRight.upperRight(grass.getPosition());
        }
    }

}
