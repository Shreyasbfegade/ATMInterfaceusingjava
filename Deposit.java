package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java .awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
public class Deposit extends JFrame  implements ActionListener{
    JTextField ammountTextField;
    JButton deposit,back,clear;
    String pin;
    Deposit(String pin){ 
        this.pin=pin;
        setLayout(null);
         
        JLabel text=new JLabel("Enter Ammount You Want To Deposit");
        text.setBounds(100,40,400,40);
        text.setFont(new Font("Osward",Font.BOLD,18));
        add(text);

        ammountTextField=new JTextField();
        ammountTextField.setBounds(100,90,400,30);
        add(ammountTextField);
        
         deposit=new JButton("deposit");
        deposit.setBounds(350,200,100,30);
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.WHITE);
        deposit.addActionListener(this);
        add(deposit);

        
        back =new JButton("Back");
        back.setBounds(450,400,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        clear =new JButton("Clear");
        clear.setBounds(150,200,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        getContentPane().setBackground(Color.WHITE);
        setSize(600,480);
        setVisible(true);
        setLocation(450,200);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String number=ammountTextField.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"please enter the ammount you want to deposit");
            } else{
                try{
                conn conn=new conn();
                String query="insert into bank values('"+pin+"','"+date+"','deposit','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs  "+number+"  Deposit  Succesfully");
                setVisible(false);
                new Transaction(pin).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);

                }
                
            }


        }else if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pin).setVisible(true);

        }else if(ae.getSource()==clear){
            
                ammountTextField.setText("");
               
    
            }
        }

    public static void main(String args[]){
        new Deposit("");

    }
    
}
