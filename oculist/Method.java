package oculist;

public interface Method {
	void addToQueue(Customer customer);

	Customer fetch(Oculist oculist);

	void visit(Customer customer, Oculist oculist);

	boolean isEmpty();
	
	void needToWait(String message);
	
	void dilate();
	
	void pay();
	
	int isMine(Oculist oculist);
	
	boolean someoneIsSpecial();
	
	void visitTime();
}
