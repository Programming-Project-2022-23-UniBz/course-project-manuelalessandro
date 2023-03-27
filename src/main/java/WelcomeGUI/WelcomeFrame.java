package WelcomeGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class WelcomeFrame extends JFrame {
    // Settings
    private int width = 1100;
    private int height = 650;
    private boolean resize = false; // Resizable?
    private String logoPath = "src/main/resources/logo.png";

    //instance variables
    private JPanel borderPanel;
    private JButton homeButton;
    private JButton bookingButton;
    private JButton reviewsButton;
    private JButton servicesButton;
    private JLabel titleLabel;
    private JPanel welcomePanel;
    private JPanel cardPanel;
    private JPanel homePanel;
    private JPanel bookingPanel;
    private JPanel imageSlider;
    private CardLayout cardLayout;

    public WelcomeFrame(){

        //CardLayout
        cardLayout = (CardLayout) (cardPanel.getLayout());

        //Frame
        setTitle("Hotel Management");
        setContentPane(welcomePanel); // Set the main panel
        setSize(width, height);
        setResizable(resize); // prevent from resize
        //setUndecorated(true); //disable app borders
        setVisible(true); // make frame visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stop application when closed

        // Set logo as icon
        ImageIcon logo = new ImageIcon(logoPath); // set path in settings
        setIconImage(logo.getImage());

        //Set action to Buttons
        homeButton.addActionListener(this::buttonCardPanel);
        bookingButton.addActionListener(this::buttonCardPanel);
    }

    public void buttonCardPanel(ActionEvent e) {
        if(e.getSource() == homeButton)
            cardLayout.show(cardPanel, "homePanel");
        else if(e.getSource() == bookingButton)
            cardLayout.show(cardPanel, "bookingPanel");
    }
}
