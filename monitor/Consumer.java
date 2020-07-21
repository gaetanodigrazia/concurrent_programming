package monitor;

public class Consumer extends Thread {
	private SharedSynchronizedBuffer sync;

	public Consumer(String name, SharedSynchronizedBuffer sync) {
		super(name);
		setSync(sync);
	}

	public void run() {
		try {
			while (true) {
				System.out.println("Read from buffer: " + getSync().consumes());
				sleep(3000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the sync
	 */
	public SharedSynchronizedBuffer getSync() {
		return sync;
	}

	/**
	 * @param sync the sync to set
	 */
	public void setSync(SharedSynchronizedBuffer sync) {
		this.sync = sync;
	}
}
