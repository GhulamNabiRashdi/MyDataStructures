import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Path1finderGUI extends JFrame {
    private Pathfinder pathfinder;
    private GridPanel gridPanel;

    public Path1finderGUI() {
        pathfinder = new Pathfinder(20, 20);
        gridPanel = new GridPanel(pathfinder.getGrid());

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new StartButtonListener());

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ResetButtonListener());

        JPanel controlPanel = new JPanel();
        controlPanel.add(startButton);
        controlPanel.add(resetButton);

        add(gridPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            pathfinder.findPath(0, 0, 19, 19);
            gridPanel.updateGrid();
        }
    }

    private class ResetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            pathfinder.reset();
            gridPanel.updateGrid();
        }
    }

    public static void main(String[] args) {
        new Path1finderGUI();
    }
}