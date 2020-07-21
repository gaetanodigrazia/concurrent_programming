package cableway_monitor;

public class Passenger extends Thread {
	private int ID;
	private int direction;
	private Cableway cableway;

	public Passenger(int ID, int direction, Cableway cableway) {
		setID(ID);
		setDirection(direction);
		setCableway(cableway);
	}

	public void run() {
		this.getCableway().addToQueue(this);
		if (getDirection() == 0) {
			this.getCableway().goDown(this);
		} else {
			this.getCableway().goUp(this);
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
	 * @return the direction
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * @return the cableway
	 */
	public Cableway getCableway() {
		return cableway;
	}

	/**
	 * @param cableway the cableway to set
	 */
	public void setCableway(Cableway cableway) {
		this.cableway = cableway;
	}
}
