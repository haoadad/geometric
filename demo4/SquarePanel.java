package demo4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SquarePanel extends JPanel {
    private JTextField sideField;
    private JButton calculateButton;
    private JTextArea resultArea;

    public SquarePanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 创建输入面板
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel sideLabel = new JLabel("边长：");
        sideField = new JTextField(10);
        inputPanel.add(sideLabel);
        inputPanel.add(sideField);
        add(inputPanel, BorderLayout.NORTH);

        // 创建按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        calculateButton = new JButton("计算周长和面积");
        calculateButton.setPreferredSize(new Dimension(200, 60));
        calculateButton.setBackground(new Color(70, 130, 180));
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2));
        buttonPanel.add(calculateButton);
        add(buttonPanel, BorderLayout.CENTER);

        // 创建结果面板
        resultArea = new JTextArea(15, 15);
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
                    double side = Double.parseDouble(sideField.getText());
                    if(side > 0){
                        double perimeter = 4 * side;
                        double area = side * side;  
                        resultArea.setText("周长：" + perimeter + "\n面积：" + area);
                    }else{
                        JOptionPane.showMessageDialog(SquarePanel.this, "请输入正数");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(SquarePanel.this, "请输入有效的数字");
                }
            }
        });
    }
}
