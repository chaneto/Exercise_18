import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
      Scanner scanner = new Scanner(System.in);
        ArrayBlockingQueue queue = new ArrayBlockingQueue(5);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        producer.start();
        consumer.start();

    }
}
