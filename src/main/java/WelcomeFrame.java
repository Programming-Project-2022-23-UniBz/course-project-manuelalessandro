import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeFrame extends JFrame{
    // Settings
    private static int width = 1100;
    private static int height = 700;
    private static boolean resize = false; // Resizable?
    private JButton testButton;
    private JPanel mainPanel;

    public WelcomeFrame() {

        setTitle("Hotel Management");
        setContentPane(mainPanel); // Set the main panel
        setSize(width, height);
        setResizable(resize); // prevent from resize
        setVisible(true); // make frame visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stop application when closed
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello, world!");
            }
        });
    }



}
