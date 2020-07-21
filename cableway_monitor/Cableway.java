package cableway_monitor;

import java.util.LinkedList;

public class Cableway implements Method {
	private Vehicle tram;

	private int max_people = 20;
	private int min_people = 5;

	private int actual_people = 0;
	private int direction = 0;

	private LinkedList<Passenger> goup = new LinkedList<Passenger>();
	private LinkedList<Passenger> godown = new LinkedList<Passenger>();

	public Cableway() {
	}

	public synchronized void addToQueue(Passenger passenger) {
		if (passenger.getDirection() == 1) {
			goup.add(passenger);
		} else {
			godown.add(passenger);
		}
	}

	@Override
	public synchronized void goUp(Passenger passenger) {
		// TODO Auto-generated method stub
		if (goup.size() == 0) {
			direction = 0;
			notifyAll();
		}
		while (passenger.getID() != goup.getFirst().getID() || (passenger.getDirection() != direction)) {
			needToWait(passenger);
		}

		System.out.println("Passenger " + passenger.getID() + " is on board to go up");
		goup.removeFirst();
		actual_people++;
		if (actual_people == 5) {
			direction = 0;
			exit(1);
		} else {
			notifyAll();
		}
	}

	@Override
	public synchronized void goDown(Passenger passenger) {
		// TODO Auto-generated method stub
		if (godown.size() == 0) {
			direction = 1;
			notifyAll();
		}
		while (passenger.getID() != godown.getFirst().getID() || (passenger.getDirection() != direction)) {
			needToWait(passenger);
		}

		System.out.println("Passenger " + passenger.getID() + " is on board to go down");
		godown.removeFirst();
		actual_people++;
		if (actual_people == 5) {
			direction = 1;
			exit(0);
		} else {
			notifyAll();
		}
	}

	@Override
	public void exit(int direction) {
		// TODO Auto-generated method stub
		if (direction == 1) {
			System.out.println(actual_people + " gone up!");
		} else {
			System.out.println(actual_people + " gone down!");
		}
		actual_people = 0;
		notifyAll();
	}

	@Override
	public void needToWait(Passenger passenger) {
		// TODO Auto-generated method stub
		System.out.println("Sorry " + passenger.getID() + " you need to wait!");
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
