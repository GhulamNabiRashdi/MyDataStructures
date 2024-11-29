import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import mypackage.Cell; // Replace 'mypackage' with the actual package name of the Cell class

public class GridPanel extends JPanel {
    private Cell[][] grid;

    public GridPanel(Cell[][] grid) {
        this.grid = grid;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cellSize = 20;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y].isStart()) {
                    g.setColor(Color.GREEN);
                } else if (grid[x][y].isEnd()) {
                    g.setColor(Color.RED);
                } else if (grid[x][y].isPath()) {
                    g.setColor(Color.BLUE);
                } else {
                    g.setColor(Color.WHITE);
                }

                g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                g.drawRect(x * cellSize, y * cellSize, cellSize, cellSize);
            }
        }
    }
}