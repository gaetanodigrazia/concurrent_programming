package morra_semaphore_V2;

public class Referee extends Thread {
	private Match match;

	public Referee(String name, Match match) {
		super(name);
		setMatch(match);
	}

	public void run() {
		try {
			while (true) {
				getMatch().judge();
				sleep(3000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
