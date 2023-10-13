package com.dmadev.java.part5;

import task5.math.Vector3d;
import task5.objects.*;

public final class SpaceUtils {
    private SpaceUtils() {}
    
    public static boolean isStar(SpaceObject obj) {
        return obj instanceof Sun;
    }
    public static double calculateGravity(SpaceObject ob1, SpaceObject ob2) {
        Vector3d distance = ob1.position.sub(ob2.position);
        return ob1.mass * ob2.mass * 6.6743e-11 / distance.dot(distance);
    }
}
