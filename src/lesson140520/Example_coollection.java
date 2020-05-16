package lesson140520;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Example_coollection {

    public static void main(String[] args) {
        List<String> list=new CopyOnWriteArrayList();

        for(int i=0;i<1000;i++){
            list.add("qwqwqw"+i);
        }
//int counter=0;
//        for (String temp:list  ) {
//            System.out.println(temp);
//            if(counter==557) {
//                list.add("ssdsdsd");
//            }
//            counter++;
//        }
//        System.out.println(list.toString());
        Thread thread2=new Thread(()->{
            while(true){
                for (String temp:list ) {
                    System.out.println(temp);
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread3=new Thread(()->{
            while(true){
               list.add("zxzx");
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            }
        });
        Thread thread4=new Thread(()->{
            while(true){
                list.add("zxzx");
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        Thread thread5=new Thread(()->{
            while(true){
                list.add("zxzx");
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
