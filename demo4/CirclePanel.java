package demo4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CirclePanel extends JPanel {
    private JTextField radiusField;
    private JButton calculateButton;
    private JTextArea outputArea;

    public CirclePanel() {
        setLayout(new GridLayout(3, 1, 5, 5));

        // 添加半径输入框和标签
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel radiusLabel = new JLabel("半径:");
        inputPanel.add(radiusLabel);
        radiusField = new JTextField(10);
        radiusField.setToolTipText("输入圆的半径");
        inputPanel.add(radiusField);
        add(inputPanel);

        // 添加计算按钮
        calculateButton = new JButton("计算周长和面积");
        add(calculateButton);

        // 添加输出文本区域
        outputArea = new JTextArea(10, 20);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane);

        // 添加计算按钮的监听器
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double radius = Double.parseDouble(radiusField.getText());
                    if(radius > 0){
                        double perimeter = 2 * Math.PI * radius;
                        double area = Math.PI * radius * radius;
                        outputArea.setText("周长: " + perimeter + "\n面积: " + area);
                    }else{
                         JOptionPane.showMessageDialog(CirclePanel.this, "请输入正数");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(CirclePanel.this, "请输入有效数字");
                }
            }
        });
    }
}
