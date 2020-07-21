package hospital_monitor;

public class Turn {
	private int priority = 0;

	private int white_counter = 0;
	private int green_counter = 0;
	private int yellow_counter = 0;
	private int red_counter = 0;

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * @return the white_counter
	 */
	public int getWhite_counter() {
		return white_counter;
	}

	/**
	 * @param white_counter the white_counter to set
	 */
	public void setWhite_counter(int white_counter) {
		this.white_counter = white_counter;
	}

	/**
	 * @return the green_counter
	 */
	public int getGreen_counter() {
		return green_counter;
	}

	/**
	 * @param green_counter the green_counter to set
	 */
	public void setGreen_counter(int green_counter) {
		this.green_counter = green_counter;
	}

	/**
	 * @return the yellow_counter
	 */
	public int getYellow_counter() {
		return yellow_counter;
	}

	/**
	 * @param yellow_counter the yellow_counter to set
	 */
	public void setYellow_counter(int yellow_counter) {
		this.yellow_counter = yellow_counter;
	}

	/**
	 * @return the red_counter
	 */
	public int getRed_counter() {
		return red_counter;
	}

	/**
	 * @param red_counter the red_counter to set
	 */
	public void setRed_counter(int red_counter) {
		this.red_counter = red_counter;
	}

	public void newPatient(Patient patient) {
		switch (patient.getPriority_code()) {
		case 0:
			newWhite();
			break;
		case 1:
			newGreen();
			break;
		case 2:
			newYellow();
			break;
		case 3:
			newRed();
			break;
		}
	}

	public void increment() {
		if (this.priority == 3) {
			this.setPriority(0);
		} else {
			priority++;
		}
	}

	public void newWhite() {
		white_counter++;
		if (white_counter == 1) {
			setPriority(0);
		}
	}

	public void newGreen() {
		green_counter++;
		if (green_counter == 1) {
			setPriority(3);
		}
	}

	public void newYellow() {
		yellow_counter++;
		if (yellow_counter == 1) {
			setPriority(2);
		}
	}

	public void newRed() {
		red_counter++;
		if (red_counter == 1) {
			setPriority(1);
		}
	}
}
