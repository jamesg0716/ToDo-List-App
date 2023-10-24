import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

public class ToDoAppGUI {
    private DefaultListModel<String> listModel;
    private JList<String> list1;
    private ListModel<String> taskList;

    public void createAndShowGUI() {
        listModel = new DefaultListModel<>();
        loadDataFromFile();

        JFrame frame = new JFrame("Todo List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);

        list1 = new JList<>(listModel);
        taskList = list1.getModel();

        JScrollPane scrollPane = new JScrollPane(list1);
        list1.setFixedCellHeight(25);
        list1.setLayoutOrientation(JList.VERTICAL);

        JButton addButton = new JButton("Add a Task");
        JButton removeButton = new JButton("Remove Task");
        JButton clearButton = new JButton("Clear All");

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); 

        southPanel.add(addButton); 
        southPanel.add(removeButton); 
        southPanel.add(clearButton);

        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(southPanel, BorderLayout.SOUTH); 
        frame.setVisible(true);

        addButton.addActionListener(e -> addButtonClicked());
        removeButton.addActionListener(e -> removeButtonClicked());
        clearButton.addActionListener(e -> clearButtonClicked());
    }

    private void addButtonClicked() {
        String newTask = JOptionPane.showInputDialog("Enter a task: ");
        if (newTask != null && !newTask.isEmpty()) {
            listModel.addElement(newTask);
        }
        saveDataToFile();
    }

    private void removeButtonClicked() {
        int index = list1.getSelectedIndex();
        if (index != -1) {
            listModel.remove(index);
        }
        saveDataToFile();
    }

    private void clearButtonClicked() {
        listModel.clear();
        saveDataToFile();
    }

    private void saveDataToFile() {
        try {
            FileWriter taskWriter = new FileWriter("data.txt");
            taskWriter.write("");
            for (int i = 0; i < taskList.getSize(); i++) {
                String ithTask = taskList.getElementAt(i);
                taskWriter.write(ithTask + "\n");
            }
            taskWriter.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDataFromFile() {
        try {
            FileReader taskReader = new FileReader("data.txt");
            BufferedReader read = new BufferedReader(taskReader);
            String line;

            while((line = read.readLine()) != null) {
                listModel.addElement(line);
            }
            read.close();
            taskReader.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
