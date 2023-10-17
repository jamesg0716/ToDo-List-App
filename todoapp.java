import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ToDoApp {
    public static void main(String[] args) {
        JPanel panel = new JPanel(new BorderLayout());
        JButton addButton = new JButton("Add a Task");
        JButton removeButton = new JButton("Remove Task");

        DefaultListModel<String> listModel = new DefaultListModel<>();

        JList<String> list1 = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(list1);
        list1.setFixedCellHeight(25);
        list1.setLayoutOrientation(JList.VERTICAL);
        panel.add(scrollPane, BorderLayout.CENTER);

        JFrame f = new JFrame("ToDo List");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 600);
        f.add(addButton, BorderLayout.NORTH);
        f.add(removeButton, BorderLayout.SOUTH);
        f.add(panel, BorderLayout.CENTER);
        f.setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newTask = JOptionPane.showInputDialog("Enter a task: ");
                if (newTask != null && !newTask.isEmpty()) {
                    listModel.addElement(newTask);
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list1.getSelectedIndex();
                listModel.removeElementAt(index);
            }
        }); 

    }
}