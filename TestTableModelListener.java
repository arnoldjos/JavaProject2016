import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TestTableModelListener {
    private static final int BOOLEAN_COLUMN = 2;

    public TestTableModelListener() {
        JTable table = createTable();
        table.getModel().addTableModelListener(new CheckBoxModelListener());

        JFrame frame = new JFrame();
        frame.add(new JScrollPane(table));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JTable createTable() {
        String[] cols = {"COL", "COL", "COL"};
        Object[][] data = {{"Hello", "Hello", false}, {"Hello", "Hello", false}};
        DefaultTableModel model = new DefaultTableModel(data, cols) {
            @Override
            public Class getColumnClass(int column) {
                return column == BOOLEAN_COLUMN ? Boolean.class : String.class;
            }
        };
        JTable table = new JTable(model);
        return table;
    }

    public class CheckBoxModelListener implements TableModelListener {

        public void tableChanged(TableModelEvent e) {
            int row = e.getFirstRow();
            int column = e.getColumn();
            if (column == BOOLEAN_COLUMN) {
                TableModel model = (TableModel) e.getSource();
                String columnName = model.getColumnName(column);
                Boolean checked = (Boolean) model.getValueAt(row, column);
                if (checked) {
                    System.out.println(columnName + ": " + true);
                } else {
                    System.out.println(columnName + ": " + false);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestTableModelListener();
            }
        });
    }
}