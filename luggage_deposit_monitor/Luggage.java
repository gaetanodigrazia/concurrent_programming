package luggage_deposit_monitor;

public class Luggage {
	private Passenger passenger;

	public Luggage(Passenger passenger) {
		setPassenger(passenger);
	}

	/**
	 * @return the passenger
	 */
	public Passenger getPassenger() {
		return passenger;
	}

	/**
	 * @param passenger the passenger to set
	 */
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

}
