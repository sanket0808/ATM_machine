package swingdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transaction extends JFrame implements ActionListener {
    JButton deposit,withdraw,Benquiry,exit,miniStatement,fastCash,pinChange;
    String pin;
    transaction(String pin){
        this.pin=pin;
        setLayout(null);
        setSize(800,800);
        setTitle("Transaction");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/5.jpg"));
        Image i2= i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l=new JLabel(i3);
        l.setBounds(0,0,800,800);
        add(l);

        JLabel text=new JLabel("Please select your transaction");
        text.setBounds(300,200,500,25);
        text.setForeground(Color.WHITE);
        l.add(text);

        deposit=new JButton("DEPOSIT");
        deposit.setBounds(210,250,150,20);
        deposit.setForeground(Color.WHITE);
        deposit.setBackground(Color.BLACK);
        deposit.addActionListener(this);
        l.add(deposit);

        withdraw=new JButton("CASH WITHDRAWL");
        withdraw.setBounds(210,280,150,20);
        withdraw.setForeground(Color.WHITE);
        withdraw.setBackground(Color.BLACK);
        withdraw.addActionListener(this);
        l.add(withdraw);

        fastCash=new JButton("FAST CASH");
        fastCash.setBounds(210,310,150,20);
        fastCash.setForeground(Color.WHITE);
        fastCash.setBackground(Color.BLACK);
        fastCash.addActionListener(this);
        l.add(fastCash);

        Benquiry=new JButton("BALANCE ENQUIRY");
        Benquiry.setBounds(210,340,150,20);
        Benquiry.setForeground(Color.WHITE);
        Benquiry.setBackground(Color.BLACK);
        Benquiry.addActionListener(this);
        l.add(Benquiry);

        pinChange=new JButton("PIN CHANGE");
        pinChange.setBounds(440,250,150,20);
        pinChange.setForeground(Color.WHITE);
        pinChange.setBackground(Color.BLACK);
        pinChange.addActionListener(this);
        l.add(pinChange);

        miniStatement=new JButton("MINI STATEMENT");
        miniStatement.setBounds(440,280,150,20);
        miniStatement.setForeground(Color.WHITE);
        miniStatement.setBackground(Color.BLACK);
        miniStatement.addActionListener(this);
        l.add(miniStatement);

        exit=new JButton("EXIT");
        exit.setBounds(440,310,150,20);
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.BLACK);
        exit.addActionListener(this);
        l.add(exit);
      //  setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(3);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new deposit(pin).setVisible(true);
        }else if(ae.getSource()==withdraw){
            setVisible(false);
            new withdrawl(pin).setVisible(true);
        }else if (ae.getSource()==fastCash){
            setVisible(false);
            new fastCash(pin).setVisible(true);
        }else if(ae.getSource()==pinChange){
            setVisible(false);
            new pinChange(pin).setVisible(true);
        }else if(ae.getSource()==Benquiry) {
            setVisible(false);
            new balenceEnquiry(pin).setVisible(true);
        }else if(ae.getSource()==miniStatement){
            new miniStatement(pin).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new transaction("");
    }
}
