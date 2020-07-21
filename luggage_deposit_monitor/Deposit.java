package luggage_deposit_monitor;

import java.util.LinkedList;

public class Deposit implements Method {
	private LinkedList<Passenger> passengers = new LinkedList<Passenger>();
	private LinkedList<Luggage> c_1 = new LinkedList<Luggage>();
	private LinkedList<Luggage> c_2 = new LinkedList<Luggage>();
	private LinkedList<Luggage> c_3 = new LinkedList<Luggage>();

	private final static int MAX_LUGGAGE_C = 10;

	@Override
	public synchronized void addToQueue(Passenger passenger) {
		// TODO Auto-generated method stub
		System.out.println(
				"Hi! I'm " + passenger.getID() + " and I want to place " + passenger.getLuggage() + " luggage!");
		passengers.add(passenger);
	}

	@Override
	public synchronized void place(Passenger passenger) {
		// TODO Auto-generated method stub
		int available = checkAvailability(passenger);
		while (!isFirst(passenger) || allFull() || available == -1) {
			needToWait(
					"I'm not the first or all compartments is full or there is not enaugh space for my luggage! Need to wait!");
		}
		for (int i = 0; i < passenger.getLuggage(); i++) {
			getList(available).add(new Luggage(passenger));
		}
		System.out.println("******PLACED ******");
		System.out.println("I'm " + passenger.getID() + " and placed " + passenger.getLuggage()
				+ " luggage in compartment " + available + "!");
		System.out.println("******PLACED ******");
		passenger.setCompartment(available);
		passengers.removeFirst();
		notifyAll();
	}

	@Override
	public synchronized void pick(Passenger passenger) {
		int counter = 0;
		// TODO Auto-generated method stub
		for (int i = 0; i < getList(passenger.getCompartment()).size(); i++) {
			if (getList(passenger.getCompartment()).get(i).getPassenger().equals(passenger)) {
				getList(passenger.getCompartment()).remove(i);
				counter++;
			}
		}
		if (counter == passenger.getLuggage()) {
			System.out.println("I'm " + passenger.getID() + " and I pick " + counter + " luggage from compartment "
					+ passenger.getCompartment());
		}
		notifyAll();
	}

	@Override
	public void needToWait(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isFirst(Passenger passenger) {
		if (passenger.getID() == passengers.getFirst().getID()) {
			return true;
		}
		return false;
	}

	public boolean allFull() {
		if (c_1.size() == MAX_LUGGAGE_C && c_2.size() == MAX_LUGGAGE_C && c_3.size() == MAX_LUGGAGE_C) {
			return true;
		}
		return false;
	}

	public int checkAvailability(Passenger passenger) {
		if ((c_1.size() + passenger.getLuggage()) <= MAX_LUGGAGE_C) {
			return 1;
		} else if ((c_2.size() + passenger.getLuggage()) <= MAX_LUGGAGE_C) {
			return 2;
		} else if ((c_3.size() + passenger.getLuggage()) <= MAX_LUGGAGE_C) {
			return 3;
		} else {
			return -1;
		}
	}

	public LinkedList<Luggage> getList(int number) {
		if (number == 1) {
			return c_1;
		} else if (number == 2) {
			return c_2;
		} else if (number == 3) {
			return c_3;
		}
		return null;
	}
}
