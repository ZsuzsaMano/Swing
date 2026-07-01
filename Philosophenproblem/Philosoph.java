package Philosophenproblem;

import java.util.Arrays;
import java.util.Random;

public class Philosoph extends Thread {
    private STATE currentState;
    protected Table table;
    int position;

    public enum STATE {
        HUNGRY, EATING, PHILOSOPHING, HASLEFTSTICK, HASRIGHTSTICK;
    }

    private static Random random = new Random();

    final STATE[] stateArray = { STATE.PHILOSOPHING, STATE.HUNGRY, STATE.HASLEFTSTICK, STATE.EATING,
            STATE.HASRIGHTSTICK };

    public Philosoph(Table table, int position) {
        this.currentState = stateArray[0];
        this.table = table;
        this.position = position;

    }

    public STATE getPhState() {
        return this.currentState;
    }

    protected boolean isLeftStickFree() {
        Philosoph leftPhilosoph = table.getPhilosoph((position + table.getSize() - 1) % table.getSize());
        return leftPhilosoph.getPhState() != STATE.EATING && leftPhilosoph.getPhState() != STATE.HASRIGHTSTICK;
    }

    protected boolean isRightStickFree() {
        Philosoph rightPhilosoph = table.getPhilosoph((position + table.getSize() + 1) % table.getSize());
        return rightPhilosoph.getPhState() != STATE.EATING && rightPhilosoph.getPhState() != STATE.HASLEFTSTICK;
    }

    protected void moveOn() {
        while (currentState == STATE.PHILOSOPHING) {
            try {
                sleep(random.nextInt(5000));
                if (table.canIsit()) {
                    currentState = STATE.HUNGRY;
                    System.out.println("Philosoph " + this.position + " is " + currentState);
                } else {
                    System.out.println("Philosoph " + this.position + " has to continue " + currentState);
                    sleep(random.nextInt(5000));
                }

            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        while (currentState == STATE.HUNGRY) {
            synchronized (this) {
                try {
                    while (!isLeftStickFree()) {
                        wait();
                    }
                    currentState = STATE.HASLEFTSTICK;
                    System.out.println("Philosoph " + this.position + " is " + currentState);

                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        while (currentState == STATE.HASLEFTSTICK) {
            synchronized (this) {
                try {
                    while (!isRightStickFree()) {
                        wait();
                    }
                    currentState = STATE.EATING;
                    System.out.println("Philosoph " + this.position + " is " + currentState);

                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        while (currentState == STATE.EATING) {
            synchronized (this) {
                try {
                    sleep(random.nextInt(5000));
                    currentState = STATE.HASRIGHTSTICK;
                    System.out.println("Philosoph " + this.position + " is " + currentState);
                    notifyAll();
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        while (currentState == STATE.HASRIGHTSTICK) {
            synchronized (this) {
                try {
                    sleep(random.nextInt(1000));
                    currentState = STATE.PHILOSOPHING;
                    System.out.println("Philosoph " + this.position + " is " + currentState);
                    notifyAll();
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }

    }

    @Override
    public void run() {
        while (true) {
            moveOn();
        }
    }
}
