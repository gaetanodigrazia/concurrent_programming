package chairgame_monitor;

public class Player extends Thread {
	private int ID;
	private Room room;
	private boolean running;

	public Player(String name, int ID, Room room) {
		super(name);
		setID(ID);
		setRoom(room);
		setRunning(true);
	}

	public void run() {
		try {
			this.getRoom().addToQueue(this);
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
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

	/**
	 * @return the running
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * @param running the running to set
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}
}
