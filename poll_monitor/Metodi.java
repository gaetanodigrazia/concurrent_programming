package poll_monitor;

import java.util.LinkedList;

public interface Metodi {
	void tryAcquire(Elettore elettore);

	void acquire(Elettore elettore);

	void release(Cabina cabina);

	boolean isFirst(Elettore elettore, LinkedList<Elettore> fila);

	boolean isEmpty(LinkedList<Elettore> fila);

	void needToWait(Elettore elettore);

	int checkDisponibility();
}
