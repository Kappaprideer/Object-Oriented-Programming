package agh.ics.oop;

import agh.ics.oop.gui.*;
import javafx.application.Platform;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class SimulationEngine implements IEngine{

    private final IWorldMap map;
    private final MoveDirection[] moves;
    private List<Animal> animals = new LinkedList<>();
    private final App app;

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
        Platform.runLater(() -> {
            try {
                this.app.createMap(this.map);
                Thread.sleep(300);
            } catch (FileNotFoundException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        for(int i=0; i<this.moves.length; i++){
            this.animals.get(i % this.animals.size()).move(this.moves[i]);
            Platform.runLater( () -> {
                try {
                    this.app.createMap(this.map);
                    Thread.sleep(300);
                } catch (FileNotFoundException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}