package swingdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class deposit extends JFrame implements ActionListener {

    JButton back,deposit;
    JTextField amount;
    String pin;
    deposit(String pin){
        this.pin=pin;
        setLayout(null);
        setSize(900,900);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/5.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);

        JLabel text=new JLabel("enter the amount you want to deposit");
        text.setBounds(250,250,300,30);
        text.setFont(new Font("releway",Font.BOLD,15));
        text.setForeground(Color.WHITE);
        label.add(text);

        amount=new JTextField();
        amount.setBounds(250,300,400,30);
        amount.setFont(new Font("releway",Font.BOLD,15));
        label.add(amount);

        back=new JButton("Back");
        back.setBounds(500,400,100,30);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        label.add(back);

        deposit=new JButton("Deposit");
        deposit.setBounds(500,360,100,30);
        deposit.setForeground(Color.white);
        deposit.setBackground(Color.BLACK);
        deposit.addActionListener(this);
        label.add(deposit);

        setVisible(true);
        setDefaultCloseOperation(3);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String deposit_amount=amount.getText();
            Date date=new Date();
            if(deposit_amount==" "){
                JOptionPane.showMessageDialog(null,"enter the amount ");
            }else {
                try{
                    connection con=new connection();
                    String query="insert into deposit values('"+pin+"','"+"deposit"+"','"+deposit_amount+"','"+date+"')";
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+deposit_amount+" successfully deposited!");
                    setVisible(false);
                    new transaction(pin).setVisible(true);
                }catch (Exception e) {
                    System.out.println(e);
                }
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new transaction(pin).setVisible(true);
        }
    }
    public static void main(String[] args) {
         new deposit(" ");
    }
}
