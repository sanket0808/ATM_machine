package swingdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connection {
    Statement s;
    Connection c;
    connection(){
        try{
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/SANKY","root","Sanket@2002");
            s=c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
