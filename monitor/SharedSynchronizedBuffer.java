package monitor;

public class SharedSynchronizedBuffer implements Buffer {
	private int shared_var = -1;
	private int occupied = 0;

	public SharedSynchronizedBuffer() {

	}

	@Override
	public synchronized void produce(int value) {
		// TODO Auto-generated method stub
		try {
			while (occupied == 1) {
				System.err.println("\n" + Thread.currentThread().getName() + " tryed to write.");
				System.err.println("Monitor said: buffer is occupied, need to wait!");
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			setSharedVar(value);
			consumerTurn();
			notify();
		}
	}

	@Override
	public synchronized int consumes() {
		// TODO Auto-generated method stub
		try {
			while (occupied == 0) {
				System.err.println("\n" + Thread.currentThread().getName() + " tryed to read.");
				System.err.println("Monitor said: buffer is occupied, need to wait!");
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			producerTurn();
			notify();
		}
		return getSharedVar();
	}

	public synchronized void setSharedVar(int shared_var) {
		this.shared_var = shared_var;
	}

	public synchronized int getSharedVar() {
		return shared_var;
	}

	public synchronized void consumerTurn() {
		occupied++;
	}

	public synchronized void producerTurn() {
		occupied--;
	}
}
