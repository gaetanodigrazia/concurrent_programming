package poll_monitor;

import java.util.LinkedList;
import java.util.Random;

public class Seggio implements Metodi {
	private int candidato_1 = 0;
	private int candidato_2 = 0;

	private LinkedList<Cabina> cabine = new LinkedList<Cabina>();
	private LinkedList<Elettore> fila = new LinkedList<Elettore>();

	public Seggio() {
		cabine.add(new Cabina(1, 0));
		cabine.add(new Cabina(2, 0));
		cabine.add(new Cabina(3, 0));
		cabine.add(new Cabina(4, 0));
	}

	@Override
	public synchronized void tryAcquire(Elettore elettore) {
		// TODO Auto-generated method stub
		fila.add(elettore);
	}

	@Override
	public synchronized void acquire(Elettore elettore) {
		// TODO Auto-generated method stub
		int available = checkDisponibility();
		while (!isFirst(elettore, fila) || available == -1) {
			needToWait(elettore);
		}
		cabine.get(available).setAvailable(-1);
		vota(cabine.get(available), elettore);
		release(cabine.get(available));
		notifyAll();
	}

	@Override
	public synchronized void release(Cabina cabina) {
		// TODO Auto-generated method stub
		fila.removeFirst();
		cabina.setAvailable(0);
	}

	@Override
	public boolean isFirst(Elettore elettore, LinkedList<Elettore> fila) {
		// TODO Auto-generated method stub
		if (elettore.getID() == fila.getFirst().getID()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty(LinkedList<Elettore> fila) {
		// TODO Auto-generated method stub
		if (fila.size() == 0) {
			return true;
		}
		return false;
	}

	public void vota(Cabina cabina, Elettore elettore) {
		try {
			Random r = new Random();
			int x = r.nextInt(2) + 1;
			switch (x) {
			case 1:
				candidato_1++;
				break;
			case 2:
				candidato_2++;
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void needToWait(Elettore elettore) {
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int checkDisponibility() {
		int cont = -1;
		Random r = new Random();
		for (int i = 0; i < cabine.size(); i++) {
			if (cabine.get(i).getAvailable() == 0) {
				cont++;
			} else {
				break;
			}
		}
		if (cont == -1) {
			return -1;
		}
		return r.nextInt(cont);
	}
}
