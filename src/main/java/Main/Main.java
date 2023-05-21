package Main;

import Objects.BookingControl;
import Objects.RoomControl;
import Objects.UserControl;
import WelcomeGUI.WelcomeFrame;

public class Main {
    public static void main(String[] args) {
        pullAllData();

        WelcomeFrame frame = new WelcomeFrame();
        frame.setVisible(true);
    }

    public static void stopApplication() {
        pushAllData();

        System.exit(0);
    }

    public static void pullAllData() {
        System.out.println("Initial pull");
        UserControl.pullData();
        System.out.println("user pull success");
        RoomControl.pullData();
        System.out.println("room pull success");
        BookingControl.pullData();
    }

    public static void pushAllData() {
        UserControl.pushData();
        RoomControl.pushData();
        BookingControl.pushData();
    }
}
