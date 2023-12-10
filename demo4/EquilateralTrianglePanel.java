package demo4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquilateralTrianglePanel extends JPanel {
    private JTextField sideField;
    private JButton calculateButton;
    private JTextArea outputArea;

    public EquilateralTrianglePanel() {
        setLayout(new GridLayout(3, 1, 5, 5));

        // 添加边长输入框和标签
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel sideLabel = new JLabel("边长:");
        inputPanel.add(sideLabel);
        sideField = new JTextField(20);
        sideField.setToolTipText("输入等边三角形的边长");
        inputPanel.add(sideField);
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
                    double side = Double.parseDouble(sideField.getText());
                    if(side > 0 ){
                        double perimeter = 3 * side;
                        double area = Math.sqrt(3) / 4 * side * side;
                        outputArea.setText("周长: " + perimeter + "\n面积: " + area);
                    }else{
                        JOptionPane.showMessageDialog(EquilateralTrianglePanel.this, "请输入正数");
                    }  
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(EquilateralTrianglePanel.this, "请输入有效数字");
                }
            }
        });
    }
}
