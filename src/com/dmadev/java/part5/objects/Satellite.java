package com.dmadev.java.part5.objects;

public class Satellite extends SpaceObject {
    protected SpaceObject parent;
    public String name;
    
    public Satellite(SpaceObject parent, String name) {
        parent.addSatellite(this);
        this.name = name;
    }
    public Satellite(SpaceObject parent) {
        this(parent, "untitled");
    }
    
    @Override
    public SpaceObject getParent() {
        return parent;
    }
    
    @Override
    public void setParent(SpaceObject obj) {
        parent = obj;
    }
    
    public boolean isArtifical() {
        return false;
    }
    
    public int getNestingLevel() {
        SpaceObject ptr = this;
        int count = 0;
        while (ptr.getParent() != null) {
            ++count;
            ptr = ptr.getParent();
        }
        return count;
    }
    
    @Override
    public String getObjectInfo() {
        String desc = isArtifical() ? "Artifical satellite" : "Satellite";
        return String.format("%s \"%s\" info =========\n  Position: %s\n  Velocity: %s\n  Mass: %e\n==================\n",
            desc,
            name,
            position,
            velocity,
            mass,
            getKineticEnergy()
        );
    }
}
