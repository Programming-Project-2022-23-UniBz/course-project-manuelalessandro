package WelcomeGUI;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel{
    private JPanel homePanel;
    private JTextField hotelPresentationTextField;
    private BorderPanel borderPanel;
    private int width, height;
    public HomePanel(int widthIn, int heightIn){
        width = widthIn;
        height = heightIn;

        //Components
        borderPanel = new BorderPanel(height);
        //homePanel.setSize(width-borderPanel.getWidth(), height);

        //Add borderPanel component
        setLayout(new GridBagLayout());
        GridBagConstraints borderConstraints = new GridBagConstraints();
        borderConstraints.gridx = 0;
        borderConstraints.gridy = 0;
        borderConstraints.fill = GridBagConstraints.BOTH;
        add(borderPanel.getBorderPanel(), borderConstraints);

        //Add homePanel component
        GridBagConstraints homeConstraints = new GridBagConstraints();
        homeConstraints.gridx = 1;
        homeConstraints.gridy = 0;
        homeConstraints.fill = GridBagConstraints.BOTH;
        add(homePanel, homeConstraints);
    }
}
