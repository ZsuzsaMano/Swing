import java.awt.event.*;

public class WindowClosing extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
