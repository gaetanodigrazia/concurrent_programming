package barbershop_monitor_V2;

public interface Method {

	boolean addToQueue(Customer customer);

	int availableChair();

	void cut(Customer customer);

	void sit(Customer customer, int chair);

	void standUp(Customer customer);

	void fetch();
	
	void needToWait(String message);
	
	void addToPayQueue(Customer customer);
	
	void pay();
}
