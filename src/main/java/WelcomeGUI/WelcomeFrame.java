package WelcomeGUI;

import javax.swing.*;


public class WelcomeFrame extends JFrame{
    // Settings
    private static int width = 1100;
    private static int height = 700;
    private static boolean resize = false; // Resizable?
    private static String logoPath = "src/main/resources/logo.png";

    //instance variables
    BorderPanel borderPanel;

    public WelcomeFrame() {

        borderPanel = new BorderPanel();

        setTitle("Hotel Management");
        setContentPane(borderPanel.getBorderPanel()); // Set the main panel
        setSize(width, height);
        setResizable(resize); // prevent from resize
        setVisible(true); // make frame visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stop application when closed

        // Set logo as icon
        ImageIcon logo = new ImageIcon(logoPath); // set path in settings
        setIconImage(logo.getImage());
    }



}