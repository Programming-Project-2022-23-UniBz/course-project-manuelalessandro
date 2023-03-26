package WelcomeGUI;

import javax.swing.*;

public class BookingPanel {
    private JPanel bookingPanel;
    private int width, height;
    private BorderPanel borderPanel;
    public BookingPanel(int widthIn, int heightIn){
        width = widthIn;
        height = heightIn;

        borderPanel = new BorderPanel(height);

    }

}
