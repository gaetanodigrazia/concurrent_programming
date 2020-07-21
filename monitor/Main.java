/**
 * A simple example of producer and consumer monitor
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
package monitor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SharedSynchronizedBuffer sync = new SharedSynchronizedBuffer();

		Producer producer = new Producer("Producer", sync);
		Consumer consumer = new Consumer("Consumer", sync);
		
		producer.start();
		consumer.start();
	}

}
