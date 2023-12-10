package demo4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RectanglePanel extends JPanel {
    private JTextField lengthField;
    private JTextField widthField;
    private JButton calculateButton;
    private JTextArea resultArea; // 使用JTextArea来显示计算结果

    public RectanglePanel() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 添加长度输入框和标签
        JLabel lengthLabel = new JLabel("长度：");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lengthLabel, gbc);

        lengthField = new JTextField(10);
        lengthField.setToolTipText("请输入矩形的长度");
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(lengthField, gbc);

        // 添加宽度输入框和标签
        JLabel widthLabel = new JLabel("宽度：");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(widthLabel, gbc);

        widthField = new JTextField(10);
        widthField.setToolTipText("请输入矩形的宽度");
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(widthField, gbc);

        // 添加计算按钮
        calculateButton = new JButton("计算周长和面积");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(calculateButton, gbc);

        // 添加文本区域用于显示计算结果
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false); // 设置为只读
        resultArea.setLineWrap(true); // 自动换行
        resultArea.setWrapStyleWord(true); // 根据单词换行
        JScrollPane scrollPane = new JScrollPane(resultArea);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(scrollPane, gbc);

        // 添加计算按钮的监听器
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double length = Double.parseDouble(lengthField.getText());
                    double width = Double.parseDouble(widthField.getText());
                    if(length > 0 && width > 0){    
                        double perimeter = 2 * (length + width);
                        double area = length * width;
                        resultArea.setText("周长：" + perimeter + "\n面积：" + area);
                    }else{
                        JOptionPane.showMessageDialog(RectanglePanel.this, "请输入正数");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(RectanglePanel.this, "请输入有效的数字");
                }
            }
        });
    }
}
