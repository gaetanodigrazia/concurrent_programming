package barbershop_monitor_V2;

public class Cashier extends Thread {
	private Barbershop barbershop;

	public Cashier(String name, Barbershop barbershop) {
		super(name);
		setBarbershop(barbershop);
	}

	public void run() {
		try {
			while (true) {
				this.getBarbershop().pay();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
