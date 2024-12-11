package e.sante;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;


public class ButtonRendererEditorADM extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
    private JPanel panel;
    private JButton modifButton;
    private JButton suppButton;

    public ButtonRendererEditorADM() {
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        modifButton = new JButton("Modifier");
        suppButton = new JButton("X");
        
        modifButton.setMargin(new Insets(5, 5, 5, 5)); 
        suppButton.setMargin(new Insets(5, 5, 5, 5)); 

        modifButton.setBackground(Color.GREEN);
        modifButton.setForeground(Color.WHITE);
        suppButton.setBackground(Color.RED);
        suppButton.setForeground(Color.WHITE);

        modifButton.setFocusPainted(false);
        suppButton.setFocusPainted(false);

        modifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Modifier button clicked!");
            }
        });

        suppButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Supprimer button clicked!");
            }
        });

        panel.add(modifButton);
        panel.add(suppButton);
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
            modifButton.setBackground(Color.GRAY);
            suppButton.setBackground(Color.GRAY);
            modifButton.setEnabled(false);  // Disable the button
            suppButton.setEnabled(false);  // Disable the button
        } else {
            modifButton.setBackground(Color.GREEN);
            suppButton.setBackground(Color.RED);
            modifButton.setEnabled(true);  // Disable the button
            suppButton.setEnabled(true);  // Disable the button
        }

        return panel;
    }
    
    @Override
    public Object getCellEditorValue() {
        return null;
    }
    
   }
