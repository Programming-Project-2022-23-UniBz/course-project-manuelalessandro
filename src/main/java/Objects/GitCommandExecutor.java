package Objects;

import java.io.*;
import java.util.logging.*;

public class GitCommandExecutor {

    private static final Logger logger = Logger.getLogger(GitCommandExecutor.class.getName());

    static {
        // Configure the logger to use a FileHandler
        try {
            // Create a FileHandler that appends log messages to a file named "git.log"
            Handler fileHandler = new FileHandler("Logs/git.log", true);

            // Create a SimpleFormatter for formatting log messages
            fileHandler.setFormatter(new SimpleFormatter());

            // Set the logger to use the FileHandler
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Set the log level (INFO will log all messages)
        logger.setLevel(Level.INFO);
    }
    
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

            StringBuilder output = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();
            logCommandOutput(output.toString(), exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void logCommandOutput(String output, int exitCode) {
        String logMessage = "Command output:\n" + output + "\nProcess exited with code: " + exitCode;
        logger.info(logMessage);
    }
}
