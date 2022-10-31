package agh.ics.oop;


public class SimulationEngine implements IEngine{

    private IWorldMap map;
    private MoveDirection[] moves;
    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d positions[]){
        this.moves=moves;
        this.map=map;
        for(Vector2d position : positions){
            map.place(new Animal(map, position));
        }
    }

    @Override
    public void run() {
        for(int i=0; i<moves.length; i++){

        }
    }
}
