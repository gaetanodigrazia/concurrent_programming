package barbershop_monitor_V1;

import java.util.LinkedList;

public class Barbershop implements Method {
	private LinkedList<Customer> sofa = new LinkedList<Customer>();
	private int chair_1 = 0;
	private int chair_2 = 0;
	private int chair_3 = 0;
	private int sat = 0;

	@Override
	public synchronized boolean addToQueue(Customer customer) {
		// TODO Auto-generated method stub
		if (sat < 5) {
			sat++;
			sofa.add(customer);
			notifyAll();
			return true;
		}
		return false;
	}

	@Override
	public synchronized void fetch() {
		// TODO Auto-generated method stub
		if (sofa.size() == 0) {
			System.out.println("Sono " + Thread.currentThread().getName() + ", non c'è nessuno e vado a dormire!");
			needToWait();
		} else {
			--sat;
			System.out.println("Hey " + sofa.getFirst().getID() + " vieni a sederti che ti taglio i capelli!");
			sit(sofa.getFirst(), availableChair());
			cut(sofa.getFirst());
			sofa.removeFirst();
		}
	}

	public int availableChair() {
		if (chair_1 == 0) {
			return 1;
		} else if (chair_2 == 0) {
			return 2;
		} else if (chair_3 == 0) {
			return 3;
		}
		return -1;
	}

	@Override
	public void cut(Customer customer) {
		// TODO Auto-generated method stub
		try {
			Thread.currentThread().sleep(1000);
			System.out.println(
					"Sono " + Thread.currentThread().getName() + " e sto tagliando i capelli a " + customer.getID());
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		standUp(customer);
	}

	@Override
	public void sit(Customer customer, int chair) {
		System.out.println(
				"Sono " + customer.getID() + " e mi sono seduto sulla sedia, ora qualcuno mi taglia i capelli!");
		// TODO Auto-generated method stub
		if (chair == 1) {
			chair_1 = -1;
		} else if (chair == 2) {
			chair_2 = -1;
		} else if (chair == 3) {
			chair_3 = -1;
		}
		customer.setChair(chair);
		notifyAll();
	}

	@Override
	public void standUp(Customer customer) {
		// TODO Auto-generated method stub
		if (customer.getChair() == 1) {
			chair_1 = 0;
		} else if (customer.getChair() == 2) {
			chair_2 = 0;
		} else if (customer.getChair() == 3) {
			chair_3 = 0;
		}
		System.out.println("Goodbye " + customer.getID() + "!");
		notifyAll();
	}

	@Override
	public void needToWait() {
		// TODO Auto-generated method stub
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
