package hospital_monitor;

public class Doctor extends Thread {
	private int ID;
	private Hospital hospital;

	public Doctor(int ID, Hospital hospital) {
		setID(ID);
		setHospital(hospital);
	}

	public void run() {
		try {
			while (true) {
				if (this.getHospital().thereIsPeople()) {
					this.getHospital().visit();
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
	 * @return the hospital
	 */
	public Hospital getHospital() {
		return hospital;
	}

	/**
	 * @param hospital the hospital to set
	 */
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
}
