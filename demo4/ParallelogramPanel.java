package demo4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParallelogramPanel extends JPanel {
    private JTextField baseField;
    private JTextField heightField;
    private JTextField sideField;
    private JButton calculateButton;
    private JTextArea outputArea;

    public ParallelogramPanel() {
        setLayout(new GridLayout(3, 1, 5, 5));

        // 添加底、高和边输入框和标签
        JPanel inputPanel = new JPanel(new GridLayout(3,5, 5, 3));
        JLabel baseLabel = new JLabel("底:");
        inputPanel.add(baseLabel);
        baseField = new JTextField(10);
        baseField.setToolTipText("请输入平行四边形的底");
        inputPanel.add(baseField);

        JLabel heightLabel = new JLabel("高:");
        inputPanel.add(heightLabel);
        heightField = new JTextField(10);
        heightField.setToolTipText("请输入平行四边形的高");
        inputPanel.add(heightField);

        JLabel sideLabel = new JLabel("边:");
        inputPanel.add(sideLabel);
        sideField = new JTextField(10);
        sideField.setToolTipText("请输入平行四边形的边");
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
                    double base = Double.parseDouble(baseField.getText());
                    double height = Double.parseDouble(heightField.getText());
                    double side = Double.parseDouble(sideField.getText());
                    if(base >0 && height > 0 && side >0){
                        double perimeter = 2 * (side + base);
                        double area = base * height;
                         outputArea.setText("周长: " + perimeter + "\n面积: " + area);
                    }else{
                        JOptionPane.showMessageDialog(ParallelogramPanel.this, "请输入正数");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ParallelogramPanel.this, "请输入有效数字");
                }
            }
        });
    }
}
