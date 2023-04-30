package bankmanagementsystem;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.*;

public class ministatement extends JFrame {

    ministatement( String pin){
        
        setTitle("Mini Statement");
        setLayout(null);
        JLabel mini=new JLabel();
        add(mini);
        JLabel bank=new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        
        add(bank);
        
     

        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        try{
            conn conn=new conn();

           ResultSet rs= conn.s.executeQuery("Select * from login where pin ='"+pin+"'");
           while(rs.next()){
            card.setText("card number"+rs.getString("card").substring(0,4)+"xxxxx"+rs.getString("card").substring(12));
           }

        }catch(Exception e){
            System.out.println(e);
        }

        try{
            conn conn=new conn();

           ResultSet rs= conn.s.executeQuery("Select * from bank where pin ='"+pin+"'");
           
           while(rs.next()){
            mini.setText(mini.getText()+"<html>"+rs.getString("type")+"&nbsp;&nbsp;"+rs.getString("number")+"&nbsp;&nbsp;"+rs.getString("date")+"&nbsp;&nbsp;"+"<br><html>" )   ;       }

        }catch(Exception e){
            System.out.println(e);
        }
        
        mini.setBounds(20,140,400,300);
       
        setSize(400,600);
       
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        

    }
    public static void main(String args[]){
        new ministatement("");
        
    }
    
}
