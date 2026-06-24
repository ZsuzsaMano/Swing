package Parallelism;

import java.util.Random;

public abstract class Wesen extends Thread {
    private static Random random = new Random();
    protected Welt dieWelt;
    protected int lPos; // Längengrad
    protected int bPos; // Breitengrad

    public Wesen(Welt dieWelt, int lPos, int bPos) {
        this.dieWelt = dieWelt;
        this.lPos = lPos;
        this.bPos = bPos;
    }

    @Override
    public void run() {
        do {
            try {
                sleep(random.nextInt(5000));
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        } while (!istHandelnNoetig() && !interrupted()); // (+)
        handeln();
    }

    protected abstract boolean istHandelnNoetig();

    protected abstract void handeln();
}
