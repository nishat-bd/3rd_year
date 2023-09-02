package JavaGUIDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class JavaSecondAssignmet {
    private JFrame frame;
    private JTextField textField;
    private JButton clearButton;
    private JButton undoButton;

    public JavaSecondAssignmet() {
        frame = new JFrame("Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        textField = new JTextField(20);
        clearButton = new JButton("Clear");
        undoButton = new JButton("Undo");

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = textField.getText();
                if (currentText.length() > 0) {
                    textField.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        });

        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                undoButton.setEnabled(true);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (textField.getText().isEmpty()) {
                    undoButton.setEnabled(false);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Plain text components don't fire these events
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(textField);
        panel.add(clearButton);
        panel.add(undoButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JavaSecondAssignmet();
            }
        });
    }
}
