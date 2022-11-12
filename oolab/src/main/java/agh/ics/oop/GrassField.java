package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;


public class GrassField extends AbstractWorldMap{
    private final int numOfFields;
    private final Map<Vector2d,Grass> grassList = new HashMap<>();

    public GrassField(int numOfFields){
        this.numOfFields=numOfFields;
        this.lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for(int i=0; i<numOfFields; i++){
            Vector2d position = Vector2d.getRandomIntPosition(0,Math.sqrt(this.numOfFields*10));
            while(objectAt(position) != null){
                position = Vector2d.getRandomIntPosition(0,Math.sqrt(this.numOfFields*10));
            }
            grassList.put(position,new Grass(position));
            this.lowerLeft=this.lowerLeft.lowerLeft(position);
            this.upperRight=this.upperRight.upperRight(position);
        }
    }


    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if(object instanceof Animal)
            return object;
        return grassList.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(this.objectAt(position) instanceof Animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(super.isOccupied(position))
            return true;
        return grassList.get(position) != null;
    }

    void boardCorners() {
        for (Vector2d position : animals.keySet()) {
            this.lowerLeft=this.lowerLeft.lowerLeft(position);
            this.upperRight = this.upperRight.upperRight(position);
        }
        for (Vector2d position : grassList.keySet()) {
            this.lowerLeft=this.lowerLeft.lowerLeft(position);
            this.upperRight=this.upperRight.upperRight(position);
        }
    }

}
