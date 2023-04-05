package swingdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signUp3 extends JFrame implements ActionListener {
    JLabel l3,Atype,cardNo,cardNo1,cardNo2,pin,pin1,pin2,Srequire;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton cancel,submit;
    String formno;
    signUp3(String formno){
        this.formno=formno;
        setLayout(null);
        setSize(800,900);
        setBackground(Color.WHITE);
        getContentPane().setBackground(Color.WHITE);

        l3=new JLabel("page 3 : Account Details");
        l3.setBounds(250,20,300,30);
        l3.setFont(new Font("osword",Font.BOLD,22));
        add(l3);

        Atype=new JLabel("Account Type:");
        Atype.setBounds(100,80,200,30);
        Atype.setFont(new Font("osword",Font.BOLD,22));
        add(Atype);

        r1=new JRadioButton("Savings Account");
        r1.setFont(new Font("osword",Font.BOLD,16));
        r1.setBounds(100,140,200,30);
        add(r1);

        r2=new JRadioButton("Current Account");
        r2.setFont(new Font("osword",Font.BOLD,16));
        r2.setBounds(400,140,200,30);
        add(r2);

        r3=new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("osword",Font.BOLD,16));
        r3.setBounds(100,200,200,30);
        add(r3);

        r4=new JRadioButton("Reccuring Deposit Account");
        r4.setFont(new Font("osword",Font.BOLD,16));
        r4.setBounds(400,200,240,30);
        add(r4);

        ButtonGroup type=new ButtonGroup();
        type.add(r1);
        type.add(r2);
        type.add(r3);
        type.add(r4);

        cardNo=new JLabel("Card Number:");
        cardNo.setBounds(100,250,200,30);
        cardNo.setFont(new Font("osword",Font.BOLD,22));
        add(cardNo);

        cardNo1=new JLabel("XXXX.XXXX.XXXX.2143");
        cardNo1.setBounds(350,250,400,30);
        cardNo1.setFont(new Font("osword",Font.BOLD,20));
        add(cardNo1);

        cardNo2=new JLabel("your 16 digit card No");
        cardNo2.setBounds(100,270,300,30);
        cardNo2.setFont(new Font("osword",Font.BOLD,14));
        add(cardNo2);

        pin=new JLabel("PIN:");
        pin.setBounds(100,320,100,30);
        pin.setFont(new Font("osword",Font.BOLD,22));
        add(pin);

        pin1=new JLabel("XXXX");
        pin1.setBounds(400,320,100,30);
        pin1.setFont(new Font("osword",Font.BOLD,22));
        add(pin1);

        pin2=new JLabel("your 4 digit pin No");
        pin2.setBounds(100,340,300,30);
        pin2.setFont(new Font("osword",Font.BOLD,14));
        add(pin2);

        Srequire=new JLabel("Services Required:");
        Srequire.setBounds(100,380,250,30);
        Srequire.setFont(new Font("osword",Font.BOLD,22));
        add(Srequire);

        c1=new JCheckBox("ATM CARD");
        c1.setBounds(100,420,200,30);
        c1.setFont(new Font("Releway",Font.BOLD,18));
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBounds(400,420,200,30);
        c2.setFont(new Font("Releway",Font.BOLD,18));
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBounds(100,480,200,30);
        c3.setFont(new Font("Releway",Font.BOLD,18));
        add(c3);

        c4=new JCheckBox("EMAIL & SMS alerts");
        c4.setBounds(400,480,200,30);
        c4.setFont(new Font("Releway",Font.BOLD,18));
        add(c4);

        c5=new JCheckBox("Cheque Box");
        c5.setBounds(100,540,200,30);
        c5.setFont(new Font("Releway",Font.BOLD,18));
        add(c5);

        c6=new JCheckBox("E Statements");
        c6.setBounds(400,540,200,30);
        c6.setFont(new Font("Releway",Font.BOLD,18));
        add(c6);

        c7=new JCheckBox("Your above choices are correct?");
        c7.setBounds(100,600,300,30);
        c7.setFont(new Font("Releway",Font.BOLD,12));
        add(c7);

        cancel=new JButton("Cancel");
        cancel.setBounds(100,700,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Releway",Font.BOLD,18));
        cancel.addActionListener(this);
        add(cancel);

        submit=new JButton("Submit");
        submit.setBounds(600,700,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Releway",Font.BOLD,18));
        submit.addActionListener(this);
        add(submit);

        setDefaultCloseOperation(3);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
             String Atype=null;
             if(r1.isSelected()){
                 Atype="Savings Account";
             }else if(r2.isSelected()){
                 Atype="Current Account";
             } else if (r3.isSelected()) {
                 Atype="Fixed Deposit Account";
             } else if (r4.isSelected()) {
                 Atype="Reccuring Deposit Account";
             }
            Random random=new Random();
            String cardNo1=""+Math.abs((random.nextLong()%10000000L)+8005128400000000L);
            String pin1=""+Math.abs(random.nextInt()%9000);
            String Srequire="";
            if(c1.isSelected()){
                Srequire=Srequire+"ATM CARD";
            }else if (c2.isSelected()) {
                Srequire=Srequire+"Internet Banking";
            }else if(c3.isSelected()){
                Srequire=Srequire+"Mobile Banking";
            }else if(c4.isSelected()){
                Srequire=Srequire+"EMAIL & SMS alerts";
            }else if(c5.isSelected()){
                Srequire=Srequire+"Cheque Box";
            }else if(c6.isSelected()){
                Srequire=Srequire+"E Statements";
            }
            try{
                if(Atype==""){
                    JOptionPane.showMessageDialog(null,"Account type is required");
                }else {
                    connection c=new connection();
                    String Query1="Insert into signupThree values('"+formno+"','"+Atype+"','"+cardNo1+"','"+pin1+"','"+Srequire+"')";
                    String Query2="Insert into login values('"+formno+"','"+cardNo1+"','"+pin1+"')";
                    c.s.executeUpdate(Query1);
                    JOptionPane.showMessageDialog(null,"card number:"+cardNo1+"\n pin:"+pin1);
                    c.s.executeUpdate(Query2);
                    setVisible(false);
                    new deposit(pin1).setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==cancel){
            setVisible(false);
            new Bank().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new signUp3("");
    }
}
