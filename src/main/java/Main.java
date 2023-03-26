import javax.swing.*;


public class Main {
    // Settings
    private static String logoPath = "src/main/resources/logo.png";


    public static void main(String[] args) {

        JFrame frame = new WelcomeFrame();

        // Set logo as icon
        ImageIcon logo = new ImageIcon(logoPath); // set path in settings
        frame.setIconImage(logo.getImage());



    }
}