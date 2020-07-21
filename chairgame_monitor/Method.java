package chairgame_monitor;

public interface Method {
	void addToQueue(Player player);

	void judge();

	void play();

	void needToWait(String message);
	
	void printPlayers();
}
