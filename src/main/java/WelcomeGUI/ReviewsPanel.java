
package WelcomeGUI;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;

/**
 * This class represents a panel for displaying customer reviews.
 */
public class ReviewsPanel extends javax.swing.JPanel {

        private JPanel contentPanel;
        String starIconPath = "src/main/resources/icon/star.png";

        /**
         * Constructs a ReviewsPanel and initializes its components.
         */
        public ReviewsPanel() {
                initComponents();

                // Create the content panel to hold the reviews or content
                contentPanel = new JPanel();
                contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

                // Load reviews from JSON file
                loadReviewsFromJSON();

                // Create the scroll pane and set the content panel as its view
                jScrollPane1 = new JScrollPane(contentPanel);
                jScrollPane1.setPreferredSize(new Dimension(700, 500));

                // Set up the header panel
                JPanel headerPanel = new JPanel(new BorderLayout());
                headerPanel.setBackground(new Color(44, 62, 80)); // Set header background color

                JLabel titleLabel = new JLabel("Customer Reviews");
                titleLabel.setFont(new Font("Perpetua Titling MT", Font.BOLD, 30));
                titleLabel.setForeground(Color.WHITE); // Set title text color
                titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

                JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                titlePanel.setBackground(new Color(44, 62, 80)); // Set header background color
                titlePanel.add(titleLabel);

                // Add the app control buttons to the header panel
                appControlButtons1 = new DesignObjects.AppControlButtons();
                appControlButtons1.setBackground(new Color(44, 62, 80)); // Set header background color

                headerPanel.add(titlePanel, BorderLayout.CENTER);
                headerPanel.add(appControlButtons1, BorderLayout.EAST);

                // Add the header panel to the scroll pane's column header
                jScrollPane1.setColumnHeaderView(headerPanel);

                // Add the scroll pane to the panel
                setLayout(new BorderLayout());
                add(jScrollPane1, BorderLayout.CENTER);
        }

        /**
         * Loads reviews from a JSON file and populates the content panel.
         */
        public void loadReviewsFromJSON() {

                try {
                        // Remove all components from contentPanel
                        contentPanel.removeAll();

                        // Read the JSON file
                        FileReader reader = new FileReader("src/main/resources/json/reviews.json");

                        // Parse the JSON file
                        Gson gson = new Gson();
                        JsonArray reviewsArray = gson.fromJson(reader, JsonArray.class);

                        // Iterate over the reviews
                        for (JsonElement reviewElement : reviewsArray) {
                                JsonObject reviewObj = reviewElement.getAsJsonObject();

                                // Extract review details
                                String reviewText = reviewObj.get("Review").getAsString();
                                int stars = reviewObj.get("Stars").getAsInt();
                                String userName = reviewObj.get("GuestName").getAsString();

                                // Create a panel to hold the review components
                                JPanel reviewPanel = new JPanel();
                                reviewPanel.setLayout(new BorderLayout());
                                reviewPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                                reviewPanel.setBackground(new Color(255, 255, 255)); // Set background color

                                // Create star icons based on the star rating
                                JPanel starsPanel = createStarPanel(stars);

                                // Create a label for the user name
                                JLabel userNameLabel = new JLabel(userName);
                                userNameLabel.setForeground(Color.WHITE); // Set font color
                                userNameLabel.setFont(new Font("Arial", Font.BOLD, 14));

                                // Create a sub-panel to hold user name and star rating
                                JPanel userInfoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                                userInfoPanel.setBackground(new Color(60, 78, 96)); // Set darker background color
                                userInfoPanel.add(userNameLabel);
                                userInfoPanel.add(starsPanel);

                                // Create a text bubble for the review text
                                JTextArea reviewTextArea = new JTextArea(reviewText);
                                reviewTextArea.setEditable(false);
                                reviewTextArea.setLineWrap(true);
                                reviewTextArea.setWrapStyleWord(true);
                                reviewTextArea.setBackground(new Color(235, 235, 235)); // Set bubble color
                                reviewTextArea.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

                                // Add the user info panel above the review text
                                JPanel userReviewPanel = new JPanel(new BorderLayout());
                                userReviewPanel.add(userInfoPanel, BorderLayout.NORTH);
                                userReviewPanel.add(reviewTextArea, BorderLayout.CENTER);

                                // Add the user review panel to the main review panel
                                reviewPanel.add(userReviewPanel, BorderLayout.CENTER);

                                // Add some spacing between reviews
                                reviewPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                                // Add the review panel to the content panel
                                contentPanel.add(reviewPanel);

                        }

                        // Close the reader
                        reader.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        /**
         * Creates a panel displaying star icons based on the given star rating.
         *
         * @param stars The number of stars to display.
         * @return A panel containing star icons.
         */
        private JPanel createStarPanel(int stars) {
                JPanel starsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 0)); // Adjust horizontal gap
                starsPanel.setBackground(new Color(60, 78, 96)); // Set darker background color

                for (int i = 0; i < stars; i++) {
                        JPanel starIcon = createDefaultStarIcon(); // Create a colored rectangle
                        starIcon.setPreferredSize(new Dimension(12, 12)); // Set smaller size
                        starsPanel.add(starIcon);
                }

                return starsPanel;
        }

