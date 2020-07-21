/**
 * Una pizzeria ha N tavoli che possono osiptare 2, 4 o 6 persone ciascuno, piu un tavolo comunitario da 20 posti.
 * I clienti arrivano in gruppi di massimo 10 persone che, chiaramente non vanno separate. 
 * Se è possibile, un gruppo viene preferibilmente fatto accomodare in uno dei tavoli piccoli cercando di ottimizzare l'occupazione.
 * (In altre parole cercando di lasciare il minor punto di posti liberi).
 * Altrimenti il gruppo viene fatto accomodare nel tavolo comunitario insieme ad altri gruppi; infine, se nemmeno li c'è posto,
 * il gruppo viene messo in attesa. Una volta seduti i clienti di un gruppo ordinano e consumano,
 * impiegando per queste operazioni un tempo che può essere simulato di durata casuale, ed infine libera un tavolo.
 * 
 * @author Gaetano Di Grazia
 * @version 1.0
 * License
 * @link https://www.gnu.org/licenses/gpl-3.0.en.html
 * 
 */
package pizzeria_monitor;

public class Pizzeria {

	public static void main(String[] args) {
		int MAX_CLIENT = 30;
		Coda coda = new Coda(MAX_CLIENT);
		int[] npersone = { 2, 4, 6, 8 };

		for (int i = 0; i < MAX_CLIENT; i++) {
			new Gruppo(i, coda, npersone[i % 4]);
			System.out.println("Generato gruppo " + i + " con " + npersone[i % 4]);
		}
	}
}
