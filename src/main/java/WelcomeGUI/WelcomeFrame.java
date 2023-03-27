package WelcomeGUI;

import javax.swing.*;

public class WelcomeFrame extends JFrame{
    // Settings
    private int width = 1100;
    private int height = 650;
    private boolean resize = false; // Resizable?
    private String logoPath = "src/main/resources/logo.png";

    //instance variables
    private JPanel borderPanel;
    private JLabel homeLabel;
    private JLabel bookingLabel;
    private JLabel roomsLabel;
    private JLabel servicesLabel;
    private JLabel titleLabel;
    private JPanel welcomePanel;
    private JPanel cardPanel;

    public WelcomeFrame(){

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
    }
}
