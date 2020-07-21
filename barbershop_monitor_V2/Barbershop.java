package barbershop_monitor_V2;

import java.util.LinkedList;

public class Barbershop implements Method {
	private LinkedList<Customer> sofa = new LinkedList<Customer>();
	private LinkedList<Customer> sala = new LinkedList<Customer>();
	private LinkedList<Customer> payqueue = new LinkedList<Customer>();

	private int chair_1 = 0;
	private int chair_2 = 0;
	private int chair_3 = 0;
	private int sat = 0;
	private int insala = 0;
	private final static int MAX_CUSTOMERS = 10;

	@Override
	public synchronized boolean addToQueue(Customer customer) {
		// TODO Auto-generated method stub
		if (sat < 5) {
			sat++;
			sofa.add(customer);
			notifyAll();
			return true;
		} else if (insala < MAX_CUSTOMERS) {
			insala++;
			sala.add(customer);
			notifyAll();
			return true;
		}
		return false;
	}

	@Override
	public synchronized void fetch() {
		// TODO Auto-generated method stub
		if (sofa.size() == 0) {
			needToWait("Sono " + Thread.currentThread().getName() + ", non c'è nessuno e vado a dormire!");
		} else {
			--sat;
			System.out.println("Hey " + sofa.getFirst().getID() + " vieni a sederti che ti taglio i capelli!");
			sit(sofa.getFirst(), availableChair());
			cut(sofa.getFirst());
			sofa.removeFirst();
			if (sala.size() != 0) {
				--insala;
				sofa.add(sala.getFirst());
				sala.removeFirst();
			}
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
		customer.setChair(0);
		System.out.println("I'm " + customer.getID() + " and I'm going to pay!");
		addToPayQueue(customer);
	}

	@Override
	public void needToWait(String message) {
		// TODO Auto-generated method stub
		try {
			System.out.println(message);
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addToPayQueue(Customer customer) {
		// TODO Auto-generated method stub
		payqueue.add(customer);
	}

	@Override
	public synchronized void pay() {
		// TODO Auto-generated method stub
		if (payqueue.size() == 0) {
			needToWait("Sono " + Thread.currentThread().getName() + " nessuno deve pagare, vado a dormire!");
		} else {
			System.out.println(payqueue.getFirst().getID() + " ha pagato!");
			System.out.println("Ciao " + payqueue.getFirst().getID());
			payqueue.removeFirst();
		}
	}
}
