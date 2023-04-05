package swingdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;

public class fastCash extends JFrame implements ActionListener {
        JButton deposit,withdraw,Benquiry,exit,miniStatement,fastCash,pinChange,b1;
        String pin;
        fastCash(String pin){
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

            JLabel text=new JLabel("Please select amount you want to withdraw");
            text.setBounds(300,200,500,25);
            text.setForeground(Color.WHITE);
            l.add(text);

            deposit=new JButton("100");
            deposit.setBounds(210,250,150,20);
            deposit.setForeground(Color.WHITE);
            deposit.setBackground(Color.BLACK);
            deposit.addActionListener(this);
            l.add(deposit);

            withdraw=new JButton("200");
            withdraw.setBounds(210,280,150,20);
            withdraw.setForeground(Color.WHITE);
            withdraw.setBackground(Color.BLACK);
            withdraw.addActionListener(this);
            l.add(withdraw);

            fastCash=new JButton("500");
            fastCash.setBounds(210,310,150,20);
            fastCash.setForeground(Color.WHITE);
            fastCash.setBackground(Color.BLACK);
            fastCash.addActionListener(this);
            l.add(fastCash);

            Benquiry=new JButton("1000");
            Benquiry.setBounds(210,340,150,20);
            Benquiry.setForeground(Color.WHITE);
            Benquiry.setBackground(Color.BLACK);
            Benquiry.addActionListener(this);
            l.add(Benquiry);

            pinChange=new JButton("2000");
            pinChange.setBounds(440,250,150,20);
            pinChange.setForeground(Color.WHITE);
            pinChange.setBackground(Color.BLACK);
            pinChange.addActionListener(this);
            l.add(pinChange);

            miniStatement=new JButton("5000");
            miniStatement.setBounds(440,280,150,20);
            miniStatement.setForeground(Color.WHITE);
            miniStatement.setBackground(Color.BLACK);
            miniStatement.addActionListener(this);
            l.add(miniStatement);

            b1=new JButton("10000");
            b1.setBounds(440,310,150,20);
            b1.setForeground(Color.WHITE);
            b1.setBackground(Color.BLACK);
            b1.addActionListener(this);
            l.add(b1);

            exit=new JButton("Back");
            exit.setBounds(440,340,150,20);
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
                setVisible(false);
                new transaction(pin).setVisible(true);
            }else{
                String amount=((JButton)ae.getSource()).getText();
                connection c=new connection();
                try{
                    ResultSet r=c.s.executeQuery("select * from deposit where pin1 = '"+ pin +"'");
                    int balence=0;
                    while(r.next()){
                        if(r.getString("type").equals("deposit")){
                            balence += Integer.parseInt(r.getString("amount"));
                        }else{
                            balence -= Integer.parseInt(r.getString("amount"));
                        }
                    }
                    if(ae.getSource()!=exit && balence<Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null,"Insufficiant balence");
                    }else{
                        Date date=new Date();
                        String query="Insert into deposit values('"+pin+"','"+"withdraw"+"','"+amount+"','"+date+"')";
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Rs "+amount+" debited successfully");
                        setVisible(false);
                        new transaction(pin).setVisible(true);
                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }
        public static void main(String[] args) {
            new swingdemo.fastCash("");
        }
    }
