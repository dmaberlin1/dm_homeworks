package com.dmadev.java.part5.objects;

public class Planet
extends CelestialBody
implements Visitable {
    protected SpaceObject parent;
    protected long population;
    protected long timesVisited;
    
    public Planet(SpaceObject parent, long population) {
        if (parent instanceof Satellite)
            throw new RuntimeException("Planet cannot have parent of type Satellite");
        
        parent.addSatellite(this);
        this.population = population;
        this.timesVisited = population;
    }
    
    public void setPopulation(long val) {
        if (val < 0)
            throw new RuntimeException("Negative population");
        if (val > population) {
            timesVisited += population - val;
        }
        population = val;
    }
    
    public long countVisits() {
        return timesVisited;
    }
    
    @Override
    public SpaceObject getParent() {
        return parent;
    }
    
    @Override
    public void setParent(SpaceObject obj) {
        parent = obj;
    }
    
    @Override
    public String getObjectInfo() {
        return String.format("Planet info =========\n-- Name: %s\n-- Position: %s\n-- Velocity: %s\n-- Mass: %e\n-- Kinetic energy: %e\n-- Visited %d times\n-- Population: %d\n==================\n",
            name,
            position,
            velocity,
            mass,
            getKineticEnergy(),
            timesVisited,
            population
        );
    }
}
