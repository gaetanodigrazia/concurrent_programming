package bridge_monitor;

public class Car extends Thread {
	private int weight;
	private int ID;
	private Bridge bridge;
	private int direction;

	public Car(int ID, int weight, Bridge bridge, int direction) {
		setID(ID);
		setWeight(weight);
		setBridge(bridge);
		setDirection(direction);
	}

	public void run() {
		try {
			this.getBridge().addToQueue(this);
			this.getBridge().acquire(this);
			Thread.sleep((int) Math.random() * 3001);
			this.getBridge().release(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
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
	 * @return the bridge
	 */
	public Bridge getBridge() {
		return bridge;
	}

	/**
	 * @param bridge the bridge to set
	 */
	public void setBridge(Bridge bridge) {
		this.bridge = bridge;
	}

	/**
	 * @return the direction
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}
}
