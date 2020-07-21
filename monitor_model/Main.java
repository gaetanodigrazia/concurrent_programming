/**
 * Il caso in esame vuole studiare la gestione di un parcheggio di un aeroporto. Tale parcheggio prevede:
 * M ingressi e N uscite e la gestione degli autoveicoli che si dispongono in maniera parallela sugli ingressi; 
 * gli autoveicoli entrano in base ai posti liberi nel parcheggio da una delle entrate in cui sono accodate;
 * gli autoveicoli sostano nel parcheggio ed escono da una delle possibili uscite. 
 * Si implementi una politica di gestione del parcheggio di un aeroporto facendo uso del costrutto monitor.
 * Si giustifichino le scelte fatte commentando adeguatamente il codice e si descriva la struttura dei processi autoveicoli.
 * 
 * @author Gaetano Di Grazia
 * @version 1.0
 * License
 * @link https://www.gnu.org/licenses/gpl-3.0.en.html
 * @see Count.java
 */
package monitor_model;

import java.util.Random;

public class Main {
	private final static int NUM_AUTO = 200;

	public static void main(String[] args) {
	
		Monitor c = new Monitor(NUM_AUTO);
		Random r = new Random();
		for(int i = 0; i < NUM_AUTO; i++) {
			new ThreadClass(i, r.nextInt(2), r.nextInt(2), c);
		}
	}

}
