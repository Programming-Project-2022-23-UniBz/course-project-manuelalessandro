/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GitCommandExecutor {

    /*public static void main(String[] args) {
        String remoteName = "origin";

        String repositoryPath = System.getProperty("user.dir");
        pullChanges(repositoryPath, remoteName);
        pushChanges(repositoryPath, remoteName);
    }*/

    public static void pullChanges(String repositoryPath, String remoteName) {
        String command = "git pull " + remoteName;

        executeGitCommand(repositoryPath, command);
    }

    public static void pushChanges(String repositoryPath, String remoteName) {
        String command = "git push " + remoteName;

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
            
            int exitCode = process.waitFor(); // Waits for the pull to be completed

            if (exitCode == 0) {
                System.out.println("Git pull successful");
            } else {
                System.out.println("Git pull failed with exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

