/*
 * Al pronto soccorso di un importante ospedale i pazienti in arrivo vengono raggruppati secondo codici di urgenza.
 *  I codici attualmente adoperati sono: rosso, giallo, verde e bianco (in ordine decrescente di priorit�). 
 *  Uno sportello apposito, chiamato triage, decide quali pazienti possono accedere alle sale d'intervento in un particolare momento.
 *  Nell'ospedale sono presenti N medici i quali assistono i pazienti a turno.
 *  I pazienti con priorit� pi� elevata hanno la precedenza sui pazienti con priorit� pi� bassa, mentre i pazienti a cui � stato assegnato 
 *  lo stesso codice vengono fatti accomodare secondo la politica FCFS (first-comefirst-served). 
 *  Per semplicit� si supponga che gli interventi in atto non possano essere interrotti dall'arrivo di un paziente con il codice pi� urgente. 
 */
package hospital_monitor;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Hospital hospital = new Hospital();
		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			new Doctor(i, hospital).start();
		}

		for (int i = 0; i < 100; i++) {
			new Patient(i, hospital, r.nextInt(4)).start();
		}
	}
}
