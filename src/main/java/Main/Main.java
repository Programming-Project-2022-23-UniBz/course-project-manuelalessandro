package Main;

import Objects.UserControl;
import WelcomeGUI.WelcomeFrame;

public class Main {
    public static void main(String[] args) {
        UserControl.pullData();
        WelcomeFrame frame = new WelcomeFrame();
    }

    public static void stopApplication() {
        UserControl.pushData();

        System.exit(0);
    }
}
