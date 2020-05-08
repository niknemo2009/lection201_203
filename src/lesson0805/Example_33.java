package lesson0805;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Example_33 {

    public static void main(String[] args) {
        Exchanger<Orange>  exchanger=new Exchanger<>();
        Orange or1=new Orange(100,"sort1");
        Orange or2=new Orange(200,"sort2");
        new ThreadOne<Orange>("pOTOK1",exchanger,or1).start();
        new ThreadOne<Orange>("pOTOK2",exchanger,or2).start();
    }
}

class  ThreadOne<T> extends Thread{
    Exchanger<T> ex;
    private T pos;
    List<T> list=new ArrayList<>();

    public ThreadOne(String name, Exchanger<T> ex,T posilka) {
        super(name);
        this.ex = ex;
        pos=posilka;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){

            try {
              T qwe= ex.exchange(pos);
                list.add(pos);
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(currentThread().getName()+list );

    }
}
