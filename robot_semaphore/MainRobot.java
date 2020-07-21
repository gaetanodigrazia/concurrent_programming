/**
 * Make three thread work always in order R G B, R G B
 * 
 * @author Gaetano Di Grazia
 * @version 1.0
 * License
 * @link https://www.gnu.org/licenses/gpl-3.0.en.html
 * @link https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Semaphore.html
 * @see Turn.java
 * @see Robot.java
 */

package robot_semaphore;

public class MainRobot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Turn turn = new Turn();
		
		Robot robot_r = new Robot("R", turn, 0);
		Robot robot_g = new Robot("G", turn, 1);
		Robot robot_b = new Robot("B", turn, 2);
		
		robot_r.start();
		robot_g.start();
		robot_b.start();
		
	}

}
