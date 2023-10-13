package com.dmadev.java.part13;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskRunner {
    public static void main(String[] args) {
		Lock victoryLock = new ReentrantLock();
        Race fire = new Race(100, "Fire", victoryLock);
		Race air = new Race(200, "Air", victoryLock);
		fire.setCompetitor(air);
		air.setCompetitor(fire);
		
		fire.start();
		air.start();
		try {
			fire.join();
			air.join();
		} catch (InterruptedException e) { /* almost impossible */ }
    }
}
