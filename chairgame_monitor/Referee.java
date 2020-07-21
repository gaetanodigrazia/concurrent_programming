package chairgame_monitor;

public class Referee extends Thread {
	private Room room;

	public Referee(String name, Room room) {
		super(name);
		setRoom(room);
	}

	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				this.getRoom().play();
				sleep(1000);
				this.getRoom().judge();
			}
			System.out.println("No one is still playing, goodbye!");
		} catch (Exception e) {
			e.printStackTrace();
		}
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
}
