import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PathFinderGUI extends JFrame {
    private JComboBox<String> algorithmComboBox;
    private JButton executeButton;
    private JButton compareButton;
    private JTextArea resultArea;

    public PathFinderGUI() {
        setTitle("Path Finder");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] algorithms = {"BFS", "DFS", "A*", "Dijkstra's"};
        algorithmComboBox = new JComboBox<>(algorithms);
        executeButton = new JButton("Execute");
        compareButton = new JButton("Compare");
        resultArea = new JTextArea();
        resultArea.setEditable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(algorithmComboBox, BorderLayout.NORTH);
        panel.add(executeButton, BorderLayout.CENTER);
        panel.add(compareButton, BorderLayout.SOUTH);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        executeButton.addActionListener(new ExecuteButtonListener());
        compareButton.addActionListener(new CompareButtonListener());
    }

    private class ExecuteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedAlgorithm = (String) algorithmComboBox.getSelectedItem();
            resultArea.append("Executing " + selectedAlgorithm + "...\n");
            // Call the selected algorithm's method here
            // For example: if (selectedAlgorithm.equals("BFS")) { executeBFS(); }
            resultArea.append(selectedAlgorithm + " execution finished.\n");
        }
    }

    private class CompareButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedAlgorithm = (String) algorithmComboBox.getSelectedItem();
            resultArea.append("Comparing " + selectedAlgorithm + " with other algorithms...\n");
            // Call the comparison logic here
            // For example: compareAlgorithms(selectedAlgorithm);
            resultArea.append("Comparison finished.\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PathFinderGUI gui = new PathFinderGUI();
            gui.setVisible(true);
        });
    }
}