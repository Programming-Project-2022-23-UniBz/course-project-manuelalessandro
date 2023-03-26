import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeFrame {
    private JButton testButton;
    private JPanel mainPanel;

    public WelcomeFrame() {
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello, world!");
            }
        });
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }


}
