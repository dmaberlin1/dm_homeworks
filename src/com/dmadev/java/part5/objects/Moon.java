package com.dmadev.java.part5.objects;

public class Moon
extends Satellite
implements Visitable {
    protected long timesVisited;
    
    public Moon(SpaceObject parent) {
        super(parent);
        boolean check = parent instanceof Satellite || parent instanceof Planet;
        if (!check)
            throw new RuntimeException();
        timesVisited = 0;
    }
    
    public void visit() {
        ++timesVisited;
    }
    public long countVisits() {
        return timesVisited;
    }
}
