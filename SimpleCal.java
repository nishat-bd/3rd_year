import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleCal {
    public static void main(String[] args) {
        JFrame frame=new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,200);
        JLabel l1=new JLabel("Enter the First Number: ");
        JLabel l2=new JLabel("Enter the second Number: ");
        JLabel l3=new JLabel("Result: ");
        JTextField t1=new JTextField(10);
        JTextField t2=new JTextField(10);
        JTextField t3=new JTextField(10);
        JButton b1=new JButton("Additon");
        JButton b2=new JButton("Subtraction");
        JButton b3=new JButton("Multiplication");
        JButton b4=new JButton("Division");

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                double a=Double.valueOf(t1.getText());
                double b=Double.valueOf(t2.getText());
                double s=a+b;
                t3.setText(String.valueOf(s));
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                double a=Double.valueOf(t1.getText());
                double b=Double.valueOf(t2.getText());
                double s=a-b;
                t3.setText(String.valueOf(s));
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                double a=Double.valueOf(t1.getText());
                double b=Double.valueOf(t2.getText());
                double s=a*b;
                t3.setText(String.valueOf(s));
            }
        });
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                double a=Double.valueOf(t1.getText());
                double b=Double.valueOf(t2.getText());
                double s=a/b;
                t3.setText(String.valueOf(s));
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(l1);
        frame.add(t1);
        frame.add(l2);
        frame.add(t2); 
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(l3);
        frame.add(t3);
        frame.setVisible(true);
    }
}
