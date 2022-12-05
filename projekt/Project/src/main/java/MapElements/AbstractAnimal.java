package MapElements;

import Map.IWorldMap;
import Moving.Direction;
import Moving.Vector2d;

abstract public class AbstractAnimal {
    private Vector2d position;
    private Direction direction;
    private IWorldMap map;
    private String dna;
    private int energy;

    public AbstractAnimal(Vector2d position, IWorldMap map, String dna, int energy){
        this.position=position;
        this.map=map;
        this.dna=dna;
        this.energy=energy;
    }

    public void addEnergy(int newEnergy){
        this.energy+=newEnergy;
    }

    public void loseEnergy(){
        this.energy-=1;
    }






    public void placeAnimal(){

    }


}
