package Philosophenproblem;

import Philosophenproblem.Philosoph.STATE;

public class Table {
    Philosoph[] table;
    int size = 5;

    public Table() {
        table = new Philosoph[size];
        for (int i = 0; i < size; i++) {
            table[i] = new Philosoph(this, i);
            table[i].start();
        }
    }

    public int getSize() {
        return size;
    }

    public Philosoph getPhilosoph(int position) {
        return table[position];
    }

    public boolean canIsit() {
        int nrOfPhilo = 0;
        for (int i = 0; i < size; i++) {
            if (table[i].getPhState() == STATE.PHILOSOPHING) {
                nrOfPhilo++;
            }
        }
        return nrOfPhilo > 1;
    }
}
