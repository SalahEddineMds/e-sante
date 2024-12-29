
package e.sante;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import java.awt.Color;


public class Table extends JTable {
    
    public Table(){
        
        setShowHorizontalLines(true);
        setShowVerticalLines(false);
        setRowHeight(40);
        JTableHeader header = getTableHeader();
        header.setPreferredSize(new java.awt.Dimension(header.getPreferredSize().width, 50));
        header.setBorder(null);
        setGridColor(Color.LIGHT_GRAY);
}
}
