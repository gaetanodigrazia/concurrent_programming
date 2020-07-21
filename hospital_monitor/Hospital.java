package hospital_monitor;

import java.util.LinkedList;

public class Hospital implements Method {
	private LinkedList<Patient> white_code = new LinkedList<Patient>();
	private LinkedList<Patient> green_code = new LinkedList<Patient>();
	private LinkedList<Patient> yellow_code = new LinkedList<Patient>();
	private LinkedList<Patient> red_code = new LinkedList<Patient>();

	private String[] code_names = { "White", "Green", "Yellow", "Red" };
	private Turn turn = new Turn();
	int counter = 0;

	public Hospital() {

	}

	@Override
	public synchronized void addToQueue(Patient patient) {
		// TODO Auto-generated method stub
		getQueue(patient).add(patient);
		System.out.println("I doctor, I'm " + patient.getID() + " and I'm sick. I think I'm a "
				+ getCodename(patient.getPriority_code()));
		notifyAll();
	}

	@Override
	public synchronized boolean thereIsPeople() {
		// TODO Auto-generated method stub
		if (white_code.size() == 0 && green_code.size() == 0 && yellow_code.size() == 0 && red_code.size() == 0) {
			return false;
		}
		return true;
	}

	@Override
	public synchronized void visit() {
		// TODO Auto-generated method stub
		if (thereIsPeople()) {
			if (getNextPatientQueue(turn).size() == 0) {
				turn.increment();
			} else {
				System.out.println("Hi mr " + getNextPatientQueue(turn).getFirst().getID() + " is your turn!");
				visiting();
				System.out.println("Goodby mr " + getNextPatientQueue(turn).getFirst().getID() + ", now you're OK!");
				turn.newPatient(getNextPatientQueue(turn).getFirst());
				getNextPatientQueue(turn).removeFirst();
				notifyAll();
				counter++;
			}

		} else {
			if (counter == 100) {
				System.out.println("Ho curato tutti i pazienti dalle carie, ora stanno tutti bene!");
			}
			needToWait("No one need visit, goodnight!");
		}
	}

	@Override
	public LinkedList<Patient> getQueue(Patient patient) {
		// TODO Auto-generated method stub
		switch (patient.getPriority_code()) {
		case 0:
			return white_code;
		case 1:
			return green_code;
		case 2:
			return yellow_code;
		case 3:
			return red_code;
		}
		return null;
	}

	public LinkedList<Patient> getNextPatientQueue(Turn turn) {
		// TODO Auto-generated method stub
		switch (turn.getPriority()) {
		case 0:
			return white_code;
		case 1:
			return green_code;
		case 2:
			return yellow_code;
		case 3:
			return red_code;
		}
		return null;
	}

	@Override
	public void needToWait(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getCodename(int code) {
		return code_names[code];
	}

	public boolean isFirst(Patient patient) {
		if (this.getQueue(patient).getFirst().getID() == patient.getID()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void leaveHospital() {
		// TODO Auto-generated method stub

	}

	public void visiting() {
		try {
			Thread.currentThread().sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
