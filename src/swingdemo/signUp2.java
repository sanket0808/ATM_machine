package swingdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signUp2  extends JFrame implements ActionListener {
        long random;
        JRadioButton yes,no;
        JLabel l2,religion,category,income,Equalification,occupation,panNo,Scitizen,adharNo,Eaccount;
        JTextField panNo1,adharNo1;
        JComboBox category1,religion1,occupation1, Equalification1,income1;
        JButton next;
        String formno;
        signUp2(String formno){
            this.formno=formno;
            setLayout(null);
            setTitle("NEW APPLICATION FORM");
            setSize(800,900);
            setBackground(Color.WHITE);
            getContentPane().setBackground(Color.WHITE);

            l2=new JLabel("Page no:2 Additional Details ");
            l2.setBounds(200,40,500,30);
            l2.setFont(new Font("osword",Font.BOLD,22));
            add(l2);

            religion=new JLabel("Religion:");
            religion.setBounds(80,100,200,30);
            religion.setFont(new Font("osword",Font.BOLD,22));
            add(religion);

            String [] rel={"Hindu","Muslim","Shikh","Khritchen","essai","other"};
            religion1=new JComboBox(rel);
            religion1.setBounds(250,100,500,30);
            religion1.setFont(new Font("osword",Font.BOLD,18));
            add(religion1);

            category=new JLabel("Category:");
            category.setBounds(80,160,300,30);
            category.setFont(new Font("osword",Font.BOLD,22));
            add(category);

            String [] cat={"OPEN","OBC","SC","NT","VJNT","other"};
            category1=new JComboBox(cat);
            category1.setBounds(250,160,500,30);
            category1.setFont(new Font("osword",Font.BOLD,18));
            add(category1);

            income=new JLabel("Income:");
            income.setBounds(80,220,200,30);
            income.setFont(new Font("osword",Font.BOLD,22));
            add(income);

            String [] inc={"NULL","<100000","<150000","<300000","<500000","other"};
            income1=new JComboBox(inc);
            income1.setBounds(250,220,500,30);
            income1.setFont(new Font("osword",Font.BOLD,18));
            add(income1);

            Equalification=new JLabel("Edu.Qualification:");
            Equalification.setBounds(80,280,300,30);
            Equalification.setFont(new Font("osword",Font.BOLD,22));
            add(Equalification);

            String [] edu={"SSC","HSC","graduate","Post Graduate","phd","other"};
            Equalification1=new JComboBox(edu);
            Equalification1.setBounds(280,280,470,30);
            Equalification1.setFont(new Font("osword",Font.BOLD,18));
            add( Equalification1);

            occupation=new JLabel("Occupation:");
            occupation.setBounds(80,340,300,30);
            occupation.setFont(new Font("osword",Font.BOLD,22));
            add(occupation);

            String [] com={"Farmer","Business","Job","other"};
            occupation1=new JComboBox(com);
            occupation1.setBounds(250,340,500,30);
            occupation1.setFont(new Font("osword",Font.BOLD,18));
            add( occupation1);

            panNo=new JLabel("Pan Card No:");
            panNo.setBounds(80,400,300,30);
            panNo.setFont(new Font("osword",Font.BOLD,22));
            add(panNo);

            panNo1=new JTextField();
            panNo1.setBounds(250,400,500,30);
            panNo1.setFont(new Font("osword",Font.BOLD,22));
            add(panNo1);

            adharNo=new JLabel("Adhar No:");
            adharNo.setBounds(80,460,300,30);
            adharNo.setFont(new Font("osword",Font.BOLD,22));
            add(adharNo);

            adharNo1=new JTextField();
            adharNo1.setBounds(250,460,500,30);
            adharNo1.setFont(new Font("osword",Font.BOLD,22));
            add( adharNo1);

            Scitizen=new JLabel("Senior Citizen:");
            Scitizen.setBounds(80,520,300,30);
            Scitizen.setFont(new Font("osword",Font.BOLD,22));
            add ( Scitizen);

            yes=new JRadioButton("Yes");
            yes.setBounds(300,520,100,30);
            add(yes);

            no=new JRadioButton("No");
            no.setBounds(500,520,100,30);
            add( no);

            ButtonGroup SCGroup =new ButtonGroup();
            SCGroup.add(yes);
            SCGroup.add(no);

            Eaccount=new JLabel("Existing Account:");
            Eaccount.setBounds(80,580,500,30);
            Eaccount.setFont(new Font("osword",Font.BOLD,22));
            add( Eaccount);

            yes=new JRadioButton("Yes");
            yes.setBounds(300,580,100,30);
            add(yes);

            no=new JRadioButton("No");
            no.setBounds(500,580,100,30);
            add( no);

            ButtonGroup EaccGroup =new ButtonGroup();
            EaccGroup.add(yes);
            EaccGroup.add(no);

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
//            String formno=""+random;
            String religion=(String) religion1.getSelectedItem();
            String category=(String)category1.getSelectedItem();
            String income=(String)income1.getSelectedItem();
            String Equalification=(String)Equalification1.getSelectedItem();
            String  occupation=(String) occupation1.getSelectedItem();
            String panNo=panNo1.getText();
            String adharNo=adharNo1.getText();
            String Eaccount=null;
            if(yes.isSelected()){
                Eaccount="Yes";
            }else if(no.isSelected()){
                Eaccount="No";
            }
            String Scitizen=null;
            if(yes.isSelected()){
                Scitizen="Yes";
            }else if(no.isSelected()){
                Scitizen="No";
            }
            try{
                    connection c=new connection();
                    String Query="Insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+Equalification+"','"+income+"','"+occupation+"','"+Scitizen+"','"+Eaccount+"','"+panNo+"','"+adharNo+"')";
                    c.s.executeUpdate(Query);
                    setVisible(false);
                    new signUp3(formno).setVisible(true);
            }catch (Exception ae){
                System.out.println(ae);
            }
        }

        public static void main(String[] args) {
          signUp2 s=new signUp2("");
        }
}
