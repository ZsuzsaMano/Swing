package Parallelism;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.JButton;

public class WesenButton extends JButton {
    private Welt welt;
    private int lPos;
    private int bPos;

    public WesenButton(Welt welt, int lPos, int bPos) {
        this.welt = welt;
        this.lPos = lPos;
        this.bPos = bPos;
        setPreferredSize(new Dimension(20, 20));
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welt.getWesen(lPos, bPos).interrupt();
            }
        });
        aktualisieren();
    }

    public void aktualisieren() {
        Wesen wesen = welt.getWesen(lPos, bPos);
        setBackground(wesen instanceof Lebewesen ? Color.YELLOW : Color.BLUE);
    }
}
