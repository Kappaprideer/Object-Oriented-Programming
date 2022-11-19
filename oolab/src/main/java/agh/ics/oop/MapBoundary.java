package agh.ics.oop;

import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    private final SortedSet <Vector2d> X =  new TreeSet<>(new VectorComparatorForX());
    private final SortedSet <Vector2d> Y = new TreeSet<>(new VectorComparatorForY());

    public void add(IMapElement element){
        X.add(element.getPosition());
        Y.add(element.getPosition());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        X.remove(oldPosition);
        X.add(newPosition);
        Y.remove(oldPosition);
        Y.add(newPosition);
    }

    public Vector2d getLowerLeft(){
        return X.first().lowerLeft(this.Y.first());
    }

    public Vector2d getUpperRight(){
        return X.last().upperRight(this.Y.last());
    }
}

class VectorComparatorForX implements java.util.Comparator<Vector2d> {
    @Override
    public int compare(Vector2d o1, Vector2d o2){
        if(o1.x<o2.x)
            return -1;
        else if(o1.x>o2.x) return 1;
        else if(o1.y<o2.y) return -1;
        return 1;
    }
}

class VectorComparatorForY implements java.util.Comparator<Vector2d> {
    @Override
    public int compare(Vector2d o1, Vector2d o2){
        if(o1.y<o2.y)
            return -1;
        else if (o1.y>o2.y)
            return 1;
        else if(o1.x<o2.x)
            return -1;
        return 1;
    }

}
