package swingdemo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;

public class miniStatement extends JFrame {
    String pin;
    miniStatement(String pin){
        this.pin=pin;
        setLayout(null);
        setSize(600,600);
        setLocation(400,100);
        setTitle("mini statement");
        JLabel bank=new JLabel("Bank Of India");
        bank.setBounds(250,50,100,40);
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(50,90,500,30);
        add(card);

        JLabel bal=new JLabel();
        bal.setBounds(50,450,500,30);
        add(bal);

        JLabel mini=new JLabel();
        mini.setBounds(50,40,500,400);
        add(mini);
        try{
            connection c=new connection();
            ResultSet rs =c.s.executeQuery("(select * from login where pin1='"+pin+"')");
            while(rs.next()){
            card.setText("cardNumber: "+rs.getString("cardNo1").substring(0,4)+"XXXXXXXX"+rs.getString("cardNo1").substring(12));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            connection c=new connection();
            ResultSet rs=c.s.executeQuery("(select * from deposit where pin1='"+pin+"')");
            int balence=0;
            while(rs.next()){
            mini.setText(mini.getText()+"<html>"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br>");
            if(rs.getString("type").equals("deposit")){
                    balence += Integer.parseInt(rs.getString("amount"));
                 }
            else{
                    balence -= Integer.parseInt(rs.getString("amount"));
                 }
            }
            bal.setText("your current balence is Rs: "+balence);
        }catch (Exception e){
            System.out.println(e);
        }

        setVisible(true);
        setDefaultCloseOperation(3);
    }
    public static void main(String[] args) {
        new miniStatement("");
    }
}
