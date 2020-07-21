package semaphore;

import java.util.concurrent.Semaphore;

public class Queue {
	Semaphore semaphore = new Semaphore(1);

	public Queue() {

	}
	
	public void task() {
		try {
			semaphore.acquire();
			System.out.println("I'm " + Thread.currentThread().getName() + "!");
			System.out.println("I'm doing a task!");
			semaphore.release();			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
