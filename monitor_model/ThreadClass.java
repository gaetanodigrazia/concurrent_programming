package monitor_model;

public class ThreadClass extends Thread {
	private int enter;
	private int exit;
	private int ID;
	private Monitor coda;

	public ThreadClass(int ID, int enter, int exit, Monitor coda) {
		setEnter(enter);
		setID(ID);
		setCoda(coda);
		setExit(exit);
		this.start();
	}

	public void run() {
		try {
			if (!getCoda().tryEnter(this)) {
				getCoda().entra(this);
				sleep((int) Math.random() * 3001);
			} else if (!getCoda().tryExit(this)) {
				getCoda().esci(this);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the enter
	 */
	public int getEnter() {
		return enter;
	}

	/**
	 * @param enter the enter to set
	 */
	public void setEnter(int enter) {
		this.enter = enter;
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

	/**
	 * @return the coda
	 */
	public Monitor getCoda() {
		return coda;
	}

	/**
	 * @param coda the coda to set
	 */
	public void setCoda(Monitor coda) {
		this.coda = coda;
	}

	/**
	 * @return the exit
	 */
	public int getExit() {
		return exit;
	}

	/**
	 * @param exit the exit to set
	 */
	public void setExit(int exit) {
		this.exit = exit;
	}
}
