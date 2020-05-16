package lesson140520.Example_send_receive;

public class Data {
    private String packet;

    // True if receiver should wait
    // False if sender should wait
    private boolean transfer = true;

    public synchronized void send(String packet) {
        while (!transfer) {
            try {
                wait(1000);
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
               // error("Thread interrupted", e);
            }
        }
        transfer = false;

        this.packet = packet;
        notifyAll();
    }

    public synchronized String receive() {
        while (transfer) {
            try {
                wait(1000);
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
               // error("Thread interrupted", e);
            }
        }
        transfer = true;

        notifyAll();
        return packet;
    }
}