package Parallelism;

public class Leerwesen extends Wesen {
    public Leerwesen(Welt dieWelt, int lPos, int bPos) {
        super(dieWelt, lPos, bPos);
    }

    @Override
    protected boolean istHandelnNoetig() {
        return dieWelt.anzahlNachbarn(lPos, bPos) == 3;
    }

    @Override
    protected void handeln() {
        Wesen w = new Lebewesen(dieWelt, lPos, bPos);
        dieWelt.setWesen(lPos, bPos, w);
        w.start();
    }
}
