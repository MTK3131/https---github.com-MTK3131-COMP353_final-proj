import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;

public class QueryResult {
    JTable jt;

    public QueryResult(String[] attributes, String[][] values) { 
        jt = new JTable(values, attributes);
        jt.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
    }

    public void show() {
        for (int column = 0; column < jt.getColumnCount(); column++)
        {
            TableColumn jtColumn = jt.getColumnModel().getColumn(column);
            int preferredWidth = jtColumn.getMinWidth();
            int maxWidth = jtColumn.getMaxWidth();

            for (int row = 0; row < jt.getRowCount(); row++)
            {
                TableCellRenderer cellRenderer = jt.getCellRenderer(row, column);
                Component c = jt.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + jt.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);

                //  We've exceeded the maximum width, no need to check other rows

                if (preferredWidth >= maxWidth)
                {
                    preferredWidth = maxWidth;
                    break;
                }
            }

            jtColumn.setPreferredWidth( preferredWidth );
        }
        JScrollPane sp=new JScrollPane(jt);  
        JFrame f = new JFrame("Query Results");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.add(sp);
        Insets insets = f.getInsets();
        f.setSize(jt.getPreferredSize().width + insets.left + insets.right + 50, jt.getPreferredSize().height + insets.top + insets.bottom + 100); 
        f.setVisible(true);
    }
}
