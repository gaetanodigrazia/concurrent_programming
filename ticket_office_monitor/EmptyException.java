package ticket_office_monitor;

public class EmptyException extends Exception {
	public EmptyException(String message) {
		super(message);
		System.exit(-1);
	}
}