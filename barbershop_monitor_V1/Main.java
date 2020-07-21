/**
 * Lo studio di un parrucchiere consiste di una sala d’attesa con un divano contenente al massimo cinque persone.
 * Nello studio lavorano tre parrucchieri, ciascuno con la propria poltrona dove tagliano i capelli ai clienti.
 * Se non vi sono clienti da servire il parrucchiere si addormenta. 
 * Se un cliente entra nello studio quando è pieno va via senza attendere il proprio turno. 
 * Altrimenti, si accomoda nel divano fino a quando viene chiamato da uno dei parrucchieri. 
 * Il parrucchiere serve per primo il cliente in attesa da più tempo e gli taglia i capelli.
 * 
 * @author Gaetano Di Grazia
 * @version 1.0
 * License
 * @link https://www.gnu.org/licenses/gpl-3.0.en.html
 * @link https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Semaphore.html
 * @see Cabina.java
 * @see Elettore.java
 * @see Metodi.java
 * @see Seggio.java
 */

package barbershop_monitor_V1;

public class Main {
	public static void main(String[] args) {
		int n_clients = 100;
		
		
		Barbershop daFranco = new Barbershop();
		
		Barber tizio = new Barber("Tizio", 0, daFranco);
		Barber caio = new Barber("Caio", 1, daFranco);
		Barber sempronio = new Barber("Sempronio", 2, daFranco);
				
		tizio.start();
		caio.start();
		sempronio.start();
		
		for (int i = 0; i < n_clients; i++) {
			new Customer(i, daFranco).start();
		}
	}
}
