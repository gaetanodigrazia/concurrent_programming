package luggage_deposit_monitor;

public class Passenger extends Thread{
	private int ID;
	private Deposit deposit;
	private int luggage;
	private int compartment;
	
	public Passenger(int ID, Deposit deposit, int luggage) {
		setID(ID);
		setDeposit(deposit);
		setLuggage(luggage);
	}
	
	public void run() {
		try {
		this.getDeposit().addToQueue(this);
		this.getDeposit().place(this);
		sleep(2000);
		this.getDeposit().pick(this);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the deposit
	 */
	public Deposit getDeposit() {
		return deposit;
	}

	/**
	 * @param deposit the deposit to set
	 */
	public void setDeposit(Deposit deposit) {
		this.deposit = deposit;
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
	 * @return the luggage
	 */
	public int getLuggage() {
		return luggage;
	}

	/**
	 * @param luggage the luggage to set
	 */
	public void setLuggage(int luggage) {
		this.luggage = luggage;
	}

	/**
	 * @return the compartment
	 */
	public int getCompartment() {
		return compartment;
	}

	/**
	 * @param compartment the compartment to set
	 */
	public void setCompartment(int compartment) {
		this.compartment = compartment;
	}
}
