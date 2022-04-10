import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ArrayBlockingQueue<T>{

    private BlockingDeque<T> queue;
    private int limit;

    public ArrayBlockingQueue(int limit) {
        this.queue = new LinkedBlockingDeque<>(limit);
        this.limit = limit;
    }

    public synchronized void put(T item) throws InterruptedException {

        while (this.queue.size() >= this.limit) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        notifyAll();
        this.queue.put(item);
    }

    public synchronized void take() throws InterruptedException {

        while (this.queue.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        notifyAll();
        this.queue.take();
    }

    public BlockingDeque<T> getQueue() {
        return queue;
    }

    public void setQueue(BlockingDeque<T> queue) {
        this.queue = queue;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
