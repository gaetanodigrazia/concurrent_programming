package barbershop_monitor_V1;

public class Barber extends Thread {
	private int ID;
	private Barbershop barbershop;

	public Barber(String name, int ID, Barbershop barbershop) {
		super(name);
		setID(ID);
		setBarbershop(barbershop);
	}

	public void run() {
		try {
			while (true) {
				this.getBarbershop().fetch();
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
	 * @return the barbershop
	 */
	public Barbershop getBarbershop() {
		return barbershop;
	}

	/**
	 * @param barbershop the barbershop to set
	 */
	public void setBarbershop(Barbershop barbershop) {
		this.barbershop = barbershop;
	}

}
