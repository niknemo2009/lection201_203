package lesson140520;

import lesson0805.Orange;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueue<T> {

    private Queue<T> queue = new LinkedList<T>();
    private AtomicInteger capacity;
    //volatile  int var45=89;

    public BlockingQueue(int capacity) {
        this.capacity = new AtomicInteger(capacity);
    }

    public synchronized void put(T element) throws InterruptedException {
        while(queue.size() == capacity.get()) {
            wait();
        }

        queue.add(element);
        notify(); // notifyAll() for multiple producer/consumer threads
    }

    public synchronized T take() throws InterruptedException {
        while(queue.isEmpty()) {
            wait();
        }

        T item = queue.remove();
        notify(); // notifyAll() for multiple producer/consumer threads
        return item;
    }

    public int getCapacity() {
        return capacity.get();
    }
    int getCount(){
       return queue.size();
    }
}

class TestCollection{
    public static void main(String[] args) {
        BlockingQueue<String>  col=new BlockingQueue<>(10);
        Orange or=new Orange(12," seww");
        synchronized (or){

        }
        Thread thread1=new Thread(()->{
           while(true){
               try {
                   System.out.println("size - "+ col.getCount());
                   col.put("12");
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        Thread thread2=new Thread(()->{
            while(true){
                try {
                    col.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}