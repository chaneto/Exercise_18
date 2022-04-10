public class Consumer extends Thread{
    private ArrayBlockingQueue queue;

    public Consumer(ArrayBlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
