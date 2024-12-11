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

    public ButtonRendererEditor() {
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
                JOptionPane.showMessageDialog(null, "Tableau button clicked!");
            }
        });

        graphesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Graphes button clicked!");
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