        /**
         * Creates a default star icon as a colored rectangle.
         *
         * @return A panel representing a star icon.
         */
        private JPanel createDefaultStarIcon() {
                JPanel starIcon = new JPanel();
                starIcon.setPreferredSize(new Dimension(10, 10)); // Set size of the colored rectangle
                starIcon.setBackground(Color.YELLOW); // Use a colored rectangle as a placeholder
                return starIcon;
        }

        /**
         * Sets the panel's background color for a light theme.
         *
         * @param colors An array of colors. Index 1 represents the background color.
         */
        public void setLightTheme(Color[] colors) {
                // Background
                reviewsPanel.setBackground(colors[1]);

                // Foreground
        }

        /**
         * Sets the panel's background color for a dark theme.
         *
         * @param colors An array of colors. Index 4 represents the background color.
         */
        public void setDarkTheme(Color[] colors) {
                // Background
                reviewsPanel.setBackground(colors[4]);

                // Foreground
        }

        /**
         * Sets the app control buttons for the panel.
         *
         * @param frame   The JFrame containing the panel.
         * @param xBorder The horizontal border value.
         */
        public void setAppControlButtons(javax.swing.JFrame frame, int xBorder) {
                appControlButtons1.setAppControl(frame, appControlButtons1.getX() + xBorder, appControlButtons1.getY());
        }

        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                reviewsPanel = new javax.swing.JPanel();
                appControlButtons1 = new DesignObjects.AppControlButtons();
                jScrollPane1 = new javax.swing.JScrollPane();

                setMaximumSize(new java.awt.Dimension(720, 548));
                setMinimumSize(new java.awt.Dimension(720, 548));

                reviewsPanel.setBackground(new java.awt.Color(145, 146, 129));
                reviewsPanel.setMaximumSize(new java.awt.Dimension(720, 548));
                reviewsPanel.setMinimumSize(new java.awt.Dimension(720, 548));

                javax.swing.GroupLayout reviewsPanelLayout = new javax.swing.GroupLayout(reviewsPanel);
                reviewsPanel.setLayout(reviewsPanelLayout);
                reviewsPanelLayout.setHorizontalGroup(
                                reviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reviewsPanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap(647, Short.MAX_VALUE)
                                                                .addComponent(appControlButtons1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap())
                                                .addGroup(reviewsPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(reviewsPanelLayout.createSequentialGroup()
                                                                                .addContainerGap()
                                                                                .addComponent(jScrollPane1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                724,
                                                                                                Short.MAX_VALUE)
                                                                                .addContainerGap())));
                reviewsPanelLayout.setVerticalGroup(
                                reviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(reviewsPanelLayout.createSequentialGroup()
                                                                .addComponent(appControlButtons1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 528, Short.MAX_VALUE))
                                                .addGroup(reviewsPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                reviewsPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addContainerGap(106,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jScrollPane1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                436,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addContainerGap())));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(reviewsPanel, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(reviewsPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)));
        }// </editor-fold>//GEN-END:initComponents

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private DesignObjects.AppControlButtons appControlButtons1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JPanel reviewsPanel;
        // End of variables declaration//GEN-END:variables
}
