public class Producer<T> implements Runnable{

    private final ArrayBlockingQueue sharedQueue;

    public Producer(ArrayBlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
            try {
                sharedQueue.put(Thread.currentThread().getName());
                System.out.println("Produced: " + Thread.currentThread().getName());
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
    }

}
