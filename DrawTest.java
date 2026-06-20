import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class DrawTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DrawTest();
            }
        });
    }

    public DrawTest() {
        JFrame f = new JFrame("DrawTest");
        f.setSize(300, 200);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        CrossCanvas cc = new CrossCanvas();
        cc.setBackground(Color.YELLOW);
        f.add(cc);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}

class CrossCanvas extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        System.out.println("CrossCanvas wird gezeichnet!");
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawLine(0, 0, getWidth(), getHeight());
        g.drawLine(0, getHeight(), getWidth(), 0);
    }
}
