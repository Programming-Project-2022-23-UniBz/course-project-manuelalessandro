
package WelcomeGUI;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.awt.Color;

public class ReviewsPanel extends javax.swing.JPanel {

    private JScrollPane ScrollPane1;
    private JPanel contentPanel;
    
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

                // Set an empty border with 200 pixels gap at the top
                int topGap = 50;
                JPanel topPanel = new JPanel();
                topPanel.setPreferredSize(new Dimension(1, topGap));
                JLabel Title = new JLabel("Costumer Reviews");
                Title.setFont(new java.awt.Font("Perpetua Titling MT", 2, 25));
                topPanel.add(Title);
                JLabel blank = new JLabel("                                                                         ");
                topPanel.add(blank);
                appControlButtons1 = new DesignObjects.AppControlButtons();
                topPanel.add(appControlButtons1);
                jScrollPane1.setColumnHeaderView(topPanel);

                // Add the scroll pane to the panel
                this.setLayout(new BorderLayout());
                this.add(jScrollPane1, BorderLayout.CENTER);
        }
        
        private void loadReviewsFromJSON() {
            try {
                // Read the JSON file
                FileReader reader = new FileReader("src/main/java/Objects/json/reviews.json");

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

                    // Create components for the review
                    JLabel starsLabel = new JLabel(stars + " stars");
                    JLabel userNameLabel = new JLabel("" + userName);
                    JTextArea reviewTextArea = new JTextArea(reviewText);
                    reviewTextArea.setEditable(false);
                    reviewTextArea.setLineWrap(true);
                    reviewTextArea.setWrapStyleWord(true);

                    // Add the components to the review panel
                    reviewPanel.add(starsLabel, BorderLayout.NORTH);
                    reviewPanel.add(userNameLabel, BorderLayout.WEST);
                    reviewPanel.add(reviewTextArea, BorderLayout.CENTER);

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

        public void setLightTheme(Color[] colors) {
                // Background
                reviewsPanel.setBackground(colors[1]);

                // Foreground
        }

        public void setDarkTheme(Color[] colors) {
                // Background
                reviewsPanel.setBackground(colors[4]);

                // Foreground
        }

        public void setAppControlButtons(javax.swing.JFrame frame, int xBorder) {
                appControlButtons1.setAppControl(frame, appControlButtons1.getX() + xBorder, appControlButtons1.getY());
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reviewsPanelLayout.createSequentialGroup()
                .addContainerGap(647, Short.MAX_VALUE)
                .addComponent(appControlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(reviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(reviewsPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        reviewsPanelLayout.setVerticalGroup(
            reviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewsPanelLayout.createSequentialGroup()
                .addComponent(appControlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 528, Short.MAX_VALUE))
            .addGroup(reviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reviewsPanelLayout.createSequentialGroup()
                    .addContainerGap(106, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(reviewsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(reviewsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DesignObjects.AppControlButtons appControlButtons1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel reviewsPanel;
    // End of variables declaration//GEN-END:variables
}
