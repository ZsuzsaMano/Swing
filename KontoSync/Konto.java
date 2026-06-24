package KontoSync;

public class Konto {
    private int saldo;

    public Konto(int saldo) {
        this.saldo = saldo;
    }

    public void einzahlen(int betrag) {
        int temp = saldo + betrag;
        // Thread.yield(); //force interrupt thread to simulate possible error source
        saldo = temp;
    }

    public void printSaldo() {
        System.out.println(String.valueOf(saldo));
    }
}
