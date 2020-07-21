package oculist;

public class Main {

	public static void main(String[] args) {
		boolean x = false;
		Center center = new Center();

		for (int i = 0; i < 3; i++) {
			new Oculist(i, center).start();
		}

		for (int i = 0; i < 100; i++) {
			new Customer(i, x, center).start();
			x = !x;
		}
	}
}
