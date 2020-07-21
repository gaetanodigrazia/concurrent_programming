package hospital_monitor;

import java.util.LinkedList;

public interface Method {
	void addToQueue(Patient patient);

	boolean thereIsPeople();

	void visit();

	LinkedList<Patient> getQueue(Patient patient);

	void needToWait(String message);

	void leaveHospital();
}
