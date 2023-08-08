package Main;

import WelcomeGUI.WelcomeFrame;

public class Main {
    public static void main(String[] args) {
        WelcomeFrame frame = new WelcomeFrame();
        frame.setVisible(true);
    }

    public static void stopApplication() {
        System.out.println("\n\n STOPPING \n\n");
        System.exit(0);
    }

}
