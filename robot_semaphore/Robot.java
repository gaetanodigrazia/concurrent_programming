package robot_semaphore;

public class Robot extends Thread{
	private Turn turn;
	private int ID;

	public Robot(String name, Turn turn, int ID) {
		super(name);
		setTurn(turn);
		setID(ID);
	}
	
	public void run() {
		try {
			while(true) {
				getTurn().print(getID());	
				sleep(1000);
			}
		} catch(Exception e) {
		e.printStackTrace();	
		}
	}

	/**
	 * @return the turn
	 */
	public Turn getTurn() {
		return turn;
	}
	/**
	 * @param turn the turn to set
	 */
	public void setTurn(Turn turn) {
		this.turn = turn;
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
}
