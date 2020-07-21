package ticket_office_monitor;

public class Customer extends Thread {
	private int ID;
	private int to_buy_tickets;
	private int bought = 0;
	private Seller seller;

	public Customer(int ID, int to_buy_tickets, Seller seller) {
		setID(ID);
		setToBuy(to_buy_tickets);
		setSeller(seller);
	}

	public void run() {
		getSeller().tryAcquire(this);
		while (to_buy_tickets != bought) {
			buy(this, (to_buy_tickets - bought));
		}
	}

	public void buy(Customer customer, int tickets) {
		bought += getSeller().acquire(customer, tickets);
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the to_buy_tickets
	 */
	public int getToBuy() {
		return to_buy_tickets;
	}

	/**
	 * @param to_buy_tickets the to_buy_tickets to set
	 */
	public void setToBuy(int to_buy_tickets) {
		this.to_buy_tickets = to_buy_tickets;
	}

	/**
	 * @return the seller
	 */
	public Seller getSeller() {
		return seller;
	}

	/**
	 * @param seller the seller to set
	 */
	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	/**
	 * @return the bought
	 */
	public int getBought() {
		return bought;
	}

	/**
	 * @param bought the bought to set
	 */
	public void setBought(int bought) {
		this.bought = bought;
	}

}
