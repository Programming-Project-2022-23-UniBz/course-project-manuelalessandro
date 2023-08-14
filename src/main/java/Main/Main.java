package Main;

import Objects.BookingControl;
import Objects.GitCommandExecutor;
import Objects.RoomControl;
import Objects.UserControl;
import WelcomeGUI.WelcomeFrame;

public class Main {
    public static void main(String[] args) {
        String remoteName = "origin";
        String repositoryPath = System.getProperty("user.dir");
        String branchName = "ale2";
        GitCommandExecutor.pullChanges(repositoryPath, remoteName, branchName);
        
        pullAllData();

        WelcomeFrame frame = new WelcomeFrame();
        frame.setVisible(true);
    }

    public static void stopApplication() {
        pushAllData();
        
        String remoteName = "origin";
        String repositoryPath = System.getProperty("user.dir");
        String branchName = "ale2";
        GitCommandExecutor.pushChanges(repositoryPath, remoteName, branchName);
        
        System.exit(0);
    }

    public static void pullAllData() {
        UserControl.pullData();
        RoomControl.pullData();
        BookingControl.pullData();
    }

    public static void pushAllData() {
        UserControl.pushData();
        RoomControl.pushData();
        BookingControl.pushData();
    }
}
    