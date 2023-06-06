package AdminGUI;

import Objects.BookingControl;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartPanel;
import java.awt.*;

public class ReportPanel extends javax.swing.JPanel {

    public ReportPanel() {
        initComponents();
        totalActiveBookingCountLabel.setText(""+ BookingControl.getBookingsLength());
        monthlyAverageLabel.setText("" + BookingControl.calculateAverageCost());
    }

    public void setAppControlButtons(javax.swing.JFrame frame, int xBorder) {
        appControlButtons1.setAppControl(frame, appControlButtons1.getX() + xBorder, appControlButtons1.getY());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chartPanel = new javax.swing.JPanel();
        titleTxt = new javax.swing.JLabel();
        appControlButtons1 = new DesignObjects.AppControlButtons();
        chartJPanel = new javax.swing.JPanel();
        activeBookingListLabel = new javax.swing.JLabel();
        totalActiveBookingCountLabel = new javax.swing.JLabel();
        monthlyAvgLabel = new javax.swing.JLabel();
        monthlyAverageLabel = new javax.swing.JLabel();
        showChartBtn1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        totalAmountLabel = new javax.swing.JLabel();
        monthlyAvgLabel1 = new javax.swing.JLabel();

        chartPanel.setBackground(new java.awt.Color(255, 255, 255));
        chartPanel.setPreferredSize(new java.awt.Dimension(738, 546));

        titleTxt.setBackground(new java.awt.Color(255, 255, 255));
        titleTxt.setFont(new java.awt.Font("Yu Gothic UI", 1, 25)); // NOI18N
        titleTxt.setForeground(new java.awt.Color(102, 153, 255));
        titleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleTxt.setText("Report");

        chartJPanel.setBackground(new java.awt.Color(204, 204, 255));
        chartJPanel.setLayout(new java.awt.BorderLayout());

        activeBookingListLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        activeBookingListLabel.setForeground(new java.awt.Color(0, 0, 255));
        activeBookingListLabel.setText("Total active bookings:");

        totalActiveBookingCountLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        totalActiveBookingCountLabel.setForeground(new java.awt.Color(0, 0, 255));
        totalActiveBookingCountLabel.setText("----");

        monthlyAvgLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        monthlyAvgLabel.setForeground(new java.awt.Color(0, 0, 255));
        monthlyAvgLabel.setText("Monthly average earning:");

        monthlyAverageLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        monthlyAverageLabel.setForeground(new java.awt.Color(0, 0, 255));
        monthlyAverageLabel.setText("----");

        showChartBtn1.setBackground(new java.awt.Color(0, 153, 102));
        showChartBtn1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        showChartBtn1.setForeground(new java.awt.Color(255, 255, 255));
        showChartBtn1.setText("SHOW CHART  /  LOAD DATA");
        showChartBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showChartBtn1ActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel3.setText("Only months with avalible data will be shown");

        totalAmountLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        totalAmountLabel.setForeground(new java.awt.Color(0, 0, 255));
        totalAmountLabel.setText("----");

        monthlyAvgLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        monthlyAvgLabel1.setForeground(new java.awt.Color(0, 0, 255));
        monthlyAvgLabel1.setText("Total earning:");

        javax.swing.GroupLayout chartPanelLayout = new javax.swing.GroupLayout(chartPanel);
        chartPanel.setLayout(chartPanelLayout);
        chartPanelLayout.setHorizontalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chartPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chartJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chartPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(211, 211, 211)))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chartPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185)
                .addComponent(appControlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(chartPanelLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(monthlyAvgLabel)
                    .addComponent(activeBookingListLabel)
                    .addComponent(monthlyAvgLabel1))
                .addGap(18, 18, 18)
                .addGroup(chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalAmountLabel)
                    .addComponent(totalActiveBookingCountLabel)
                    .addComponent(monthlyAverageLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(showChartBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        chartPanelLayout.setVerticalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chartPanelLayout.createSequentialGroup()
                .addGroup(chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chartPanelLayout.createSequentialGroup()
                        .addGroup(chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(appControlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(chartPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(activeBookingListLabel)
                            .addComponent(totalActiveBookingCountLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(monthlyAvgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthlyAverageLabel))
                        .addGap(4, 4, 4)
                        .addGroup(chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(monthlyAvgLabel1)
                            .addComponent(totalAmountLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chartPanelLayout.createSequentialGroup()
                        .addComponent(showChartBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addComponent(chartJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void showChartBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showChartBtn1ActionPerformed
        //DefaultCategoryDataset called barChartData used to store the data for the bar chart.
        DefaultCategoryDataset barChartData = new DefaultCategoryDataset();

        int[] months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        String[] monthLabels = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        //For each month, calculate the total amount earned
        for (int i = 0; i < months.length; i++) {
            double totalAmount = BookingControl.calculateTotalAmountForMonth(months[i]);
            if (totalAmount == -1) {
                // No data available for the month, skip adding to the dataset
                continue;
            }
            /*
            Add the total amount to the barChartData dataset.
            The total amount is associated with the "Amount" category.
            The month label is used as the x-axis value.
             */
            barChartData.addValue(totalAmount, "Amount", monthLabels[i]);
        }

        totalAmountLabel.setText(BookingControl.totalEarningFromBookings() + " €");

        //JFreeChart object creates a bar chart with the specified parameters.
        JFreeChart barChart = ChartFactory.createBarChart("Hotel income", "Monthly", "Amount (€)", barChartData, PlotOrientation.VERTICAL, false, true, false);
        //Responsible for rendering the categories (x-axis) and values (y-axis) of the chart.
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.BLACK);

        //This panel will be used to display the chart.
        ChartPanel barPanel = new ChartPanel(barChart);
        chartJPanel.removeAll();
        chartJPanel.add(barPanel, BorderLayout.CENTER);
        chartJPanel.validate();

        CategoryAxis xAxis = barchrt.getDomainAxis();
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90); // Rotate labels 90 degrees for better readability

        totalActiveBookingCountLabel.setText(""+ BookingControl.getBookingsLength());
        monthlyAverageLabel.setText("" + BookingControl.calculateAverageCost());
    }//GEN-LAST:event_showChartBtn1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activeBookingListLabel;
    private DesignObjects.AppControlButtons appControlButtons1;
    private javax.swing.JPanel chartJPanel;
    private javax.swing.JPanel chartPanel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel monthlyAverageLabel;
    private javax.swing.JLabel monthlyAvgLabel;
    private javax.swing.JLabel monthlyAvgLabel1;
    private javax.swing.JButton showChartBtn1;
    private javax.swing.JLabel titleTxt;
    private javax.swing.JLabel totalActiveBookingCountLabel;
    private javax.swing.JLabel totalAmountLabel;
    // End of variables declaration//GEN-END:variables

}
