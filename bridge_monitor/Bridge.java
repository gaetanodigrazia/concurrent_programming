package bridge_monitor;

import java.util.LinkedList;

public class Bridge implements Method {

	private LinkedList<Car> lqueue = new LinkedList<Car>();
	private LinkedList<Car> rqueue = new LinkedList<Car>();

	/* POSITION AND DIRECTION */
	/* 1 -------------- 0 */

	private int go_to = 0;
	private int on_bridge = 0;
	private int actual_weight = 0;
	private final static int MAX_WEIGHT = 1000;
	private final static int MAX_CAR = 7;
	private int VERIFY = 0;

	public Bridge() {

	}

	@Override
	public synchronized void addToQueue(Car car) {
		// TODO Auto-generated method stub
		if (car.getDirection() == 0) {
			lqueue.add(car);
		} else {
			rqueue.add(car);
		}
	}

	@Override
	public synchronized void acquire(Car car) {
		// TODO Auto-generated method stub
		while (!isYourDirection(car) || !isFirst(car) || on_bridge == MAX_CAR || isMaxWeight(car)) {
			needToWait(car);
		}
		onBridge(car);
		if (car.getDirection() == 0) {
			System.out.println(car.getID() + " cross the bridge from LEFT TO RIGHT");
			lqueue.removeFirst();
		} else {
			System.out.println(car.getID() + " cross the bridge from RIGHT TO LEFT");
			rqueue.removeFirst();
		}
		changeDirection();
	}

	@Override
	public synchronized void release(Car car) {
		// TODO Auto-generated method stub
		leaveBridge(car);
		VERIFY++;
		notifyAll();
		System.out.println("VERIFY: " + VERIFY);
		if (VERIFY == 100) {
			System.out.println();
			System.out.println();
			System.out.println("****************************************************************");
			System.out.println("********** SONO PASSATI TUTTI SUL PONTE DI BRUCKOLIN! **********");
			System.out.println("****************************************************************");
			System.out.println();
			System.out.println();
		}
	}

	public void changeDirection() {
		if (go_to == 0 || lqueue.size() == 0) {
			go_to = 1;
		} else if (go_to == 1 || rqueue.size() == 0) {
			go_to = 0;
		}
	}

	public boolean isYourDirection(Car car) {
		if (car.getDirection() != go_to) {
			return false;
		}
		return true;
	}

	public boolean isFirst(Car car) {
		if (car.getDirection() == 0) {
			if (lqueue.getFirst().getID() == car.getID()) {
				return true;
			}
		} else if (car.getDirection() == 1) {
			if (rqueue.getFirst().getID() == car.getID()) {
				return true;
			}
		}
		return false;
	}

	public void needToWait(Car car) {
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isMaxWeight(Car car) {
		if (actual_weight == MAX_WEIGHT) {
			return true;
		}
		return false;
	}

	public void onBridge(Car car) {
		on_bridge++;
		actual_weight += car.getWeight();
	}

	public void leaveBridge(Car car) {
		--on_bridge;
		actual_weight -= car.getWeight();
	}

	public LinkedList<Car> getList(Car car) {
		if (car.getDirection() == 0) {
			return lqueue;
		}
		return rqueue;
	}

}
