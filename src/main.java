/*
 * Copyright (c) 2023 Geo-Studios Inc. All rights reserved.
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import logic.circuits.binary.adder;
import logic.circuits.binary.subtractor;

public class main {

    public static void main(String[] args) {
        String[] operations = {
                "Addition",
                "SubtractFromA",
                "SubtractFromB"
        };

        JFrame frame = new JFrame("Super Calc");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel textA = new JLabel("Input A");
        JTextField inputA = new JTextField("00000000000000000000000000000000", 26);
        JLabel textB = new JLabel("Input B");
        JTextField inputB = new JTextField("00000000000000000000000000000000", 26);
        JLabel oplabel = new JLabel("Avalible Operations");
        JComboBox operation = new JComboBox<>(operations);
        JButton button = new JButton("Calculate Sum");
        JLabel sumL = new JLabel("Binary Sum:");
        JTextField sum = new JTextField("00000000000000000000000000000000", 26);

        panel.add(textA);
        panel.add(inputA);
        panel.add(textB);
        panel.add(inputB);
        panel.add(oplabel);
        panel.add(operation);
        panel.add(button);
        panel.add(sumL);
        panel.add(sum);
        frame.add(panel);
        frame.setSize(331, 475);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = inputA.getText();
                String b = inputB.getText();
                String sumr = "0000000000000000";

                if (operation.getSelectedItem() == "Addition"){
                    sumr = adder.add(a, b, 0);
                }
                if (operation.getSelectedItem() == "SubtractFromA"){
                    sumr = subtractor.subtractFromA(a, b, 0);
                }
                if (operation.getSelectedItem() == "SubtractFromB"){
                    sumr = subtractor.subtractFromB(a, b, 0);
                }

                sum.setText(sumr);
            }
        });


    }

}

