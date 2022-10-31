package agh.ics.oop;

import java.util.Objects;

public class Animal {

    private IWorldMap map;
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public Animal(){
        this.map=null;
    }

    public Animal(IWorldMap map){
        this.map=map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        if(!map.isOccupied(initialPosition)) {
            this.map=map;
            position=initialPosition;
        }
    }


    public String toString() {
        return switch (this.orientation) {
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Animal animal = (Animal) other;

        if (!Objects.equals(map, animal.map)) return false;
        return Objects.equals(position, animal.position);
    }

    @Override
    public int hashCode() {
        int result = map != null ? map.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }



//    @Override
//    public boolean equals(Object other) {
//        if (this == other)
//            return true;
//        if (!(other instanceof Animal that))
//            return false;
//        return this.position.equals(that.position);
//    }

    public boolean isAt(Vector2d position){
        return this.position.x==position.x && this.position.y==position.y;
    }

    public void move(MoveDirection direction){
        switch (direction){
            case LEFT -> this.orientation=this.orientation.previous();
            case RIGHT -> this.orientation=this.orientation.next();
            case FORWARD -> {
                if(this.map.canMoveTo(this.position.add(orientation.toUnitVector()))){
                    this.position=this.position.add(orientation.toUnitVector());
                }
            }
            case BACKWARD -> {
                if(this.map.canMoveTo(this.position.add(orientation.toUnitVector().opposite()))) {
                    this.position = this.position.add(orientation.toUnitVector().opposite());
                }
            }
        }
    }

}
