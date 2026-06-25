package KooperierendeThreads;

public class Consumer extends Thread {
    private RingBuffer buffer;

    Consumer(RingBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                buffer.getProduct();
                sleep(250); // "Verbrauchszeit"
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
    }
}
