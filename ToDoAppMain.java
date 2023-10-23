import javax.swing.SwingUtilities;

public class ToDoAppMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ToDoAppGUI frame = new ToDoAppGUI();
            frame.createAndShowGUI();
        });
    }
}
