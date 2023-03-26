package WelcomeGUI;

import javax.swing.*;

public class BorderPanel {
    private JPanel borderPanel;
    private JLabel homeLabel;
    private JLabel bookingLabel;
    private JLabel roomsLabel;
    private JLabel servicesLabel;
    private JLabel titleLabel;
    private int width, height;

    public BorderPanel(int heightIn){
        width = 200;
        height = heightIn;
        borderPanel.setSize(width, height);
    }
    public JPanel getBorderPanel(){
        return borderPanel;
    }

    //Getters
    public int getWidth(){
        return width;
    }
}
