package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
public class SignupTwo extends JFrame  implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5;
    JButton submit,cancel;
    SignupTwo(){
        setLayout(null);
        JLabel l1=new JLabel("page 2: Account details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,460,40);
        add(l1);

        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,150,20);
        add(r1);

        r2=new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,250,20);
        add(r2);

        r3=new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,250,20);
        add(r3);

        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,20);
        add(r4);
        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card=new JLabel( "Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel number=new JLabel( "XXXX-XXXX-XXXX-1234");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);

        JLabel carddetail=new JLabel( "Your 16 Digit card Number");
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail.setBounds(100,330,300,20);
        add(carddetail);

        
        JLabel pin=new JLabel( "PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,300,30);
        add(pin);

        
        
        JLabel pno=new JLabel( "XXXX");
        pno.setFont(new Font("Raleway",Font.BOLD,22));
        pno.setBounds(330,370,300,30);
        add(pno);

        JLabel pindetail=new JLabel( "Your 4 digit password");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(100,400,300,20);
        add(pindetail);

        
        JLabel services=new JLabel( "Services Requried");
        services.setFont(new Font("Raleway",Font.BOLD,18));
        services.setBounds(100,450,200,30);
        add(services);

       

        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
        
        
        c2=new JCheckBox("INTERNET BANKING");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);

        c3=new JCheckBox("MOBILE BANKING");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4=new JCheckBox("EMAILS & SMS ALERT");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);
      
        c5=new JCheckBox("I herby declares that the above entered details are correct to the best of my knowledge");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,12));
        c5.setBounds(100,680,600,30);
        add(c5);
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font ("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font ("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType=null;
            if(r1.isSelected()){
                accountType="saving Account";
            }else if(r2.isSelected()){
                accountType="Fixed Deposit Account";
            }else if(r3.isSelected()){
                accountType="Current Account";
            }else if(r4.isSelected()){
                accountType="reccuring Deposit Account";
            }
            Random random=new Random();
            String card=""+Math.abs((random.nextLong()%9000000L)+5040936000000L);
            String pin=""+Math.abs((random.nextLong()%9000L)+1000L);
            String facility="";
            if(c1.isSelected()){
                facility=facility+"ATM Card";
            }else if(c2.isSelected()){
                facility=facility+"Internet Banking";
            }else if(c3.isSelected()){
                facility=facility+"Mobile Banking";
            }else if(r4.isSelected()){
                facility=facility+"Emails & SMS Alerts";
            }
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Requries");
                
                }else{
                    conn conn=new conn();
                    String query1="insert into signuptwo values('"+accountType+"','"+card+"','"+pin+"','"+facility+"')";
                    String query2="insert into login values('"+card+"','"+pin+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "card number"+card+"\n pin"+pin);
                }

            }catch(Exception e){
                System.out.println(e);
            }
            setVisible(false);
            new Login().setVisible(true);
        
        
            
        }else if(ae.getSource()==cancel){
            System.exit(0);

        }
    }


public static void main(String args[]){
    new SignupTwo();
    }
}

