package KooperierendeThreads;

public class ErzeugerVerbraucherTest {
    public static void main(String[] args) {
        RingBuffer buffer = new RingBuffer("Puffer", 4);
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        producer.start();
        System.out.println("Erzeuger nimmt Arbeit auf");
        consumer.start();
        System.out.println("Verbraucher nimmt Arbeit auf");
    }
}
