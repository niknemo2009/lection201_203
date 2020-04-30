package Lection050520;

import java.util.ArrayList;
import java.util.List;

public class ExampleThread {

    public static void main(String[] args) throws InterruptedException {
//        Thread current=Thread.currentThread();
//        System.out.println(current.getName());
//        System.out.println(current.getState());
//        System.out.println(current.getPriority());
//        System.out.println(current.getThreadGroup());
//        System.out.println(current.getId());
        //Thread.MAX_PRIORITY
        //MyThread myThread=new MyThread("Potok",30);
        List<Integer>  list=new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        MyThreadR myThread=new MyThreadR("1 Potok",30,Thread.MAX_PRIORITY,list);

        MyThreadR myThread1=new MyThreadR("2 Potok",30,Thread.NORM_PRIORITY,list);
        MyThreadR myThread2=new MyThreadR("3 Potok",30,Thread.MIN_PRIORITY,list);


        //myThread.start();
       // myThread.join();
       // myThread.start();
        while(myThread.innerThread.isAlive()){

        }
        System.out.println(myThread.innerThread.getState()+" 4444444444");



    }
}
class MyThread extends  Thread{
    int counter;
    public MyThread(String name, int counter) {
        super(name);
        this.counter=counter;
    }

    @Override
    public void run() {
        System.out.println(currentThread().getName()+" 2222222222");
        System.out.println(currentThread().getState()+" 333333333");
    }
}

class MyThreadR implements  Runnable {
    int counter;
    Thread innerThread;
    List<Integer> myList;
    public MyThreadR(String name, int counter,int priority,List<Integer> list) {
        this.counter=counter;
        this.innerThread=new Thread(this, name);
        innerThread.setPriority(priority);
        myList=list;
        System.out.println(innerThread.getState()+" 111111111");
                innerThread.start();


    }
    @Override
    public void run() {
        while(counter>0){
            System.out.println(Thread.currentThread().getName()+" "+counter);
            counter--;
            int sum=0;
            for (int temp:myList ) {
                sum+=temp;
            }
            myList.add(77);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}