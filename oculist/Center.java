package oculist;

import java.util.LinkedList;

public class Center implements Method {
	private LinkedList<Customer> enter = new LinkedList<Customer>();
	private LinkedList<Customer> special = new LinkedList<Customer>();

	public Center() {

	}

	@Override
	public synchronized void addToQueue(Customer customer) {
		// TODO Auto-generated method stub
		enter.add(customer);
		notifyAll();
	}

	@Override
	public synchronized Customer fetch(Oculist oculist) {
		// TODO Auto-generated method stub
		Customer c;
		int x = isMine(oculist);
		if (someoneIsSpecial() && x != -1) {
			c = special.get(x);
			special.remove(x);
		} else {
			c = enter.getFirst();
			enter.removeFirst();
		}
		return c;
	}

	@Override
	public synchronized void visit(Customer customer, Oculist oculist) {
		// TODO Auto-generated method stub
		try {
			//(customer.getOculist().equals(null)) 
			if (customer.getOculist() == null) {
				if (customer.isStandard()) {
					visitTime();
					pay();
				} else {
					dilate();
					customer.setOculist(oculist);
					special.add(customer);
					System.out.println("I dilatated it, come back later");
				}
			} else if (customer.getOculist().equals(oculist)) {
				visitTime();
				pay();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized boolean isEmpty() {
		// TODO Auto-generated method stub
		if (enter.size() == 0 && special.size() == 0) {
			needToWait("No one in the center to visit!");
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void needToWait(String message) {
		// TODO Auto-generated method stub
		try {
			System.out.println(message);
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void dilate() {
		// TODO Auto-generated method stub
		try {
			System.out.println("I'm dilating...");
			Thread.sleep(2000);
			System.out.println("Dilatated");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Customer is paying...");
			Thread.sleep(2000);
			System.out.println("Customer payed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int isMine(Oculist oculist) {
		// TODO Auto-generated method stub
		int x = -1;
		for (int i = 0; i < special.size(); i++) {
			if (special.get(i).getOculist().equals(oculist)) {
				x = i;
				break;
			}
		}
		return x;
	}

	@Override
	public boolean someoneIsSpecial() {
		// TODO Auto-generated method stub
		if (special.size() != 0) {
			return true;
		}
		return false;
	}

	@Override
	public void visitTime() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Start visit");
			Thread.sleep(2000);
			System.out.println("End visit");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
