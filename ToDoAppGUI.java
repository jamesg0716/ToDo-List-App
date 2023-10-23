import javax.swing.*;
import java.awt.*;

public class ToDoAppGUI {
    private DefaultListModel<String> listModel;
    private JList<String> list1;

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Todo List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);

        listModel = new DefaultListModel<>();
        list1 = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(list1);
        list1.setFixedCellHeight(25);
        list1.setLayoutOrientation(JList.VERTICAL);

        JButton addButton = new JButton("Add a Task");
        JButton removeButton = new JButton("Remove Task");

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); 

        southPanel.add(addButton); 
        southPanel.add(removeButton); 

        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(southPanel, BorderLayout.SOUTH); 
        frame.setVisible(true);

        addButton.addActionListener(e -> addButtonClicked());
        removeButton.addActionListener(e -> removeButtonClicked());
    }

    private void addButtonClicked() {
        String newTask = JOptionPane.showInputDialog("Enter a task: ");
        if (newTask != null && !newTask.isEmpty()) {
            listModel.addElement(newTask);
        }
    }

    private void removeButtonClicked() {
        int index = list1.getSelectedIndex();
        if (index != -1) {
            listModel.remove(index);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ToDoAppGUI app = new ToDoAppGUI();
            app.createAndShowGUI();
        });
    }
}
