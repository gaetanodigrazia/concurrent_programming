package pizzeria_monitor;

import java.util.LinkedList;

public class Coda implements Metodi {
	private LinkedList<Gruppo> two_queue = new LinkedList<Gruppo>();
	private LinkedList<Gruppo> four_queue = new LinkedList<Gruppo>();
	private LinkedList<Gruppo> six_queue = new LinkedList<Gruppo>();
	private LinkedList<Gruppo> twenty_queue = new LinkedList<Gruppo>();
	private int MAX_CLIENT;

	private int VERIFY_EXIT = 0;
	private int VERIFY_ENTER = 0;

	private final static int nTable_two = 10;
	private final static int nTable_four = 10;
	private final static int nTable_six = 10;
	private final static int nplace_twenty = 20;

	private int free_two = 5;
	private int free_four = 5;
	private int free_six = 5;
	private int free_twenty = 10;

	public Coda(int max_client) {
		this.MAX_CLIENT = max_client;
	}

	@Override
	public synchronized int entra(Gruppo g) {
		// TODO Auto-generated method stub
		entrato(g);
		switch (g.getPersone()) {
		case 2:
			if (free_two != 0) {
				--free_two;
				seduto(g, 2);
				return 0;
			} else {
				two_queue.add(g);
			}
			break;
		case 4:
			if (free_four != 0) {
				--free_four;
				seduto(g, 4);
				return 0;
			} else {
				four_queue.add(g);
			}
			break;
		case 6:
			if (free_six != 0) {
				--free_six;
				seduto(g, 6);
				return 0;
			} else {
				six_queue.add(g);
			}
			break;
		default:
			if (free_twenty >= g.getPersone()) {
				free_twenty -= g.getPersone();
				seduto(g, 20);
				return 0;
			} else {
				twenty_queue.add(g);
			}
			break;
		}
		return -1;
	}

	@Override
	public synchronized void siedi(Gruppo g) {
		// TODO Auto-generated method stub
		try {
			switch (g.getPersone()) {
			case 2:
				while (two_queue.getFirst().getID() != g.getID() || free_two == 0) {
					needToWait(g);
					wait();
				}
				--free_two;
				two_queue.removeFirst();
				seduto(g, 2);
				break;
			case 4:
				while (four_queue.getFirst().getID() != g.getID() || free_four == 0) {
					needToWait(g);
					wait();
				}
				--free_four;
				four_queue.removeFirst();
				seduto(g, 4);
				break;
			case 6:
				while (six_queue.getFirst().getID() != g.getID() || free_six == 0) {
					needToWait(g);
					wait();
				}
				--free_six;
				six_queue.removeFirst();
				seduto(g, 6);
				break;
			default:
				while (twenty_queue.getFirst().getID() != g.getID() || (free_twenty - g.getPersone()) < 0) {
					needToWait(g);
					wait();
				}
				free_twenty -= g.getPersone();
				twenty_queue.removeFirst();
				seduto(g, 20);
				break;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		notifyAll();
	}

	@Override
	public synchronized void esci(Gruppo g) {
		// TODO Auto-generated method stub
		switch (g.getTavolo()) {
		case 2:
			free_two++;
			uscito(g);
			break;
		case 4:
			free_four++;
			uscito(g);
			break;
		case 6:
			free_six++;
			uscito(g);
			break;
		default:
			free_twenty += g.getPersone();
			uscito(g);
			break;
		}
		notifyAll();
	}

	public void seduto(Gruppo g, int place) {
		System.out.println("Gruppo + " + g.getID() + " si è seduto in un tavolo da " + place);
		g.setTavolo(place);
		if (VERIFY_ENTER == (MAX_CLIENT - 1)) {
			System.out.println("****************************************");
			System.out.println();
			System.out.println("Sono entrati " + MAX_CLIENT + " GRUPPI");
			System.out.println();
			System.out.println("****************************************");
		}
		VERIFY_ENTER++;
	}

	public void entrato(Gruppo g) {
		System.out.println("E' entrato il gruppo " + g.getID() + " desiderano un tavolo per " + g.getPersone());
	}

	public void uscito(Gruppo g) {
		System.out.println("Gruppo + " + g.getID() + " è appena uscito!");
		if (VERIFY_EXIT == (MAX_CLIENT - 1)) {
			System.out.println("****************************************");
			System.out.println();
			System.out.println("Sono usciti " + MAX_CLIENT + " GRUPPI");
			System.out.println();
			System.out.println("****************************************");

		}
		VERIFY_EXIT++;
	}

	public void needToWait(Gruppo g) {
		System.out.println("Sorry " + g.getID() + " you need to wait!");
	}

}
