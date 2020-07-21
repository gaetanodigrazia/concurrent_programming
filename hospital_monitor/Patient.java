package hospital_monitor;

public class Patient extends Thread {
	private int ID;
	private Hospital hospital;
	private int priority_code;

	public Patient(int ID, Hospital hospital, int priority_code) {
		setID(ID);
		setHospital(hospital);
		setPriority_code(priority_code);
	}

	public void run() {
		try {
			this.getHospital().addToQueue(this);
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

	/**
	 * @return the priority_code
	 */
	public int getPriority_code() {
		return priority_code;
	}

	/**
	 * @param priority_code the priority_code to set
	 */
	public void setPriority_code(int priority_code) {
		this.priority_code = priority_code;
	}
}
