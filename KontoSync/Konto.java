package KontoSync;

public class Konto {
    private volatile int saldo; // to make sure, print always has the right value

    public Konto(int saldo) {
        this.saldo = saldo;
    }

    public synchronized void einzahlen(int betrag) {
        int temp = saldo + betrag;
        // Thread.yield(); //force interrupt thread to simulate possible error source
        saldo = temp;
    }

    // public void einzahlen(int betrag) {
    // int temp = saldo + betrag;
    // Thread.yield(); //force interrupt thread to simulate possible error source
    // saldo = temp;
    // }

    public synchronized void auszahlen(int betrag) { // muss auch Synchronized sein
        saldo = saldo - betrag;
    }

    public void printSaldo() {
        System.out.println(String.valueOf(saldo));
    }
}
