package Draw;

import java.awt.*;
import javax.swing.JPanel;

public class SimpleView extends JPanel {
    private SimpleModel model;

    public SimpleView(SimpleModel model) {
        this.model = model;
        setPreferredSize(new Dimension(200, 100));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(String.valueOf(model.getValue()), 100, 50);
    }
}
