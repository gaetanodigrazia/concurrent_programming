/**
 * Si supponga di avere un deposito bagagli composto da V vani ognuno dei quali in grado di contenere N valigie. 
 * Gli utenti arrivano con un numero variabile (ma minore di N) di valigie, le depositano e, dopo un certo tempo, le ritirano. 
 * Tutte le valigie di uno stesso utente devono essere depositate all'interno di un unico vano,
 * 	ma uno stesso vano può contenere le valigie di più utenti. 
 * Gli utenti che non riescono a depositare le valigie per problemi di capacità si pongono in attesa che si liberi dello spazio. 
 * Si modelli lo scenario descritto mediante thread in linguaggio Java usando il costrutto 
 * monitor verificando che la soluzione proposta non presenti rinvio indefinito o deadlock.
 * 
 * @author Gaetano Di Grazia
 * @version 1.0
 * License
 * @link https://www.gnu.org/licenses/gpl-3.0.en.html
 * @see Deposit.java
 * @see Luggage.java
 * @see Passenger.java
 */
package luggage_deposit_monitor;

import java.util.Random;

public class Main {
	final static int MAX_LUGGAGE_P = 4;

	public static void main(String[] args) {
		Deposit deposit = new Deposit();
		Random r = new Random();

		for (int i = 0; i < 100; i++) {
			new Passenger(i, deposit, r.nextInt(MAX_LUGGAGE_P) + 1).start();
		}
	}
}
