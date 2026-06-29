package Draw;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        SimpleModel model = new SimpleModel();
        SimpleView view = new SimpleView(model);
        JButton startButton = new JButton("Start");
        int delay = 500;

        ActionListener count = new ActionListener() {
            int i = 0;

            @Override
            public void actionPerformed(ActionEvent e) {

                model.incr();
                view.repaint();
                i++;

                if (i >= 10) {
                    ((Timer) e.getSource()).stop();
                    i = 0;
                }

            }
        };

        Timer timer = new Timer(delay, count);

        startButton.addActionListener(e -> timer.start());

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame mainFrame = new JFrame("Kurzzeitwecker");
                mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                mainFrame.add(view);
                mainFrame.add(startButton, BorderLayout.SOUTH);
                mainFrame.pack();
                mainFrame.setLocationRelativeTo(null);
                mainFrame.setVisible(true);
            }
        });
    }
}
