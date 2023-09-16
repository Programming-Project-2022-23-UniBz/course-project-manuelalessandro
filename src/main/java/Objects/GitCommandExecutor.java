package Objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GitCommandExecutor {

    /*
     * public static void main(String[] args) {
     * String remoteName = "origin";
     * 
     * String repositoryPath = System.getProperty("user.dir");
     * pullChanges(repositoryPath, remoteName);
     * pushChanges(repositoryPath, remoteName);
     * }
     */

    public static void pullChanges(String repositoryPath, String remoteName, String branchName) {
        String command = "git pull " + remoteName + " " + branchName;

        executeGitCommand(repositoryPath, command);
    }

    public static void stageChanges(String repositoryPath, String filePath) {
        String command = "git add " + filePath;

        executeGitCommand(repositoryPath, command);
    }

    public static void commitChanges(String repositoryPath, String message) {
        String command = "git commit -m \"" + message + "\"";

        executeGitCommand(repositoryPath, command);
    }

    public static void pushChanges(String repositoryPath, String remoteName, String branchName) {
        String command = "git push " + remoteName + " " + branchName;

        executeGitCommand(repositoryPath, command);
    }

    private static void executeGitCommand(String repositoryPath, String command) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.directory(new File(repositoryPath));
        processBuilder.command("cmd", "/c", command);

        try {
            Process process = processBuilder.start();

            InputStream inputStream = process.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("Process exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    private static boolean executeGitCommandWithStatus(String repositoryPath, String command) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.directory(new File(repositoryPath));
        processBuilder.command("cmd", "/c", command);

        try {
            Process process = processBuilder.start();

            InputStream inputStream = process.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("Process exited with code: " + exitCode);

            return exitCode == 0;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}
