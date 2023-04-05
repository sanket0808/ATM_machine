package swingdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinChange extends JFrame implements ActionListener {

    JButton back,change;
    JLabel pass,pass1;
    JPasswordField npin,rpin;
    String pin;
    pinChange(String pin){
        this.pin=pin;
        setLayout(null);
        setSize(900,900);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/5.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);

        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setBounds(350,200,300,25);
        text.setFont(new Font("System",Font.BOLD,18));
        text.setForeground(Color.white);
        label.add(text);

        pass=new JLabel("New Pin:");
        pass.setFont(new Font("System",Font.BOLD,18));
        pass.setBounds(300,240,100,20);
        pass.setForeground(Color.PINK);
        label.add(pass);

        npin=new JPasswordField();
        npin.setFont(new Font("system",Font.BOLD,20));
        npin.setBounds(450,240,200,25);
        label.add(npin);

        pass1=new JLabel("Re-Enter Pin:");
        pass1.setFont(new Font("System",Font.BOLD,18));
        pass1.setBounds(300,280,150,20);
        pass1.setForeground(Color.PINK);
        label.add(pass1);

        rpin=new JPasswordField();
        rpin.setFont(new Font("system",Font.BOLD,20));
        rpin.setBounds(450,280,200,25);
        label.add(rpin);

        change=new JButton("CHANGE");
        change.setBounds(550,400,100,25);
        change.setForeground(Color.white);
        change.setBackground(Color.BLACK);
        change.addActionListener(this);
        label.add(change);

        back=new JButton("BACK");
        back.setBounds(300,400,100,25);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        label.add(back);

        setDefaultCloseOperation(3);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new transaction(pin).setVisible(true);
        }else{
            try{
                String newpin=npin.getText();
                String repin=rpin.getText();
                if(!repin.equals(newpin)){
                    JOptionPane.showMessageDialog(null,"Please Check The Entered Pin");
                    return;
                }
                if(newpin.equals(" ")){
                    JOptionPane.showMessageDialog(null,"Please enter the New Pin");
                    return;
                }
                if(repin.equals(" ")){
                    JOptionPane.showMessageDialog(null,"Please enter the Re-Entered Pin");
                    return;
                }
                connection c=new connection();
                String query1="update login set pin1='"+newpin+"' where pin1='"+pin+"'";
                String query2="update signupthree set pin1 ='"+newpin+"'where pin1='"+pin+"'";
                String query3="update deposit set pin1='"+newpin+"' where pin1='"+pin+"'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"Pin change Successfully");
                setVisible(false);
                new transaction(pin).setVisible(true);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new pinChange("").setVisible(true);
    }
}
