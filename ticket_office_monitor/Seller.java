package ticket_office_monitor;

import java.util.LinkedList;

public class Seller implements Method {
	private TicketOffice ticketoffice;
	private int available;
	private String name;
	private int cont = 0;

	private LinkedList<Customer> queue = new LinkedList<Customer>();

	public Seller(String name, TicketOffice ticketoffice, int stock) {
		setName(name);
		setTicketoffice(ticketoffice);
		setAvailable(stock);
	}

	@Override
	public synchronized void tryAcquire(Customer customer) {
		// TODO Auto-generated method stub
		queue.add(customer);
	}

	@Override
	public synchronized int acquire(Customer customer, int tickets) {
		// TODO Auto-generated method stub
		if (getAvailable() == 0) {
			refurnish();
		}
		while (!isFirst(customer)) {
			needToWait(customer);
		}

		int sold = tickets;
		if ((getAvailable() - tickets) < 0) {
			sold = getAvailable();
		}
		if (sold == tickets) {
			queue.removeFirst();
			cont++;
		}
		release(customer, sold);
		return sold;
	}

	@Override
	public void release(Customer customer, int tickets) {
		// TODO Auto-generated method stub
		System.out.println("Customer " + customer.getID() + " bought " + tickets + "tickets!");
		this.setAvailable(this.getAvailable() - tickets);
		System.out.println("Now available at this sellers are " + this.getAvailable() + " tickets!");
		notifyAll();
		if (cont == 99) {
			System.out.println("Tutti hanno avuto i loro biglietti!");
		}
	}

	@Override
	public boolean isFirst(Customer customer) {
		// TODO Auto-generated method stub
		if (customer.getID() == queue.getFirst().getID()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (queue.size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public void needToWait(Customer customer) {
		// TODO Auto-generated method stub
		try {
			System.out.println("I'm " + customer.getID() + " and I'm waiting");
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void refurnish() {
		// TODO Auto-generated method stub
		setAvailable(this.getTicketoffice().refurnishSeller());
	}

	/**
	 * @return the ticketoffice
	 */
	public TicketOffice getTicketoffice() {
		return ticketoffice;
	}

	/**
	 * @param ticketoffice the ticketoffice to set
	 */
	public void setTicketoffice(TicketOffice ticketoffice) {
		this.ticketoffice = ticketoffice;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the available
	 */
	public int getAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(int available) {
		this.available = available;
	}
}
