package cableway_monitor;

public interface Method {
	void goUp(Passenger passenger);

	void goDown(Passenger passenger);

	void needToWait(Passenger passenger);

	void exit(int direction);
}
