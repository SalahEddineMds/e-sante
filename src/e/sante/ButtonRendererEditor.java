package e.sante;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;

public class ButtonRendererEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
    private JPanel panel;
    private JButton tableauButton;
    private JButton graphesButton;
    private JTable table;
    private String doctorId;

    public ButtonRendererEditor(JTable table, String doctorId) {
        this.doctorId = doctorId;
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        tableauButton = new JButton("Tableau");
        graphesButton = new JButton("Graphes");
        
        tableauButton.setMargin(new Insets(5, 5, 5, 5)); 
        graphesButton.setMargin(new Insets(5, 5, 5, 5)); 

        tableauButton.setBackground(Color.BLUE);
        tableauButton.setForeground(Color.WHITE);
        graphesButton.setBackground(Color.BLUE);
        graphesButton.setForeground(Color.WHITE);

        tableauButton.setFocusPainted(false);
        graphesButton.setFocusPainted(false);

        tableauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                // Get the patientId from the last column (assuming the patient ID is stored in the last column)
                    String patientId = (String) table.getValueAt(row, 0);  // Adjust the column index if necessary
            
                    // Open the VisualTab and pass the patientId
                    VisualTab visualTabFrame = new VisualTab(patientId,doctorId);
                    visualTabFrame.setVisible(true);
                    visualTabFrame.pack();
                    visualTabFrame.setLocationRelativeTo(null);  // Center the window
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(tableauButton);
                    currentFrame.dispose();
        }
    }
});

        graphesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                // Get the patientId from the last column (assuming the patient ID is stored in the last column)
                    String patientId = (String) table.getValueAt(row, 0);  // Adjust the column index if necessary
            
                    // Open the VisualTab and pass the patientId
                    VisualGraphe visualGrapheFrame = new VisualGraphe(patientId,doctorId);
                    visualGrapheFrame.setVisible(true);
                    visualGrapheFrame.pack();
                    visualGrapheFrame.setLocationRelativeTo(null);  // Center the window
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(tableauButton);
                    currentFrame.dispose();
        }
    }
});

        panel.add(tableauButton);
        panel.add(graphesButton);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        return getButtonComponent(table, row);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        
        return getButtonComponent(table, row);
    }
    
    private Component getButtonComponent(JTable table, int row) {
        String nom = (String) table.getValueAt(row, 0);  
        String prenom = (String) table.getValueAt(row, 1); 

        if (nom == null || nom.isEmpty() || prenom == null || prenom.isEmpty()) {
            tableauButton.setBackground(Color.GRAY);
            graphesButton.setBackground(Color.GRAY);
            tableauButton.setEnabled(false);  // Disable the button
            graphesButton.setEnabled(false);  // Disable the button
        } else {
            tableauButton.setBackground(Color.BLUE);
            graphesButton.setBackground(Color.BLUE);
            tableauButton.setEnabled(true);  // Disable the button
            graphesButton.setEnabled(true);  // Disable the button
        }

        return panel;
    }
    
    @Override
    public Object getCellEditorValue() {
        return null;
    }
    
   }
