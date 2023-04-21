package Main;

import Objects.RoomControl;
import Objects.UserControl;
import WelcomeGUI.WelcomeFrame;

public class Main {
    public static void main(String[] args) {
        UserControl.pullData();
        RoomControl.pullData();
        WelcomeFrame frame = new WelcomeFrame();
        frame.setVisible(true);
    }

    public static void stopApplication() {
        UserControl.pushData();
        RoomControl.pushData();

        System.exit(0);
    }
}
