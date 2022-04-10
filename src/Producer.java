import java.util.Random;

public class Producer<T> extends Thread{

    private ArrayBlockingQueue queue;

    public Producer(ArrayBlockingQueue queue) {
        this.queue = queue;
    }

    public void run(T item) {
        //Random rand = new Random();
        //int item = rand.nextInt();
        try {
            queue.put(item);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
