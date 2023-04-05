package swingdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class signUp extends JFrame implements ActionListener {
    long random;
    JRadioButton male,female,married,unmarried,other;
    JLabel formno,l2,name,pin,Fname,DOB,gen,email,Mstatus,city,address,state;
    JTextField name1,Fname1,pin1,address1,city1,email1,state1;
    JDateChooser dob;
    JButton next;
    signUp(){
        setLayout(null);
        setSize(800,900);
        setBackground(Color.WHITE);
        getContentPane().setBackground(Color.WHITE);
        Random ra=new Random();
//        int random=Math.abs(ra.nextInt()%10000);
        random=Math.abs(ra.nextLong() % 9000)+1000L;

        formno=new JLabel("APPLICATION FORM NO:"+random);
        formno.setBounds(150,20,500,30);
        formno.setFont(new Font("osword",Font.BOLD,30));
        add(formno);

        l2=new JLabel("Page no:1 Personal Details ");
        l2.setBounds(200,60,500,30);
        l2.setFont(new Font("osword",Font.BOLD,22));
        add(l2);

        name=new JLabel("Name:");
        name.setBounds(80,100,200,30);
        name.setFont(new Font("osword",Font.BOLD,22));
        add(name);

        name1=new JTextField();
        name1.setBounds(250,100,500,30);
        name1.setFont(new Font("osword",Font.BOLD,22));
        add(name1);

        Fname=new JLabel("Father's Name:");
        Fname.setBounds(80,160,300,30);
        Fname.setFont(new Font("osword",Font.BOLD,22));
        add(Fname);

        Fname1=new JTextField();
        Fname1.setBounds(250,160,500,30);
        Fname1.setFont(new Font("osword",Font.BOLD,22));
        add(Fname1);

        DOB=new JLabel("Date Of Birth:");
        DOB.setBounds(80,220,200,30);
        DOB.setFont(new Font("osword",Font.BOLD,22));
        add(DOB);

        dob=new JDateChooser();
        dob.setBounds(250,220,500,30);
        dob.setForeground(Color.black);
        add(dob);

        gen=new JLabel("Gender:");
        gen.setBounds(80,280,200,30);
        gen.setFont(new Font("osword",Font.BOLD,22));
        add(gen);

        male=new JRadioButton("Male");
        male.setBounds(250,280,100,30);
        add(male);

        female=new JRadioButton("Female");
        female.setBounds(400,280,100,30);
        add(female);

        other=new JRadioButton("Other");
        other.setBounds(550,280,100,30);
        add(other);

        ButtonGroup genderGroup =new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        email=new JLabel("Email Adress:");
        email.setBounds(80,340,300,30);
        email.setFont(new Font("osword",Font.BOLD,22));
        add(email);

        email1=new JTextField();
        email1.setBounds(250,340,500,30);
        email1.setFont(new Font("osword",Font.BOLD,22));
        add(email1);

        Mstatus=new JLabel("Marital Status:");
        Mstatus.setBounds(80,400,300,30);
        Mstatus.setFont(new Font("osword",Font.BOLD,22));
        add(Mstatus);

        married=new JRadioButton("Married");
        married.setBounds(250,400,100,30);
        add( married);

        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(400,400,100,30);
        add(unmarried);

        ButtonGroup marritalGroup=new ButtonGroup();
        marritalGroup.add(married);
        marritalGroup.add(unmarried);

        address=new JLabel("Adress:");
        address.setBounds(80,460,300,30);
        address.setFont(new Font("osword",Font.BOLD,22));
        add(address);

        address1=new JTextField();
        address1.setBounds(250,460,500,30);
        address1.setFont(new Font("osword",Font.BOLD,22));
        add(address1);

        city=new JLabel("City:");
        city.setBounds(80,520,300,30);
        city.setFont(new Font("osword",Font.BOLD,22));
        add(city);

        city1=new JTextField();
        city1.setBounds(250,520,500,30);
        city1.setFont(new Font("osword",Font.BOLD,22));
        add(city1);

        state=new JLabel("State:");
        state.setBounds(80,580,300,30);
        state.setFont(new Font("osword",Font.BOLD,22));
        add(state);

        state1=new JTextField();
        state1.setBounds(250,580,500,30);
        state1.setFont(new Font("osword",Font.BOLD,22));
        add(state1);

        pin=new JLabel("Pin Code:");
        pin.setBounds(80,640,300,30);
        pin.setFont(new Font("osword",Font.BOLD,22));
        add(pin);

        pin1=new JTextField();
        pin1.setBounds(250,640,500,30);
        pin1.setFont(new Font("osword",Font.BOLD,22));
        add(pin1);

        next=new JButton("Next");
        next.setBounds(650,720,100,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        setDefaultCloseOperation(3);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String formno=""+random;
        String name=name1.getText();
        String Fname=Fname1.getText();
        String DOB=((JTextField)dob.getDateEditor().getUiComponent()).getText();
        String gen=null;
        if(male.isSelected()){
            gen="Male";
         }else if(female.isSelected()){
            gen="Female";
        }else if(other.isSelected()){
            gen="Other";
        }
        String email= email1.getText();
        String Mstatus=null;
        if(married.isSelected()){
            Mstatus="Married";
        }else if(unmarried.isSelected()){
            Mstatus="Unamrried";
        }
        String city=city1.getText();
        String state=state1.getText();
        String address=address1.getText();
        String pin=pin1.getText();
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }
            else{
                connection c=new connection();
                String Query="Insert into signup values('"+formno+"','"+name+"','"+Fname+"','"+DOB+"','"+gen+"','"+email+"','"+Mstatus+"','"+city+"','"+state+"','"+address+"','"+pin+"')";
                c.s.executeUpdate(Query);
                setVisible(false);
                new signUp2(formno).setVisible(true);
            }

        }catch (Exception ae){
            System.out.println(ae);
        }
    }

    public static void main(String[] args) {
        signUp s=new signUp();
    }
}
