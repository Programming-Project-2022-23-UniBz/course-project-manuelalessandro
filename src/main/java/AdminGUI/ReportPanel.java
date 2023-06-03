package AdminGUI;

import Objects.BookingControl;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartPanel;

import java.awt.*;

public class ReportPanel extends javax.swing.JPanel {

    public ReportPanel() {
        initComponents();
        totalActiveBookingCountLabel.setText(""+ BookingControl.getBookingCount());
        monthlyAverageLabel.setText("" + BookingControl.calculateAverageCost());
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
        showChartBtn1.setText("SHOW DATA");
        showChartBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showChartBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chartPanelLayout = new javax.swing.GroupLayout(chartPanel);
        chartPanel.setLayout(chartPanelLayout);
        chartPanelLayout.setHorizontalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chartPanelLayout.createSequentialGroup()
                .addContainerGap(251, Short.MAX_VALUE)
                .addComponent(titleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185)
                .addComponent(appControlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(chartPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(chartJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(chartPanelLayout.createSequentialGroup()
                .addGroup(chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chartPanelLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(activeBookingListLabel))
                    .addGroup(chartPanelLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(totalActiveBookingCountLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(showChartBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addGroup(chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(monthlyAvgLabel)
                    .addGroup(chartPanelLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(monthlyAverageLabel)))
                .addGap(73, 73, 73))
        );
        chartPanelLayout.setVerticalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chartPanelLayout.createSequentialGroup()
                .addGroup(chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appControlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(chartPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chartPanelLayout.createSequentialGroup()
                        .addComponent(activeBookingListLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalActiveBookingCountLabel))
                    .addGroup(chartPanelLayout.createSequentialGroup()
                        .addComponent(monthlyAvgLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(monthlyAverageLabel))
                    .addComponent(showChartBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(chartJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
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
        DefaultCategoryDataset barChartData = new DefaultCategoryDataset();

    int[] months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    String[] monthLabels = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    for (int i = 0; i < months.length; i++) {
        double totalAmount = BookingControl.calculateTotalAmountForMonth(months[i]);
        if (totalAmount == -1) {
            // No data available for the month, skip adding to the dataset
            continue;
        }
        barChartData.addValue(totalAmount, "Amount", monthLabels[i]);
    }

    JFreeChart barChart = ChartFactory.createBarChart("Hotel income", "Monthly", "Amount (€)", barChartData, PlotOrientation.VERTICAL, false, true, false);
    CategoryPlot barchrt = barChart.getCategoryPlot();
    barchrt.setRangeGridlinePaint(Color.ORANGE);

    ChartPanel barPanel = new ChartPanel(barChart);
    chartJPanel.removeAll();
    chartJPanel.add(barPanel, BorderLayout.CENTER);
    chartJPanel.validate();

    CategoryAxis xAxis = barchrt.getDomainAxis();
    xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90); // Rotate labels 90 degrees
    
    totalActiveBookingCountLabel.setText(""+ BookingControl.getBookingCount());
    monthlyAverageLabel.setText("" + BookingControl.calculateAverageCost());
    }//GEN-LAST:event_showChartBtn1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activeBookingListLabel;
    private DesignObjects.AppControlButtons appControlButtons1;
    private javax.swing.JPanel chartJPanel;
    private javax.swing.JPanel chartPanel;
    private javax.swing.JLabel monthlyAverageLabel;
    private javax.swing.JLabel monthlyAvgLabel;
    private javax.swing.JButton showChartBtn1;
    private javax.swing.JLabel titleTxt;
    private javax.swing.JLabel totalActiveBookingCountLabel;
    // End of variables declaration//GEN-END:variables

}
