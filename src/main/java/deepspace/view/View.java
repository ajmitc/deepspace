package deepspace.view;

import deepspace.Model;

import javax.swing.*;
import java.awt.*;

public class View {
    private Model model;
    private JFrame frame;

    private GamePanel gamePanel;

    public View(Model model){
        this.model = model;
        this.frame = new JFrame();

        this.frame.setTitle("Deep Space D-6");
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setLocation(0, 0);
        this.frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());

        gamePanel = new GamePanel(model, this);

        this.frame.getContentPane().setLayout(new BorderLayout());
        this.frame.getContentPane().add(gamePanel, BorderLayout.CENTER);
    }

    public void refresh(){
        gamePanel.refresh();
    }

    public JFrame getFrame() {
        return frame;
    }
}
