/**
  * Implement a solution that models the game of chairs.
  * As is known, initially there are N participants and N-1 chairs.
  * An external referee starts the game and each person must try to sit as quickly as possible on one of the chairs.
  * At the end of the first round, a person will be left without the chair and will have to retire (by printing his ID on the screen).
  * The game then continues with N-1 people and N-2 chairs.
  * The referee starts the next round and so on until there is only one person left who is the winner of the game.
  * Also, describe the synchronization between threads and discuss whether the proposed solution
  * may submit indefinite referral and / or deadlock, and if so, discuss any changes to avoid them.
 * 
 * @author Gaetano Di Grazia
 * @version 1.0
 * License
 * @link https://www.gnu.org/licenses/gpl-3.0.en.html
 * @see Method.java
 * @see Player.java
 * @see Room.java
 */
package chairgame_monitor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Room room = new Room();
		
		Referee referee = new Referee("Referee", room);
		Player p1 = new Player("Leonard", 0, room);
		Player p2 = new Player("Sheldon", 1, room);
		Player p3 = new Player("Penny", 2, room);
		Player p4 = new Player("Howard", 3, room);
		Player p5 = new Player("Raj", 4, room);
		Player p6 = new Player("Leslie", 5, room);
		Player p7 = new Player("Bernadette", 6, room);
		Player p8 = new Player("Amy", 7, room);
		Player p9 = new Player("Stuart", 8, room);
		Player p10 = new Player("Emily", 9, room);
		
		referee.start();
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		p6.start();
		p7.start();
		p8.start();
		p9.start();
		p10.start();
		
	}

}
