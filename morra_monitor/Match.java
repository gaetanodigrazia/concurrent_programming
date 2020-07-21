package morra_monitor;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Match implements Method {
	Semaphore players = new Semaphore(2);
	Semaphore referee = new Semaphore(0);
	String[] move = { "Scissor", "Paper", "Rock" };
	private int p1 = -1;
	private int p2 = -1;
	private boolean in_game = true;

	public Match() {

	}

	@Override
	public synchronized void play(int ID) {
		Random r = new Random();
		try {
			while (isIn_game() == false) {
				System.out.println("The judge is still judging. You need to wait his start to play again!");
				wait();
			}
			if (p1 == -1 && ID == 1) {
				p1 = r.nextInt(3);
			} else if (p2 == -1 && ID == 2) {
				p2 = r.nextInt(3);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if(p1 != -1 && p2 != -1) {
				played();
			}
			notifyAll();
		}
	}

	@Override
	public synchronized void judge() {
		try {
			while (isIn_game() == true) {
				System.out.println("Players are still in the game.\n You need to wait to judge!");
				wait();
			}
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
			reset();
			judged();
			notify();
		}
	}

	/**
	 * @return the in_game
	 */
	public synchronized boolean isIn_game() {
		return in_game;
	}

	/**
	 * @param in_game the in_game to set
	 */
	public synchronized void setIn_game(boolean in_game) {
		this.in_game = in_game;
	}

	public synchronized void played() {
		setIn_game(false);
	}

	public synchronized void judged() {
		setIn_game(true);
	}

	public synchronized void reset() {
		p1 = -1;
		p2 = -1;
	}

}
