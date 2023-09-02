package JavaGUIDemo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ModifiedCalculator extends JFrame {
    private JTextField display;
    private double num1 = 0, num2 = 0;
    private String operator = "";
    
    public ModifiedCalculator() {
        setTitle("Calculator");
        setSize(300, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setEditable(false);
        
        JPanel buttonsPanel = new JPanel(new GridLayout(5, 4));
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };
        
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    if (Character.isDigit(command.charAt(0)) || command.equals(".")) {
                        display.setText(display.getText() + command);
                    } else if (command.equals("=")) {
                        num2 = Double.parseDouble(display.getText());
                        calculate();
                        operator = "";
                    } else {
                        if (!operator.isEmpty()) {
                            calculate();
                        }
                        num1 = Double.parseDouble(display.getText());
                        operator = command;
                        display.setText("");
                    }
                }
            });
            buttonsPanel.add(button);
        }
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(display, BorderLayout.NORTH);
        mainPanel.add(buttonsPanel, BorderLayout.CENTER);
        
        add(mainPanel);
    }
    
    private void calculate() {
        switch (operator) {
            case "+":
                num1 += num2;
                break;
            case "-":
                num1 -= num2;
                break;
            case "*":
                num1 *= num2;
                break;
            case "/":
                if (num2 != 0) {
                    num1 /= num2;
                } else {
                    display.setText("Error");
                }
                break;
        }
        display.setText(String.valueOf(num1));
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ModifiedCalculator calculator = new ModifiedCalculator();
            calculator.setVisible(true);
        });
    }
}
