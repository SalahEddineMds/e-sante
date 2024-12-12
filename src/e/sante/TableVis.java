
package e.sante;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import java.awt.Color;


public class TableVis extends JTable {
    
    public TableVis(){
        
        setShowHorizontalLines(true);
        setShowVerticalLines(false);
        setRowHeight(30);
        JTableHeader header = getTableHeader();
        header.setPreferredSize(new java.awt.Dimension(header.getPreferredSize().width, 40));
        header.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK, 3));
        setGridColor(Color.LIGHT_GRAY);
        
}
    
}
