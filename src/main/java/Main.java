import javax.swing.*;


public class Main {
    // Settings
    private static int width = 800;
    private static int height = 500;

    private static boolean resize = false; // Resizable?


    public static void main(String[] args) {

        System.out.print("main start");
        JFrame frame = new JFrame();
        frame.setTitle("Hotel Management");
        frame.setContentPane(new WelcomeFrame().getMainPanel()); // Set the welcome frame
        frame.setSize(width, height);
        frame.setResizable(resize); // prevent from resize
        frame.setVisible(true); // make frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stop application when closed

        // Set logo as icon
        ImageIcon logo = new ImageIcon("src/main/resources/logo.png");
        frame.setIconImage(logo.getImage());



    }
}