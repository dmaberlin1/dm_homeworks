package com.dmadev.java.part5;

import task5.math.Vector3d;
import task5.objects.*;

public class SpaceRunner {
    protected Sun sun;
    
    public void runTests()
    {
        sun = new Sun();
        sun.lightPower = 1.8e24;
        sun.mass = 1.45e42;
        sun.radius = 3.34e17;
        sun.name = "Sun Microsystems";
        
        Planet planet1 = new Planet(sun, 1900000000);
        planet1.setPopulation(1921680101);
        planet1.mass = 2.3e38;
        planet1.velocity = new Vector3d(5.63e7, -1.25e8, 2.23e7);
        planet1.processPhysics(1.4);
        
        Moon moon1 = new Moon(planet1);
        Moon moon2 = new Moon(planet1);
        moon1.name = "Oberon";
        moon2.name = "Proteus";
        moon1.mass = 7.83e10;
        moon2.mass = 2.89e10;
        moon1.velocity = new Vector3d(1.2e4, -2.8e5, 7.89e4);
        moon2.velocity = new Vector3d(3.75e4, 5.98e5, -1.22e5);
        moon1.processPhysics(1.4);
        moon2.processPhysics(1.4);
        
        Satellite asteroid = new Satellite(moon1, "Rock");
        asteroid.mass = 4.38e5;
        asteroid.velocity = new Vector3d(-6.84e8, -3.32e7, -8.59e8);
        asteroid.processPhysics(1.4);
        System.out.println("Nesting level of asteroid: " + asteroid.getNestingLevel());
        
        Satellite artSatellite = new ArtificalSatellite(moon2, "Железяка");
        artSatellite.mass = 5.0;
        artSatellite.position = moon2.position.add(new Vector3d(1.12e3, -5.7e4, 4.5e3));
        artSatellite.velocity = new Vector3d(3.45e5, -7.64e5, 9.29e4);
        artSatellite.processPhysics(1.4);
        
        System.out.println("Visibility of the planet: " + planet1.isVisible(artSatellite.position));
        System.out.println(sun.getScheme());
        
        System.out.println("Sun is star: " + SpaceUtils.isStar(sun));
        System.out.println("Asteroid is star: " + SpaceUtils.isStar(asteroid));
        
        double force = SpaceUtils.calculateGravity(artSatellite, moon2);
        System.out.println(String.format("Force between %s and %s: %e\n", artSatellite.name, moon2.name, force));
    }
}
