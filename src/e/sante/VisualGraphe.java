
package e.sante;

import org.jfree.chart.ChartFactory;
import java.awt.BasicStroke;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class VisualGraphe extends javax.swing.JFrame {
    private String doctorId;
    private String patientid;
    public VisualGraphe(String patientid, String doctorId) {
        this.doctorId = doctorId;
        this.patientid = patientid;
        initComponents();
        setupGraphs();
    }
    
    private void setupGraphs() {
    // Use BorderLayout for the main panel
    jPanel1.setLayout(new BorderLayout());

    // Create a panel to center the label
    JPanel titlePanel = new JPanel();
    titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center the label horizontally
    titlePanel.add(jLabel7); // Add the label to the title panel

    // Create a panel for the graphs with a 2x2 grid layout
    JPanel graphPanel = new JPanel();
    graphPanel.setLayout(new GridLayout(2, 2, 15, 15)); // 2x2 grid with padding

    // Add each graph to the grid
    graphPanel.add(createChartPanel("Poids(Kg)", "Poids", "poids"));
    graphPanel.add(createChartPanel("Température(°C)", "Température", "temperature"));
    graphPanel.add(createChartPanel("Tension(mmHg)", "Tension", "tension"));
    graphPanel.add(createChartPanel("Glycémie(g/L)", "Taux de Glycémie", "taux_glycemie"));

    // Add the panels to the main panel
    jPanel1.add(titlePanel, BorderLayout.NORTH); // Add the title panel at the top, centered
    jPanel1.add(graphPanel, BorderLayout.CENTER); // Add the graphs below the title
}
    
    private ChartPanel createChartPanel(String label, String title, String parameter) {
    // Create a time series for the parameter
    TimeSeries timeSeries = new TimeSeries(title);

    // Fetch data from the database
    List<DataPoint> dataPoints = PatientDAO.getDataByPatientId(parameter, patientid);

    // Add data points to the time series
    for (DataPoint dataPoint : dataPoints) {
        Date date = new Date(dataPoint.getDate().getTime()); // Convert Timestamp to Date
        timeSeries.add(new Second(date), dataPoint.getValue());
    }

    // Create a dataset with the time series
    TimeSeriesCollection dataset = new TimeSeriesCollection();
    dataset.addSeries(timeSeries);

    // Create a line chart with the dataset
    JFreeChart chart = ChartFactory.createTimeSeriesChart(
        title,               // Chart title
        "Time",              // X-axis label
        label,             // Y-axis label
        dataset,             // Data
        false,               // Legend
        true,                // Tooltips
        false                // URLs
    );

    // Customize the chart
    customizeChart(chart, title);

    // Return a ChartPanel for embedding in the UI
    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new Dimension(350, 200)); // Adjust chart size
    chartPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add margin around the graph
    return new ChartPanel(chart);
}
    
    private void customizeChart(JFreeChart chart, String title) {
        // Set background color to white
        chart.setBackgroundPaint(Color.WHITE);

        // Customize plot area
        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE); // Set plot background color to white
        plot.setDomainGridlinePaint(Color.WHITE); // Set X-axis grid lines to white (invisible)
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY); // Set Y-axis grid lines to gray
        plot.setRangeGridlineStroke(new BasicStroke(1.0f)); // Solid grid lines (1.0f is the thickness of the line)

        // Customize the line appearance
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, new Color(53, 160, 217)); // Light blue line color
        renderer.setSeriesStroke(0, new BasicStroke(2.0f)); // Thicker line
        plot.setRenderer(renderer);

        // Customize X-axis
        DateAxis xAxis = (DateAxis) plot.getDomainAxis();
        xAxis.setTickLabelPaint(Color.GRAY); // Set X-axis labels to gray
        xAxis.setAxisLinePaint(Color.GRAY);  // Set X-axis line to gray
        xAxis.setDateFormatOverride(new SimpleDateFormat("HH:mm:ss")); // Customize date format

        // Customize Y-axis
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setTickLabelPaint(Color.GRAY); // Set Y-axis labels to gray
        yAxis.setAxisLinePaint(Color.GRAY);  // Set Y-axis line to gray

        // Set the title color to light blue
        chart.setTitle(title);
        chart.getTitle().setPaint(new Color(53, 160, 217)); // Light blue title
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setRequestFocusEnabled(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(97, 97, 97));
        jLabel7.setText("Graphique de suivi des paramètres");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(203, 203, 203))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addContainerGap(453, Short.MAX_VALUE))
        );

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(57, 181, 74));
        jButton3.setText("Retour");
        jButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(57, 181, 74)));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(714, 714, 714)
                .addComponent(jButton3)
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (doctorId != null && !doctorId.isEmpty()) {
            // If doctorId is provided, return to HomePageMed
            HomePageMed homePageMedFrame = new HomePageMed(doctorId);
            homePageMedFrame.setVisible(true);
            homePageMedFrame.pack();
            homePageMedFrame.setLocationRelativeTo(null); // Center the window
            this.dispose(); // Close the current window
        } else {
            // If doctorId is not provided, return to the default behavior
            HomePage HomePageFrame = new HomePage(patientid); // Replace HomePage with your actual frame
            HomePageFrame.setVisible(true);
            HomePageFrame.pack();
            HomePageFrame.setLocationRelativeTo(null); // Center the window
            this.dispose(); // Close the current window
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VisualGraphe frame = new VisualGraphe("1","doctor123");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 500);
            frame.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
