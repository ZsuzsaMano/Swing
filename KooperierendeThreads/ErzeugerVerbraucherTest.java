package KooperierendeThreads;

public class ErzeugerVerbraucherTest {
    public static void main(String[] args) {
        RingBuffer buffer = new RingBuffer("Puffer", 4);
        Producer producer1 = new Producer(buffer);
        Producer producer2 = new Producer(buffer);
        Producer producer3 = new Producer(buffer);
        Producer producer4 = new Producer(buffer);
        Consumer consumer1 = new Consumer(buffer);
        Consumer consumer2 = new Consumer(buffer);
        Consumer consumer3 = new Consumer(buffer);
        Consumer consumer4 = new Consumer(buffer);
        producer1.start();
        System.out.println("Erzeuger 1 nimmt Arbeit auf");
        consumer1.start();
        System.out.println("Verbraucher 1 nimmt Arbeit auf");
        producer2.start();
        System.out.println("Erzeuger 2 nimmt Arbeit auf");
        consumer2.start();
        System.out.println("Verbraucher 2 nimmt Arbeit auf");
        producer3.start();
        System.out.println("Erzeuger 3 nimmt Arbeit auf");
        consumer3.start();
        System.out.println("Verbraucher 3 nimmt Arbeit auf");
        producer4.start();
        System.out.println("Erzeuger 4 nimmt Arbeit auf");
        consumer4.start();
        System.out.println("Verbraucher 4 nimmt Arbeit auf");
    }
}
