package setawatch.view;

import setawatch.Model;

import javax.swing.*;
import java.awt.*;

public class View {
    private Model model;
    private JFrame frame;

    public View(Model model){
        this.model = model;
        this.frame = new JFrame();

        this.frame.setTitle("Deep Space D-6");
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setLocation(0, 0);
        this.frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
    }

    public JFrame getFrame() {
        return frame;
    }
}
