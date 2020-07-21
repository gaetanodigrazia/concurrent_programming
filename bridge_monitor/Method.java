package bridge_monitor;

public interface Method {
	void addToQueue(Car car);

	void acquire(Car car);

	void release(Car car);
}
