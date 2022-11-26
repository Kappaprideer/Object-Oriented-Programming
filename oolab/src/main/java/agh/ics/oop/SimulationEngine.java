package agh.ics.oop;

import agh.ics.oop.gui.*;
import javafx.application.Platform;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.sleep;

public class SimulationEngine implements IEngine, Runnable{

    private final IWorldMap map;
    private final MoveDirection[] moves;
    private List<Animal> animals = new LinkedList<>();
    private final App app;
    int moveDelay = 500;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions, App app){
        this.moves=moves;
        this.map=map;
        this.app=app;
        for(Vector2d position : positions){
            Animal animal = new Animal(this.map, position);
            if(this.map.place(animal)){
                animals.add(animal);
            }
        }
    }

    public List<Animal> getAnimals(){
        return animals;
    }

    @Override
    public void run() {
        showMap();
        for(int i=0; i<this.moves.length; i++){
            this.animals.get(i % this.animals.size()).move(this.moves[i]);
            showMap();
        }
    }

    public void showMap(){
        Platform.runLater( () -> {
            this.app.createMap(this.map);
        });
        try{
            sleep(moveDelay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}