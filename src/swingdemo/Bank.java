package swingdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;

public class Bank extends JFrame implements ActionListener{
    JButton button1,button2,button3;
    JLabel l1,cardNo,Pin;
    JPasswordField pinField;
    JTextField cardTextField;
    Bank(){
        setLayout(null);
        setTitle("login");
        getContentPane().setBackground(Color.YELLOW);
        setSize(800,500);

        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
        Image i2=i.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(50,30,80,80);
         add(label);

         l1=new JLabel("WELCOME TO ATM");
         l1.setFont(new Font("osword",Font.BOLD,38));
         l1.setBounds(200,-180,500,500);
         add(l1);

        cardNo=new JLabel("CARD NO:");
        cardNo.setFont(new Font("osword",Font.BOLD,38));
        cardNo.setBounds(100,-80,200,500);
        add(cardNo);

        cardTextField=new JTextField();
        cardTextField.setBounds(320,160,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        Pin=new JLabel("PIN:");
        Pin.setFont(new Font("osword",Font.BOLD,38));
        Pin.setBounds(215,-20,200,500);
        add(Pin);

        pinField=new JPasswordField();
        pinField.setBounds(320,220,250,30);
        pinField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinField);

        button1=new JButton("sign in");
        button1.setBounds(280,330,80,30);
        button1.addActionListener(this);
        add(button1);

        button2=new JButton("clear");
        button2.setBounds(480,330,80,30);
        button2.addActionListener(this);
        add(button2);

        button3=new JButton("sign up");
        button3.setBounds(380,380,80,30);
        button3.addActionListener(this);
        add(button3);
        setVisible(true);
        setDefaultCloseOperation(3);
    }
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==button2) {
                cardTextField.setText("");
                pinField.setText("");
            }
            else if(e.getSource()==button1){
                String cardNo=cardTextField.getText();
                String pin=pinField.getText();
                String query="select * from login where cardno1='"+cardNo+"'and pin1='"+pin+"'";
                connection con=new connection();
                try{
                    ResultSet rs=con.s.executeQuery(query);
                    if(rs.next()){
                        setVisible(false);
                        new transaction(pin).setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"incorrect details");
                    }
                }catch (Exception ae){
                    System.out.println(ae);
                }
        }else if(e.getSource()==button3){
                setVisible(false);
                new signUp().setVisible(true);
            }
    }
    public static void main(String[] args) {
       Bank bank=new Bank();
    }
}
