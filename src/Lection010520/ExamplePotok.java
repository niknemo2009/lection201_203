package Lection010520;

import Lection240420.ExampleJUnit;

import java.time.LocalDate;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ExamplePotok {
   private  AtomicLong counter=new AtomicLong(0);

    public    AtomicLong getCounter() {
        return counter;
    }

    public  void setCounter(int par) {
        counter.addAndGet(par);
    }

    public static void main(String[] args) throws InterruptedException {
        Semaphore sem=new Semaphore(3,true);
        sem.acquire();
        sem.release();
        CountDownLatch countDownLatch=new CountDownLatch(7);
        CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
        Phaser phaser=new Phaser();

      //  Thread.sleep(2000);
       // List<>

//        Thread myThread=new Thread(()->{
//          for(int i=0;i<100;i++){
//              System.out.println(i+ " " +Thread.currentThread().getName()+"ExamplePotok.counter "+ExamplePotok.counter.get());
//            //  System.out.println(Thread.currentThread().getState());
//              try {
//                  Thread.sleep(10);
//              } catch (InterruptedException e) {
//                  e.printStackTrace();
//              }
//
//
//          }
//                }, "Potok 1");

//        Thread myThread1=new Thread(()->{
//            for(int i=0;i<100;i++){
//                ExamplePotok.counter.incrementAndGet();
//                System.out.println(Thread.currentThread().getName());
//                //  System.out.println(Thread.currentThread().getState());
//               // System.out.println( );
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, "Potok 2");
//        myThread.start();//&&&&&&&&&&&???????????? run
//myThread1.start();
    }
}
