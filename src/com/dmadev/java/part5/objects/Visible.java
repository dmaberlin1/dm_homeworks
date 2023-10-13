package com.dmadev.java.part5.objects;

import task5.math.Vector3d;

public interface Visible {
    boolean isVisible(Vector3d viewerPosition);
}
