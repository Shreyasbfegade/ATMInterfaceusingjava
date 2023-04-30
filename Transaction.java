package bankmanagementsystem;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
public class Transaction  extends JFrame implements ActionListener{
    JButton deposit,withdrawl,ministatement, trasnfer,exit;
    String pin;
    Transaction(String pin){
        this.pin=pin;
        setLayout(null);
        
        JLabel text=new JLabel("Please Select Your Transaction");
        text.setFont(new Font("Raleway",Font.BOLD,22));
        text.setBounds(280,30,700,35);
        add(text);

        deposit=new JButton("Deposit");
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.WHITE);
        deposit.setFont(new Font ("Raleway",Font.BOLD,14));
        deposit.setBounds(150,180,200,50);
        deposit.addActionListener(this);
        add(deposit);

        withdrawl=new JButton("Withdrawl Cash");
        withdrawl.setBackground(Color.BLACK);
        withdrawl.setForeground(Color.WHITE);
        withdrawl.setFont(new Font ("Raleway",Font.BOLD,14));
        withdrawl.setBounds(550,180,200,50);
        withdrawl.addActionListener(this);
        add(withdrawl);

   

        ministatement=new JButton("MINI Statement");
        ministatement.setBackground(Color.BLACK);
        ministatement.setForeground(Color.WHITE);
        ministatement.setFont(new Font ("Raleway",Font.BOLD,14));
        ministatement.setBounds(150,380,200,50);
        ministatement.addActionListener(this);
        add(ministatement);

        trasnfer=new JButton("Transfer");
        trasnfer.setBackground(Color.BLACK);
        trasnfer.setForeground(Color.WHITE);
        trasnfer.setFont(new Font ("Raleway",Font.BOLD,14));
        trasnfer.setBounds(550,380,200,50);
        trasnfer.addActionListener(this);
        add(trasnfer);

        exit=new JButton("Exit");
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font ("Raleway",Font.BOLD,14));
        exit.setBounds(350,580,200,50);
        exit.addActionListener(this);
        add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
            
        }else if (ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if (ae.getSource()==withdrawl){
            setVisible(false);
            new withdrawl(pin).setVisible(true);
        }else if (ae.getSource()==ministatement){
            setVisible(false);
            new ministatement(pin).setVisible(true);
        }else if (ae.getSource()==trasnfer){
            setVisible(false);
            new Transfer(pin).setVisible(true);
        
        
    }
}
   
    public static void main(String args[]){
        new Transaction("");
    }
    
}
