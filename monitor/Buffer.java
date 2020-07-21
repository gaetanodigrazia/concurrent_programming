package monitor;

public interface Buffer {
	public void produce(int value);
	
	public int consumes();
}
