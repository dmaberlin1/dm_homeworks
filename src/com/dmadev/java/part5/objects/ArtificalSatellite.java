package com.dmadev.java.part5.objects;

public class ArtificalSatellite extends Satellite {
    @Override
    public boolean isArtifical() {
        return true;
    }
    
    public ArtificalSatellite(SpaceObject parent, String name) {
        super(parent);
        this.name = name;
    }
    public ArtificalSatellite(SpaceObject parent) {
        this(parent, "Unnamed satellite");
    }
    
    public void addSatellite(SpaceObject obj) {
        throw new RuntimeException("Artifical satellite cannot have subsatellites");
    }
}
