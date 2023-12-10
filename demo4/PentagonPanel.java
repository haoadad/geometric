package demo4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PentagonPanel extends JPanel {
    private JTextField sideField;
    private JButton calculateButton;
    private JTextArea outputArea;

    public PentagonPanel() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel sideLabel = new JLabel("边长：");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(sideLabel, gbc);

        sideField = new JTextField(10);
        sideField.setToolTipText("请输入正五边形的边长");
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(sideField, gbc);

        calculateButton = new JButton("计算周长和面积");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(calculateButton, gbc);

        outputArea = new JTextArea(10, 20);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add(scrollPane, gbc);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double side = Double.parseDouble(sideField.getText());
                    if(side > 0){
                        double perimeter = 5 * side;
                        double area = 0.25 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * side * side;
                        outputArea.setText("周长：" + perimeter + "\n面积：" + area);
                    }else{
                        JOptionPane.showMessageDialog(PentagonPanel.this, "请输入正数");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PentagonPanel.this, "请输入有效的数字");
                }
            }
        });
    }
}
