package poll_monitor;

public class Elettore extends Thread {
	private int ID;
	private Seggio seggio;

	public Elettore(int ID, Seggio seggio) {
		setID(ID);
		setSeggio(seggio);
	}

	public void run() {
		try {
			this.getSeggio().tryAcquire(this);
			sleep((int) Math.random() * 1001);
			this.getSeggio().acquire(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	 * @return the seggio
	 */
	public Seggio getSeggio() {
		return seggio;
	}

	/**
	 * @param seggio the seggio to set
	 */
	public void setSeggio(Seggio seggio) {
		this.seggio = seggio;
	}

}
