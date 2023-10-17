import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ToDoApp {
    public static void main(String[] args) {
        JPanel panel = new JPanel(new BorderLayout());
        JButton b = new JButton("Add a Task");
        b.setBounds(250,650,100, 40);

        DefaultListModel<String> listModel = new DefaultListModel<>();

        JList<String> list1 = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(list1);

        list1.setLayoutOrientation(JList.VERTICAL);
        panel.add(scrollPane, BorderLayout.CENTER);

        JFrame f = new JFrame("ToDo List");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 600);
        f.add(b, BorderLayout.SOUTH);
        f.add(panel, BorderLayout.CENTER);
        f.setVisible(true);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newTask = JOptionPane.showInputDialog("Enter a task: ");
                if (newTask != null && !newTask.isEmpty()) {
                    listModel.addElement(newTask);
                }
            }
        });
    }
}