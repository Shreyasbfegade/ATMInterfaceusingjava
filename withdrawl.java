package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java .awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
public class withdrawl extends JFrame  implements ActionListener{
    JTextField ammountTextField;
    JButton withdrawl,back,clear;
    String pin;
    withdrawl(String pin){ 
        this.pin=pin;
        setLayout(null);
        JLabel text=new JLabel("Enter Ammount You Want To withdrawl");
        text.setBounds(100,40,400,40);
        text.setFont(new Font("Osward",Font.BOLD,18));
        add(text);

        ammountTextField=new JTextField();
        ammountTextField.setBounds(100,90,400,30);
        add(ammountTextField);
        
         withdrawl=new JButton("withdrawl");
        withdrawl.setBounds(350,200,100,30);
        withdrawl.setBackground(Color.BLACK);
        withdrawl.setForeground(Color.WHITE);
        withdrawl.addActionListener(this);
        add(withdrawl);

        
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
        if(ae.getSource()==withdrawl){
            String number=ammountTextField.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"please enter the ammount you want to withdrawl");
            } else{
                try{
                conn conn=new conn();
                String query="insert into bank values('"+pin+"','"+date+"','withdrawl','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs  "+number+"  withdrawl  Succesfully");
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