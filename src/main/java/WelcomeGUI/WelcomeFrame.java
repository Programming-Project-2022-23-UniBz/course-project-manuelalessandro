package WelcomeGUI;

import javax.swing.*;


public class WelcomeFrame extends JFrame{
    // Settings
    private int width = 1100;
    private int height = 700;
    private boolean resize = false; // Resizable?
    private String logoPath = "src/main/resources/logo.png";

    //instance variables
    private HomePanel homePanel;


    public WelcomeFrame() {

        homePanel = new HomePanel(width, height);

        setTitle("Hotel Management");
        setContentPane(homePanel); // Set the main panel
        setSize(width, height);
        setResizable(resize); // prevent from resize
        setVisible(true); // make frame visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stop application when closed

        // Set logo as icon
        ImageIcon logo = new ImageIcon(logoPath); // set path in settings
        setIconImage(logo.getImage());
    }

    //Getters
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

}