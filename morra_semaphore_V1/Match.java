package morra_semaphore_V1;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Match {
	Semaphore player_1 = new Semaphore(1);
	Semaphore player_2 = new Semaphore(1);
	Semaphore referee = new Semaphore(0);
	String[] move = { "Scissor", "Paper", "Rock" };
	int p1 = -1, p2 = -1;

	public Match() {
		
	}

	public void play(int ID) {
		Random r = new Random();
		try {
			if (p1 == -1 && ID == 1) {
				player_1.acquire();
				p1 = r.nextInt(3);
			} else if (p2 == -1 && ID == 2) {
				player_2.acquire();
				p2 = r.nextInt(3);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			referee.release();
		}
	}

	public void judge() {
		try {
			referee.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("P1: " + move[p1] + " - P2: " + move[p2]);
			switch (p1) {
			case 0:
				if (p2 == 1) {
					System.out.println("Player 1 Wins");
				} else if (p2 == 2) {
					System.out.println("Player 2 Wins");
				} else {
					System.out.println("Draw");
				}
				break;
			case 1:
				if (p2 == 1) {
					System.out.println("Draw");
				} else if (p2 == 2) {
					System.out.println("Player 1 Wins");
				} else {
					System.out.println("Player 2 Wins");
				}
				break;
			case 2:
				if (p2 == 0) {
					System.out.println("Player 1 Wins");
				} else if (p2 == 2) {
					System.out.println("Draw");
				} else {
					System.out.println("Player 2 Wins");
				}
				break;
			}
			p1 = -1;
			p2 = -1;
			player_1.release();
			player_2.release();
		}
	}
}
