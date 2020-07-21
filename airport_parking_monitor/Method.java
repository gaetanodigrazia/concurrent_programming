package airport_parking_monitor;

import java.util.LinkedList;

public interface Method {
	public boolean tryAcquire(Car car);
	public void acquire(Car car);
	public void acquired(Car car);
	public boolean tryRelease(Car car);
	public void release(Car car);
	public void released(Car car);
	public void needToWait(Car car);
	public LinkedList<Car> getEnter(Car a);
	public LinkedList<Car> getExit(Car a);
}
