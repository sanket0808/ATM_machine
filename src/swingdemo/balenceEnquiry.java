package swingdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balenceEnquiry extends JFrame implements ActionListener {
    String pin;
    JButton back;
    balenceEnquiry(String pin){
        this.pin=pin;

        setLayout(null);

        setSize(900,900);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/5.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l=new JLabel(i3);
        l.setBounds(0,0,900,900);
        add(l);

        back=new JButton("Back");
        back.setBounds(530,400,100,30);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(this);
        l.add(back);

        connection c=new connection();
        int balence=0;
        try {
            ResultSet r = c.s.executeQuery("select * from deposit where pin1 = '" + pin + "'");
            while (r.next()) {
                if (r.getString("type").equals("deposit")) {
                    balence += Integer.parseInt(r.getString("amount"));
                } else {
                    balence -= Integer.parseInt(r.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        JLabel text=new JLabel("your current account balence is: "+balence);
        text.setBounds(250,300,500,30);
        text.setFont(new Font("osword",Font.BOLD,15));
        text.setForeground(Color.pink);
        l.add(text);
        setVisible(true);
        setDefaultCloseOperation(3);
    }
    public void actionPerformed(ActionEvent ae){
            setVisible(false);
            new transaction(pin).setVisible(true);
    }
    public static void main(String[] args) {
        new balenceEnquiry("");
    }
}
