package demo4;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private JTabbedPane tabbedPane;

    public Main() {
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.addTab("正方形", new SquarePanel());
        tabbedPane.addTab("矩形", new RectanglePanel());
        tabbedPane.addTab("三角形", new TrianglePanel());
        tabbedPane.addTab("圆", new CirclePanel());
        tabbedPane.addTab("椭圆", new EllipsePanel());
        tabbedPane.addTab("正五边形", new PentagonPanel());
        tabbedPane.addTab("平行四边形", new ParallelogramPanel());
        tabbedPane.addTab("等边三角形", new EquilateralTrianglePanel());

        add(tabbedPane, BorderLayout.CENTER);

        setTitle("图形周长和面积计算器");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Added the missing semicolon and parenthesis

        setVisible(true); // Added to make the frame visible
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main(); // Create and show the GUI on the Event Dispatch Thread
        });
    }
}

