package robot_semaphore;

import java.util.concurrent.Semaphore;

public class Turn {
	Semaphore robot_r = new Semaphore(1);
	Semaphore robot_g = new Semaphore(0);
	Semaphore robot_b = new Semaphore(0);

	public Turn() {

	}

	public void print(int ID) {
		if (ID == 0) {
			try {
				robot_r.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				System.out.println(Thread.currentThread().getName());
				robot_g.release();
			}
		} else if (ID == 1) {
			try {
				robot_g.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				System.out.println(Thread.currentThread().getName());
				robot_b.release();
			}
		} else {
			try {
				robot_b.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				System.out.println(Thread.currentThread().getName());
				robot_r.release();
			}
		}
	}
}
