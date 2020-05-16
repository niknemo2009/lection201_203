package lesson140520.Example_send_receive;

public class Proba {
    public static void main(String[] args) {
//        MyThread poto1=new MyThread(false,"Potok 1");
//        MyThread poto2=new MyThread(true,"Potok 2");
//        MyThread poto3=new MyThread(true,"Potok 3");
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));
        //Thread receiver1 = new Thread(new Example_send_receive.Receiver(data));
        Thread receiver2 = new Thread(new Sender(data));

        sender.start();
        receiver.start();
       // receiver1.start();
        receiver2.start();
    }
}
