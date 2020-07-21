package oculist;

public class Oculist extends Thread {
	private int ID;
	private Center center;
	Customer c;

	public Oculist(int ID, Center center) {
		setID(ID);
		setCenter(center);
	}

	public void run() {
		try {
			while (true) {
				if (getCenter().isEmpty()) {
				} else {
					c = getCenter().fetch(this);
					getCenter().visit(c, this);
				}
			}
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
	 * @return the center
	 */
	public Center getCenter() {
		return center;
	}

	/**
	 * @param center the center to set
	 */
	public void setCenter(Center center) {
		this.center = center;
	}
}
