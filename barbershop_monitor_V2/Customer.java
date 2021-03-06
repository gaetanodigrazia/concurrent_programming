package barbershop_monitor_V2;

public class Customer extends Thread {
	private int ID;
	private Barbershop barber;
	private int chair;

	public Customer(int ID, Barbershop barber) {
		setID(ID);
		setBarber(barber);
	}

	public void run() {
		try {
			if (this.getBarber().addToQueue(this)) {
			} else {
				System.out.println("Sono " + this.getID() + " non c'? posto, arrivederci!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

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
	 * @return the barber
	 */
	public Barbershop getBarber() {
		return barber;
	}

	/**
	 * @param barber the barber to set
	 */
	public void setBarber(Barbershop barber) {
		this.barber = barber;
	}

	/**
	 * @return the chair
	 */
	public int getChair() {
		return chair;
	}

	/**
	 * @param chair the chair to set
	 */
	public void setChair(int chair) {
		this.chair = chair;
	}

}
