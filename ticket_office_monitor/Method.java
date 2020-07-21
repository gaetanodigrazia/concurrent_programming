package ticket_office_monitor;

public interface Method {
	void tryAcquire(Customer custome);

	int acquire(Customer customer, int tickets);

	void release(Customer customer, int tickets);

	boolean isFirst(Customer customer);

	boolean isEmpty();
	
	void needToWait(Customer customer);
	
	void refurnish();
}
