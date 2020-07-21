package monitor;

public class Producer extends Thread {
	private SharedSynchronizedBuffer sync;

	public Producer(String name, SharedSynchronizedBuffer sync) {
		super(name);
		setSync(sync);
	}

	public void run() {
		try {
			for(int i = 0;; i++) {
				System.out.println("Written to buffer: " + i);
				getSync().produce(i);
				sleep(3000);
			}
		}catch(InterruptedException e) {
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
