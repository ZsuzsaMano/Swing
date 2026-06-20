import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WindowTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WindowTest();
            }
        });
    }

    public WindowTest() {
        JFrame f = new JFrame("MainWindow");
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f. setLayout(new FlowLayout());
        f.add(new JLabel("this is a Label"));
        JButton button = new JButton("Close");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        f.add(button);
        f.setSize(300, 400);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
