package lesson140520;

import java.util.concurrent.atomic.*;
import java.util.function.DoubleBinaryOperator;

public class Example_atom {
    static AtomicInteger atomic=new AtomicInteger(23);
    static int noAtomic=0;
    public static void main(String[] args) {

        AtomicLong var33=new AtomicLong(23);
        LongAccumulator longAccumulator=new LongAccumulator((x,y)->x+y,12);
        DoubleAccumulator var45=new DoubleAccumulator(new DoubleBinaryOperator() {
            @Override
            public double applyAsDouble(double left, double right) {
                return left+right;
            }
        },23.12);
        var45.accumulate(10);
        System.out.println(var45.get());
        DoubleAdder dba=new DoubleAdder();
        dba.add(0.2);
        dba.add(0.2);
        dba.add(0.2);
        System.out.println(dba.sum());
Thread thread1=new Thread(()->{
    while(true){
       //System.out.println(Example_atom.noAtomic+"  ************************");
        System.out.println(Example_atom.atomic.get()+Thread.currentThread().getName());
    }

},"Potok1");
        Thread thread2=new Thread(()->{
            while(true){
                Example_atom.noAtomic++;
  //              System.out.println(Example_atom.noAtomic+" #######33333333333");
                      System.out.println(Example_atom.atomic.incrementAndGet()+Thread.currentThread().getName());
            }

        },"Potok2");
thread1.start();
thread2.start();
    }
}
