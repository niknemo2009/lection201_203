package Lection010520;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public class Example2 {
volatile int var=56;
AtomicInteger atomicInteger=new AtomicInteger(34);
    public static void main(String[] args) {
        //Collections.

        ExamplePotok exam=new ExamplePotok();
        Whriter wr=new Whriter("Whriter",exam);
//
        Reader rd=new Reader("Reader",exam);
        wr.start();
        rd.start();

    }
}

class Reader extends Thread {
    ExamplePotok ex;

    public Reader(String name, ExamplePotok ex) {
        super(name);
        this.ex = ex;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

                System.out.println(i + " " + Thread.currentThread().getName() + "counter " + ex.getCounter().get());


            //  System.out.println(Thread.currentThread().getState());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Whriter extends  Thread {
    ExamplePotok ex;

    public Whriter(String name, ExamplePotok ex) {
        super(name);
        this.ex = ex;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
synchronized (ex){
    ex.setCounter(i);
    System.out.println(i + " " + Thread.currentThread().getName() + "counter ");
}

            }


            //  System.out.println(Thread.currentThread().getState());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
