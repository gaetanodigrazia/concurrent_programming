/**
  * A bridge, obviously narrow, allows the passage to vehicles in one direction only at a time.
  * It also imposes a fixed capacity limit C beyond which vehicles can no longer be admitted.
  * Traffic occurs in both directions and only one of them is allowed to enter the bridge at a certain moment.
  * A solution is required that:
  * - do not block access under any circumstances to a unladen bridge;
  * - do not favor one of the two directions, in the case of substantial traffic in both directions.
  * Each vehicle is the only one to know its own weight (for example thanks to a myweight() function).
  * If the current load plus the vehicle weight exceeds the capacity C, the vehicle cannot be accessed.
 * 
 * @author Gaetano Di Grazia
 * @version 1.0
 * License
 * @link https://www.gnu.org/licenses/gpl-3.0.en.html
 * @see Bridge.java
 * @see Car.java
 * @see Method.java
 * 
 */
package bridge_monitor;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		Bridge brooklin = new Bridge();
		int max_weight = 1000;
		int n_cars = 100;

		for (int i = 0; i < n_cars; i++) {
			new Car(i, r.nextInt(max_weight), brooklin, i % 2).start();
		}
	}

}