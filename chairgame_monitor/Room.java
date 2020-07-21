package chairgame_monitor;

import java.util.LinkedList;
import java.util.Random;

public class Room implements Method {
	private LinkedList<Player> players = new LinkedList<Player>();
	private LinkedList<Player> lost = new LinkedList<Player>();
	private int still_alive = 10;
	private int in_game = 1;
	public Random r = new Random();

	@Override
	public synchronized void addToQueue(Player player) {
		// TODO Auto-generated method stub
		System.out.println("Hi! I'm " + player.getName() + " and I want to play!");
		players.add(player);
		notifyAll();
	}

	@Override
	public synchronized void judge() {
		// TODO Auto-generated method stub
		while (in_game == 1 || players.size() != still_alive) {
			needToWait("The players are in game, I need to wait!");
		}
		int tostop = r.nextInt(players.size());
		if (still_alive == 1) {
			System.out.println("The winner is: " + players.get(0).getName());
		} else {
			printPlayers();
			System.out.println("Sorry, " + players.get(tostop).getName() + " you lost the game!");
			players.remove(tostop);
			--still_alive;
			in_game = 1;
		}
		notifyAll();

	}

	@Override
	public synchronized void play() {
		while (in_game == 0 || players.size() != still_alive) {
			needToWait("The judge is still working, need to wait!");
		}
		System.out.println("We are dancing...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("We are run to sit in one chair, fast!!!");
		in_game = 0;
		notifyAll();
	}

	@Override
	public void needToWait(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printPlayers() {
		for (int i = 0; i < players.size(); i++) {
			System.out.println("Player " + players.get(i).getName() + " is still in game!");
		}
	}
}
