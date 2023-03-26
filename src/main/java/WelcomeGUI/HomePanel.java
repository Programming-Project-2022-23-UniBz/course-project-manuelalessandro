package WelcomeGUI;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel{
    private JPanel homePanel;
    private BorderPanel borderPanel;
    private int width, height;
    public HomePanel(int widthIn, int heightIn){
        width = widthIn;
        height = heightIn;

        borderPanel = new BorderPanel(height);
        homePanel.setSize(width-borderPanel.getWidth(), height);


        setLayout(new BorderLayout(0,0));
        add(borderPanel.getBorderPanel());
        add(homePanel);
    }
}
