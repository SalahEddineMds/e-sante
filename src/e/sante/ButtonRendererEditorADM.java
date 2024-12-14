package e.sante;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonRendererEditorADM extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
    private final JPanel panel;
    private final JButton suppButton;
    private final JTable table;
    private final String adminId;

    public ButtonRendererEditorADM(String adminId, JTable table) {
        this.adminId = adminId;
        this.table = table;

        // Initialize panel and button
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        suppButton = new JButton("Supprimer");

        // Button styles
        suppButton.setMargin(new Insets(5, 5, 5, 5));
        suppButton.setBackground(Color.RED);
        suppButton.setForeground(Color.WHITE);
        suppButton.setFocusPainted(false);

        // Add button action listener
        suppButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getEditingRow(); // Get the row being edited
                if (row >= 0) {
                    int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Voulez-vous vraiment supprimer cet utilisateur?",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION
                    );

                    if (confirm == JOptionPane.YES_OPTION) {
                        // Retrieve the user ID from the first column
                        String userId = (String) table.getValueAt(row, 0);

                        // Call the DAO to delete the user
                        boolean success = PatientDAO.deleteUserById(userId);

                        if (success) {
                            // Remove the row from the table
                            ((DefaultTableModel) table.getModel()).removeRow(row);
                            JOptionPane.showMessageDialog(null, "Utilisateur supprimé avec succès.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Erreur lors de la suppression de l'utilisateur.", "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });

        // Add button to panel
        panel.add(suppButton);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return panel;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}
