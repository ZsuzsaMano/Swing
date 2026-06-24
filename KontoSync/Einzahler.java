package KontoSync;

class Einzahler extends Thread {
    private Konto konto;
    private int betrag;

    public Einzahler(Konto konto, int betrag) {
        this.konto = konto;
        this.betrag = betrag;
    }

    @Override
    public void run() {
        konto.einzahlen(betrag);
    }
}
