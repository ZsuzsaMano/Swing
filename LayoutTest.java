import java.awt.BorderLayout;
import javax.swing.*;

public class LayoutTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LayoutTest();
            }
        });
    }

    public LayoutTest() {
        JFrame f = new JFrame("Hauptfenster");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.add(new JButton("Center"), BorderLayout.CENTER);
        f.add(new JButton("North"), BorderLayout.NORTH);
        f.add(new JButton("South"), BorderLayout.SOUTH);
        f.add(new JButton("West"), BorderLayout.WEST);
        f.add(new JButton("East"), BorderLayout.EAST);
        f.setSize(300, 200);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
