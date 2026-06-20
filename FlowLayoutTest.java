import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class FlowLayoutTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FlowLayoutTest();
            }
        });
    }

    public FlowLayoutTest() {
        JFrame f = new JFrame("Hauptfenster");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel northPanel = new JPanel();
        JTextField operand1TextField = new JTextField("0", 5);
        operand1TextField.setEditable(true);
        operand1TextField.setHorizontalAlignment(JTextField.CENTER);
        northPanel.add(operand1TextField);
        northPanel.add(new JLabel(" + "));
        JTextField operand2TextField = new JTextField("0", 5);
        operand2TextField.setEditable(true);
        operand2TextField.setHorizontalAlignment(JTextField.CENTER);
        northPanel.add(operand2TextField);
        f.add(northPanel, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel();
        JButton computeButton = new JButton("Berechnen");
        centerPanel.add(computeButton);
        f.add(centerPanel);
        JPanel southPanel = new JPanel();
        JTextField resultTextField = new JTextField("0", 6);
        resultTextField.setEditable(false);
        southPanel.add(resultTextField);
        resultTextField.setHorizontalAlignment(JTextField.CENTER);
        f.add(southPanel, BorderLayout.SOUTH);
        computeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int operand1 = Integer.parseInt(operand1TextField.getText());
                    int operand2 = Integer.parseInt(operand2TextField.getText());
                    resultTextField.setText(String.valueOf(operand1 + operand2));
                } catch (NumberFormatException nfe) {
                    resultTextField.setText("ERROR");
                }
            }
        });
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}