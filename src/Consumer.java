import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private final ArrayBlockingQueue sharedQueue;

    public Consumer (ArrayBlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
            try {
                System.out.println("Consumed: "+ sharedQueue.take());
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
    }
}
