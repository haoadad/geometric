package demo4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrianglePanel extends JPanel {
    private JTextField side1Field;
    private JTextField side2Field;
    private JTextField side3Field;
    private JButton calculateButton;
    private JTextArea resultArea;

    public TrianglePanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 创建输入面板
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        JLabel side1Label = new JLabel("第一条边：");
        side1Field = new JTextField(20);
        JLabel side2Label = new JLabel("第二条边：");
        side2Field = new JTextField(20);
        JLabel side3Label = new JLabel("第三条边：");
        side3Field = new JTextField(20);
        inputPanel.add(side1Label);
        inputPanel.add(side1Field);
        inputPanel.add(side2Label);
        inputPanel.add(side2Field);
        inputPanel.add(side3Label);
        inputPanel.add(side3Field);
        add(inputPanel, BorderLayout.NORTH);

        // 创建按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        calculateButton = new JButton("计算周长和面积");
        calculateButton.setPreferredSize(new Dimension(200, 30));
        calculateButton.setBackground(new Color(70, 130, 180));
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2));
        buttonPanel.add(calculateButton);
        add(buttonPanel, BorderLayout.CENTER);

        // 创建结果面板
        resultArea = new JTextArea(10, 20);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.SOUTH);

        // 添加计算按钮的监听器
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double side1 = Double.parseDouble(side1Field.getText());
                    double side2 = Double.parseDouble(side2Field.getText());
                    double side3 = Double.parseDouble(side3Field.getText());

                    // 判断三边是否构成三角形
                    if (side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1) {
                        double perimeter = side1 + side2 + side3;
                        double s = perimeter / 2;
                        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
                        resultArea.setText("周长：" + perimeter + "\n面积：" + area);
                    } else {
                        JOptionPane.showMessageDialog(TrianglePanel.this, "输入的三边不能构成三角形");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(TrianglePanel.this, "请输入有效的数字");
                }
            }
        });
    }
}
