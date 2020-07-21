/**
  * Write a multi-thread program that simulates the game of Chinese morra.
  *
  * In this program there must be 3 Threads:
  * - 2 threads simulate the players
  * - 1 thread simulates the referee
  *
  * The Referee Thread is responsible for:
  * - "kick off".
  * - wait for each of them to make their own move.
  * - check who won.
  * - start again from point 1.
  *
  * Each of the two Thread players must:
  * - wait for the "way".
  * - randomly extract your own move.
  * - notify the referee thread that they have made the move.
  * - return to step 1.
 * 
 * @author Gaetano Di Grazia
 * @version 1.0
 * License
 * @link https://www.gnu.org/licenses/gpl-3.0.en.html
 * @link https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Semaphore.html
 * @see Player.java
 * @see Referee.java
 * @see Match.java
 * 
 */
package morra_semaphore_V2;

public class MainMorra {

	public static void main(String[] args) {
		
		Match match = new Match();
		// TODO Auto-generated method stub
		Player player_1 = new Player("Player 1", match, 1);
		Player player_2 = new Player("Player 2", match, 2);
		Referee referee = new Referee("Referee", match);
		
		player_1.start();
		player_2.start();
		referee.start();
	}

}
