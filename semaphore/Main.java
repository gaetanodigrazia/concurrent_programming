/**
 * A simple example of producer and consumer semaphore
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
package semaphore;

public class Main {
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		
		producer.start();
		consumer.start();
	}
}
