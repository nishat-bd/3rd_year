import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimCalUsingImpActLis extends JFrame implements ActionListener{
 
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;

    public SimCalUsingImpActLis(){

        super("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,200);

        l1=new JLabel("Enter the First Number: ");
        l2=new JLabel("Enter the second Number: ");
        l3=new JLabel("Result: ");
        t1=new JTextField(10);
        t2=new JTextField(10);
        t3=new JTextField(10);
        b1=new JButton("Additon");
        b2=new JButton("Subtraction");
        b3=new JButton("Multiplication");
        b4=new JButton("Division");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        setLayout(new FlowLayout());
        add(l1);
        add(t1);
        add(l2);
        add(t2); 
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(l3);
        add(t3);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        double a=Double.valueOf(t1.getText());
        double b=Double.valueOf(t2.getText());
        if(e.getSource()==b1){      
            double s=a+b;
            t3.setText(String.valueOf(s));
        }
        if(e.getSource()==b2){      
            double s=a-b;
            t3.setText(String.valueOf(s));
        }
        if(e.getSource()==b3){      
            double s=a*b;
            t3.setText(String.valueOf(s));
        }
        if(e.getSource()==b4){      
            double s=a/b;
            t3.setText(String.valueOf(s));
        }
    }
    public static void main(String[] args) {
        new SimCalUsingImpActLis();
    }
}