package com.dmadev.java.part5.objects;
import java.util.Vector;

import task5.math.Vector3d;

public class SpaceObject implements Trackable {
    public Vector3d position;
    public Vector3d velocity;
    protected Vector<SpaceObject> satellites;
    
    public double mass;
    
    public SpaceObject()
    {
        this.position = new Vector3d();
        this.velocity = new Vector3d();
        this.satellites = new Vector<SpaceObject>();
    }
    
    public SpaceObject getParent() {
        return null;
    }
    public void setParent(SpaceObject obj) {
        throw new RuntimeException();
    }
    
    public boolean isHeavier(SpaceObject other) {
        return mass > other.mass;
    }
    
    public void addSatellite(SpaceObject obj) {
        satellites.addElement(obj);
        obj.setParent(this);
    }
    
    public void processPhysics(double time) {
        position.sadd(velocity.mul(time));
    }
    public double getKineticEnergy() {
        return mass * velocity.dot(velocity) * 0.5;
    }
    
    public String getObjectInfo() {
        return String.format("Space object info =========\n-- Position: %s\n-- Velocity: %s\n-- Mass: %f\n-- Kinetic energy: %f\n==================",
            position,
            velocity,
            mass,
            getKineticEnergy()
        );
    }
    
    public String getScheme() {
        String scheme = getObjectInfo();
        for (SpaceObject sat: satellites) {
            String subscheme = "== " + sat.getScheme().replace("\n", "\n-- ") + '\n';
            scheme += subscheme;
        }
        return scheme;
    }
}
