package JavaGUIDemo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator  {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Calculator");
        JTextField textField = new JTextField(20);
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        JTextField inputField = new JTextField();

        ActionListener buttonListener = new ActionListener() {
            private StringBuilder input = new StringBuilder();
            private double num1 = 0;
            private String operator = "";

            public void actionPerformed(ActionEvent e) {
                String command = ((JButton) e.getSource()).getText();

                if (command.matches("[0-9.]")) {
                    input.append(command);
                } else if (command.matches("[-+*/]")) {
                    num1 = Double.parseDouble(input.toString());
                    operator = command;
                    input.setLength(0);
                } else if (command.equals("=")) {
                    double num2 = Double.parseDouble(input.toString());
                    double result = 0;
                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            if (num2 != 0) {
                                result = num1 / num2;
                            } else {
                                inputField.setText("Error");
                                return;
                            }
                            break;
                    }
                    inputField.setText(String.valueOf(result));
                    input.setLength(0);
                } else if (command.equals("C")) {
                    input.setLength(0);
                    inputField.setText("");
                }
                textField.setText(input.toString());
            }
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(buttonListener);
            buttonPanel.add(button);
        }

        frame.add(textField, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(inputField, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
