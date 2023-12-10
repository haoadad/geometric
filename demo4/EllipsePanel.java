package demo4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EllipsePanel extends JPanel {
    private JTextField majorAxisField;
    private JTextField minorAxisField;
    private JButton calculateButton;
    private JTextArea outputArea;

    public EllipsePanel() {
        setLayout(new GridLayout(3, 5, 5, 5));

        // 添加长轴和短轴输入框
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel majorAxisLabel = new JLabel("长轴:");
        inputPanel.add(majorAxisLabel);
        majorAxisField = new JTextField(10);
        majorAxisField.setToolTipText("输入椭圆的长轴");
        inputPanel.add(majorAxisField);
        JLabel minorAxisLabel = new JLabel("短轴:");
        inputPanel.add(minorAxisLabel);
        minorAxisField = new JTextField(10);
        minorAxisField.setToolTipText("输入椭圆的短轴");
        inputPanel.add(minorAxisField);
        add(inputPanel);

        // 添加计算按钮
        calculateButton = new JButton("计算周长和面积");
        add(calculateButton);

        // 添加输出文本区域
        outputArea = new JTextArea(10, 10);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane);

        // 添加计算按钮的监听器
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(majorAxisField.getText());
                    double b = Double.parseDouble(minorAxisField.getText());
                    if(a > 0 && b > 0){
                        double perimeter = Math.PI * (3 * (a + b) - Math.sqrt((3 * a + b) * (a + 3 * b)));
                        double area = Math.PI * a * b;
                        outputArea.setText("周长: " + perimeter + "\n面积: " + area);
                    }else{
                        JOptionPane.showMessageDialog(EllipsePanel.this, "请输入正数");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(EllipsePanel.this, "请输入有效数字");
                }
            }
        });
    }
}
