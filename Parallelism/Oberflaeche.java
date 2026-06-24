package Parallelism;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Oberflaeche extends JFrame {
    Welt dieWelt;
    JPanel weltPanel;

    public Oberflaeche(Welt dieWelt) {
        super("Game of Life");
        this.dieWelt = dieWelt;
        weltPanel = new JPanel();
        weltPanel.setLayout(new GridLayout(dieWelt.MXG, dieWelt.MXG));
        for (int lPos = 0; lPos < dieWelt.MXG; lPos++) {
            for (int b = 0; b < dieWelt.MXG; b++) {
                weltPanel.add(new WesenButton(dieWelt, lPos, b));
            }
        }
        add(weltPanel);
        pack();
        setVisible(true);
    }

    void aktualisieren(int lPos, int bPos) {
        WesenButton wesenButton = (WesenButton) weltPanel.getComponent(lPos * dieWelt.MXG + bPos);
        wesenButton.aktualisieren();
        repaint();
    }
}
