package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class SimulationEngine implements IEngine{

    private final IWorldMap map;
    private final MoveDirection[] moves;
    private List<Animal> animals = new LinkedList<>();

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions){
        this.moves=moves;
        this.map=map;
        for(Vector2d position : positions){
            Animal animal = new Animal(this.map, position);
            if(map.isOccupied(position) && this.map.place(animal)){
                animals.add(animal);
            }
        }
    }

    @Override
    public void run() {
        System.out.println(this.map);
        for(int i=0; i<this.moves.length; i++){
            this.animals.get(i % this.animals.size()).move(this.moves[i]);
            System.out.println(this.map);
        }
    }


}
