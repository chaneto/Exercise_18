import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;

public class ArrayBlockingQueue<T>{

    private Queue<T> queue;
    private int limit;

    public ArrayBlockingQueue(int limit) {
        this.queue = new LinkedList<T>();
        this.limit = limit;
    }

    public synchronized void put(T item)  throws InterruptedException  {

        while (this.queue.size() >= this.limit) {
            System.out.println("Queue is full Producer: "+ Thread.currentThread().getName() + " is waiting");
            this.wait();
        }

        this.queue.add(item);
            this.notifyAll();
    }

    public synchronized T take()  throws InterruptedException{

        while (this.queue.size() == 0) {
            System.out.println("Queue is empty Consumer: "+ Thread.currentThread().getName() + " is waiting");
            this.wait();
        }

        this.notifyAll();
        return queue.poll();

    }

    public Queue<T> getQueue() {
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
