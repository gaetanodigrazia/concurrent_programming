package pizzeria_monitor;

import java.util.Random;

public class Gruppo extends Thread {
	private int ID;
	private Coda coda;
	private int persone;
	private int tavolo = -1;
	private static final int MAX_EATING_TIME = 5001;

	public Gruppo(int ID, Coda coda, int persone) {
		setCoda(coda);
		setPersone(persone);
		this.setID(ID);
		this.start();
	}

	public void run() {
		Random r = new Random();
		try {
			sleep(r.nextInt(1000));
			if (getCoda().entra(this) == -1) {
				sleep(r.nextInt(1000));
				getCoda().siedi(this);
			}
			// MANGIA
			sleep(r.nextInt(MAX_EATING_TIME));
			getCoda().esci(this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the tavolo
	 */
	public int getTavolo() {
		return tavolo;
	}

	/**
	 * @param tavolo the tavolo to set
	 */
	public void setTavolo(int tavolo) {
		this.tavolo = tavolo;
	}

	/**
	 * @return the persone
	 */
	public int getPersone() {
		return persone;
	}

	/**
	 * @param persone the persone to set
	 */
	public void setPersone(int persone) {
		this.persone = persone;
	}

	/**
	 * @return the coda
	 */
	public Coda getCoda() {
		return coda;
	}

	/**
	 * @param coda the coda to set
	 */
	public void setCoda(Coda coda) {
		this.coda = coda;
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

}
