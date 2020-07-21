/**
 * Simulate a vote system
 * 
 * @author Gaetano Di Grazia
 * @version 1.0
 * License
 * @link https://www.gnu.org/licenses/gpl-3.0.en.html
 * @link https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Semaphore.html
 * @see Cabina.java
 * @see Elettore.java
 * @see Metodi.java
 * @see Seggio.java
 */
package poll_monitor;

public class Main {
	public static void main(String[] args) {
		int elettori = 500;
		Seggio seggio = new Seggio();
		for (int i = 0; i < elettori; i++) {
			new Elettore(i, seggio).start();
		}
	}
}
