package com.dmadev.java.part5.objects;

import task5.math.Vector3d;

public class CelestialBody extends SpaceObject implements Visible {
    public String name;
    public double radius;
    
    public boolean isVisible(Vector3d viewerPosition) {
        double distance = position.sub(viewerPosition).length();
        return radius / distance > 0.0017;
    }
    
    public double calculateDiameter() {
        return radius * 2.0;
    }
    
    @Override
    public String getObjectInfo() {
        return String.format("Celestial body info =========\n-- Name: %s\n-- Position: %s\n-- Radius: %e\n-- Velocity: %s\n-- Mass: %e\n-- Kinetic energy: %e\n==================\n",
            name,
            position,
            radius,
            velocity,
            mass,
            getKineticEnergy()
        );
    }
}
