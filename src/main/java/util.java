import javax.swing.table.DefaultTableModel;

public interface util{


    default void removeTableContent(DefaultTableModel tableModel) {
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
    }

    void displayData();


}