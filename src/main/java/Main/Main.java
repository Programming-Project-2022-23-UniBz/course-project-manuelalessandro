package Main;

//import Objects.GitCommandExecutor;
import WelcomeGUI.WelcomeFrame;

public class Main {
        public static void main(String[] args) {
                // uncomment the next line to synchronize json data through multiple machines
                // -- commented because syncronization is not active
                // String remoteName = "origin";
                // String repositoryPath = System.getProperty("user.dir");
                // String branchName = "main";

                // GitCommandExecutor.pullChanges(repositoryPath, remoteName, branchName);

                WelcomeFrame frame = new WelcomeFrame();
                frame.setVisible(true);
        }

        public static void stopApplication() {

                // uncomment the next line to synchronize json data/ -- commented because
                // syncronization is not active
                // String remoteName = "origin";
                // String repositoryPath = System.getProperty("user.dir");
                // String branchName = "pushpull";
                // GitCommandExecutor.stageChanges(repositoryPath, ".");
                // GitCommandExecutor.commitChanges(repositoryPath, "closure push");
                // GitCommandExecutor.pushChanges(repositoryPath, remoteName, branchName);

                System.exit(0);
        }

}
