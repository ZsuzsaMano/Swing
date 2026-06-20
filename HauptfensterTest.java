import javax.swing.*;

public class HauptfensterTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HauptfensterTest();
            }
        });
    }

    public HauptfensterTest() {
        JFrame f = new JFrame("Hauptfenster");
        // f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.addWindowListener(new WindowListen());
        f.setSize(300, 400);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}