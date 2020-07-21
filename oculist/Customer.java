package oculist;

public class Customer extends Thread {
	private int ID;
	private Center center;
	private boolean standard;
	private Oculist oculist;

	public Customer(int ID, boolean standard, Center center) {
		setID(ID);
		setStandard(standard);
		setCenter(center);
	}

	public void run() {
		try {
			getCenter().addToQueue(this);
		}catch(Exception e) {
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

	/**
	 * @return the standard
	 */
	public boolean isStandard() {
		return standard;
	}

	/**
	 * @param standard the standard to set
	 */
	public void setStandard(boolean standard) {
		this.standard = standard;
	}

	/**
	 * @return the oculist
	 */
	public Oculist getOculist() {
		return oculist;
	}

	/**
	 * @param oculist the oculist to set
	 */
	public void setOculist(Oculist oculist) {
		this.oculist = oculist;
	}
}
