package Main;

import Objects.GitCommandExecutor;
import WelcomeGUI.WelcomeFrame;

public class Main {
        public static void main(String[] args) {
                String remoteName = "origin";
                String repositoryPath = System.getProperty("user.dir");
                String branchName = "pushpull";
                // uncomment the next line to synchronize json data through multiple machines
                // GitCommandExecutor.pullChanges(repositoryPath, remoteName, branchName);

                WelcomeFrame frame = new WelcomeFrame();
                frame.setVisible(true);
        }

        public static void stopApplication() {

                String remoteName = "origin";
                String repositoryPath = System.getProperty("user.dir");
                String branchName = "pushpull";
                // uncomment the next line to synchronize json data
                // GitCommandExecutor.stageChanges(repositoryPath, ".");
                // GitCommandExecutor.commitChanges(repositoryPath, "closure push");
                // GitCommandExecutor.pushChanges(repositoryPath, remoteName, branchName);

                System.exit(0);
        }

}
