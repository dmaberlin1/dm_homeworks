package com.dmadev.java.part13;

import java.util.Random;
import java.util.concurrent.locks.Lock;

public class Race extends Thread {
	private int crystals;
	private Random randomGen;
	private String name;
	private Lock victoryLock;
	private Race competitor;
	
	public Race(long randomSeed, String name, Lock vLock) {
		randomGen = new Random(randomSeed);
		this.name = name;
		this.victoryLock = vLock;
	}
	
	public void setCompetitor(Race other) {
		this.competitor = other;
	}
	
	public void run() {
		try {
			while (crystals < 500) {
				sleep(1);
				
				// the first thread that gets here is random
				randomGen.setSeed(randomGen.nextInt() + competitor.randomGen.nextInt());
				int allCrystals = randomGen.nextInt(3) + 2;
				int usefulCrystals = randomGen.nextInt(allCrystals);
				crystals += usefulCrystals;
			}
		
			if (victoryLock.tryLock())
			{
				competitor.interrupt();
				System.out.printf("The race %s won with %d crystals\n", name, crystals);
			}
			
			// probably get interrupted
			victoryLock.lock();
		}
		catch (InterruptedException e) {
			System.out.printf("The race %s work interrupted\n", name);
			return;
		}
	}
}
