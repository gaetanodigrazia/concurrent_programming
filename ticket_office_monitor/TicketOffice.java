/**
 * Simulate a seller that sell ticket given by a ticketoffice
 * 
 * @author Gaetano Di Grazia
 * @version 1.0
 * License
 * @link https://www.gnu.org/licenses/gpl-3.0.en.html
 * @link https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Semaphore.html
 * @see Cabina.java
 * @see Elettore.java
 * @see Metodi.java
 * @see Seggio.java
 * @see EmptyException.java
 */
package ticket_office_monitor;

import java.util.Random;

public class TicketOffice {
	private int total_tickets = 10000;
	private int available_tickets = 9950;
	private final static int stock = 50;

	public static void main(String[] args) {
		int ncustomers = 100;
		TicketOffice ticketoffice = new TicketOffice();
		Seller nord = new Seller("Nord", ticketoffice, stock);

		Random r = new Random();

		for (int i = 0; i < ncustomers; i++) {
			new Customer(i, 30, nord).start();
		}
	}

	public synchronized int refurnishSeller() {
		int released = stock;
		if (available_tickets == 0) {
			try {
				throw new EmptyException("No more tickets in the ticket office!");
			} catch (EmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (available_tickets < stock) {
			released = available_tickets;
		}
		available_tickets -= released;
		System.out.println("NOW AVAILABLE IN TICKET OFFICE ARE " + available_tickets);
		return released;
	}
}
