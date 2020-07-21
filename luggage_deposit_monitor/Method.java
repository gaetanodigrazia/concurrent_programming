package luggage_deposit_monitor;

public interface Method {
	void addToQueue(Passenger passenger);
	
	void place(Passenger passenger);
	
	void pick(Passenger passenger);
	
	void needToWait(String message);
}
