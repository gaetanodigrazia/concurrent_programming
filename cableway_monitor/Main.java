/**
 * In una piccola località turistica è in funzione una funivia, con una cabina che può contenere al massimo MAX passeggeri.
 *  La funivia effettua due fermate: una a valle e una a monte. 
 *  La cabina parte dalla fermata a valle solo quando ha caricato almeno MIN passeggeri,
  mentre è  sufficiente anche solo un passeggero per partire dalla fermata a monte. 
	Ogni passeggero,
	dopo essere entrato nella cabina a valle, aspetta che questa arrivi a monte per uscire; quando ha finito 
	la visita, riprende la funivia e attende che la cabina arrivi a valle per uscire. 
	Si implementi una soluzione usando il costrutto monitor per modellare la funivia
	 e i processi per modellare  i passeggeri e la cabina e si descriva la sincronizzazione tra i processi. 
 * 
 * @author Gaetano Di Grazia
 * @version 1.0
 * License
 * @link https://www.gnu.org/licenses/gpl-3.0.en.html
 * @see Consumer.java
 * @see Producer.java
 * @see Queue.java
 * 
 */
package cableway_monitor;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		int passengers = 100;
		Random r = new Random();
		Cableway cableway = new Cableway();
		for (int i = 0; i < passengers; i++) {
			if (i % 2 == 0) {
				System.out.println("Passenger " + i + " direction GO UP ");
			} else {
				System.out.println("Passenger " + i + " direction GO DOWN");
			}
			new Passenger(i, i % 2, cableway).start();
		}
	}

}
