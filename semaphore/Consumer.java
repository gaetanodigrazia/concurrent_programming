package semaphore;

public class Consumer extends Thread{
private Queue queue;

	public Consumer(Queue queue) {
		setQueue(queue);
		this.setName("consumer");
	}

	public void run() {
		try {
			while(true) {
				getQueue().task();
				sleep(1000);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @return the queue
	 */
	public Queue getQueue() {
		return queue;
	}

	/**
	 * @param queue the queue to set
	 */
	public void setQueue(Queue queue) {
		this.queue = queue;
	}
}
