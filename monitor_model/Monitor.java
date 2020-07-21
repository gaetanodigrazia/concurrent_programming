package monitor_model;

import java.util.LinkedList;

public class Monitor implements Method {
	private int NUM_AUTO;
	private String[] varchi = { "Nord", "Sud" };
	private int VERIFY_ENTER;
	private int VERIFY_EXIT;

	private int free_place = 20;

	/* LISTE INGRESSO */
	private LinkedList<ThreadClass> nord_enter = new LinkedList<ThreadClass>();
	private LinkedList<ThreadClass> sud_enter = new LinkedList<ThreadClass>();

	/* LISTE USCITA */
	private LinkedList<ThreadClass> nord_exit = new LinkedList<ThreadClass>();
	private LinkedList<ThreadClass> sud_exit = new LinkedList<ThreadClass>();

	public Monitor(int num_auto) {
		setNUM_AUTO(num_auto);
	}

	@Override
	public synchronized boolean tryEnter(ThreadClass auto) {
		// TODO Auto-generated method stub
		switch (auto.getEnter()) {
		case 0:
			if (nord_enter.size() == 0 && free_place > 0) {
				entrata(auto);
				return true;
			} else {
				nord_enter.add(auto);
				needToWait(auto);
			}
			break;
		case 1:
			if (sud_enter.size() == 0 && free_place > 0) {
				entrata(auto);
				return true;
			} else {
				sud_enter.add(auto);
				needToWait(auto);
			}
			break;
		}
		return false;
	}

	@Override
	public synchronized void entra(ThreadClass auto) {
		// TODO Auto-generated method stub
		switch (auto.getEnter()) {
		case 0:
			while (nord_enter.getFirst().getID() != auto.getID() || free_place == 0) {
				needToWait(auto);
			}
			entrata(auto);
			nord_enter.removeFirst();
			break;
		case 1:
			while (sud_enter.getFirst().getID() != auto.getID() || free_place == 0) {
				needToWait(auto);
			}
			entrata(auto);
			sud_enter.removeFirst();
			break;
		}
	}

	@Override
	public synchronized boolean tryExit(ThreadClass auto) {
		// TODO Auto-generated method stub
		switch (auto.getEnter()) {
		case 0:
			if (nord_exit.size() == 0 && free_place > 0) {
				uscita(auto);
				return true;
			} else {
				nord_exit.add(auto);
				needToWait(auto);
			}
			break;
		case 1:
			if (sud_exit.size() == 0 && free_place > 0) {
				uscita(auto);
				return true;
			} else {
				sud_enter.add(auto);
				needToWait(auto);
			}
			break;
		}
		return false;
	}

	@Override
	public synchronized void esci(ThreadClass auto) {
		// TODO Auto-generated method stub
		switch (auto.getExit()) {
		case 0:
			while (nord_exit.getFirst().getID() != auto.getID() || free_place == 0) {
				needToWait(auto);
			}
			uscita(auto);
			nord_exit.removeFirst();
			break;
		case 1:
			while (sud_exit.getFirst().getID() != auto.getID() || free_place == 0) {
				needToWait(auto);
			}
			uscita(auto);
			sud_exit.removeFirst();
			break;
		}
	}

	public void entrata(ThreadClass auto) {
		System.out.println("E' entrato il veicolo " + auto.getID() + " dall'ingresso " + varchi[auto.getEnter()]);
		if (VERIFY_ENTER == (getNUM_AUTO() - 1)) {
			System.out.println("****************************************");
			System.out.println();
			System.out.println("Sono usciti " + getNUM_AUTO() + " veicoli");
			System.out.println();
			System.out.println("****************************************");

		}
		VERIFY_ENTER++;
		--free_place;
		notifyAll();
	}

	public void uscita(ThreadClass auto) {
		System.out.println("E' uscito il veicolo " + auto.getID() + " dall'ingresso " + varchi[auto.getExit()]);
		if (VERIFY_EXIT == (getNUM_AUTO() - 1)) {
			System.out.println("****************************************");
			System.out.println();
			System.out.println("Sono usciti " + getNUM_AUTO() + " veicoli");
			System.out.println();
			System.out.println("****************************************");

		}
		VERIFY_EXIT++;
		free_place++;
		notifyAll();
	}

	public void needToWait(ThreadClass auto) {
		System.out.println("Scusa " + auto.getID() + " non è il tuo turno o non ci sono posti liberi, devi aspettare!");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the NUM_AUTO
	 */
	public int getNUM_AUTO() {
		return NUM_AUTO;
	}

	/**
	 * @param NUM_AUTO the NUM_AUTO to set
	 */
	public void setNUM_AUTO(int NUM_AUTO) {
		this.NUM_AUTO = NUM_AUTO;
	}

}
