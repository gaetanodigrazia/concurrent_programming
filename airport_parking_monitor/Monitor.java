package airport_parking_monitor;

import java.util.ArrayList;
import java.util.LinkedList;

public class Monitor implements Method {
	private int num_auto;
	private String[] varchi = { "Nord", "Sud", "Est", "Ovest" };
	private int VERIFY_ENTER;
	private int VERIFY_EXIT;

	private int free_place = 20;

	/* LISTE INGRESSO */
	private LinkedList<Car> nord_enter = new LinkedList<Car>();
	private LinkedList<Car> sud_enter = new LinkedList<Car>();
	private LinkedList<Car> est_enter = new LinkedList<Car>();
	private LinkedList<Car> ovest_enter = new LinkedList<Car>();

	private ArrayList<LinkedList<Car>> entrate = new ArrayList<LinkedList<Car>>();

	/* LISTE USCITA */
	private LinkedList<Car> nord_exit = new LinkedList<Car>();
	private LinkedList<Car> sud_exit = new LinkedList<Car>();
	private LinkedList<Car> est_exit = new LinkedList<Car>();
	private LinkedList<Car> ovest_exit = new LinkedList<Car>();

	private ArrayList<LinkedList<Car>> uscite = new ArrayList<LinkedList<Car>>();

	public Monitor(int num_auto) {
		setNUM_AUTO(num_auto);
		entrate.add(nord_enter);
		entrate.add(sud_enter);
		entrate.add(est_enter);
		entrate.add(ovest_enter);

		uscite.add(nord_exit);
		uscite.add(sud_exit);
		uscite.add(est_exit);
		uscite.add(ovest_exit);
	}

	@Override
	public synchronized boolean tryAcquire(Car auto) {
		// TODO Auto-generated method stub
		if (getEnter(auto).size() == 0 && free_place > 0) {
			acquired(auto);
			return true;
		} else {
			getEnter(auto).add(auto);
			needToWait(auto);
		}
		return false;
	}

	@Override
	public synchronized void acquire(Car auto) {
		// TODO Auto-generated method stub
		while (getEnter(auto).getFirst().getID() != auto.getID() || free_place == 0) {
			needToWait(auto);
		}
		acquired(auto);
		getEnter(auto).removeFirst();
	}
	
	@Override
	public synchronized void acquired(Car auto) {
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

	@Override
	public synchronized boolean tryRelease(Car auto) {
		// TODO Auto-generated method stub
		if (getExit(auto).size() == 0) {
			released(auto);
			return true;
		} else {
			getExit(auto).add(auto);
			needToWait(auto);
		}
		return false;
	}

	@Override
	public synchronized void release(Car auto) {
		// TODO Auto-generated method stub
		while (getExit(auto).getFirst().getID() != auto.getID()) {
			needToWait(auto);
		}
		released(auto);
		getExit(auto).removeFirst();
	}

	@Override
	public void released(Car auto) {
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
	
	@Override
	public void needToWait(Car auto) {
		System.out.println("Scusa " + auto.getID() + " non è il tuo turno o non ci sono posti liberi, devi aspettare!");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the nUM_AUTO
	 */
	public int getNUM_AUTO() {
		return num_auto;
	}

	/**
	 * @param nUM_AUTO the nUM_AUTO to set
	 */
	public void setNUM_AUTO(int nUM_AUTO) {
		num_auto = nUM_AUTO;
	}
	@Override
	public LinkedList<Car> getEnter(Car a) {
		return entrate.get(a.getEnter());
	}
	@Override
	public LinkedList<Car> getExit(Car a) {
		return uscite.get(a.getExit());
	}

}
