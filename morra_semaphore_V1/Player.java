package morra_semaphore_V1;

public class Player extends Thread {
	private int ID;
	private Match match;

	public Player(String name, Match match, int ID) {
		super(name);
		setMatch(match);
		setID(ID);
	}

	public void run() {
		try {
			while (true)
				getMatch().play(getID());
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
	 * @return the match
	 */
	public Match getMatch() {
		return match;
	}

	/**
	 * @param match the match to set
	 */
	public void setMatch(Match match) {
		this.match = match;
	}
}
