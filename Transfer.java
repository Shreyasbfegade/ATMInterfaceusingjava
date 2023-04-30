package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java .awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
public class Transfer extends JFrame  implements ActionListener{
    JTextField ammountTextField,accountno1TextField;
    JButton transfer,back,clear;
    String pin;
    Transfer(String pin){ 
        this.pin=pin;
        setLayout(null);


        JLabel text1=new JLabel("Enter account no");
        text1.setBounds(10,40,350,80);
        text1.setFont(new Font("Osward",Font.BOLD,18));
        add(text1);
        
        accountno1TextField=new JTextField();
        accountno1TextField.setBounds(170, 70,400,30);
        add(accountno1TextField);

        JLabel text=new JLabel("Enter Ammount You Want To transfer");
        text.setBounds(100,40,350,380);
        text.setFont(new Font("Osward",Font.BOLD,18));
        add(text);

        ammountTextField=new JTextField();
        ammountTextField.setBounds(100, 280,400,30);
        add(ammountTextField);
        
        transfer=new JButton("Transfer");
        transfer.setBounds(350,320,100,30);
        transfer.setBackground(Color.BLACK);
        transfer.setForeground(Color.WHITE);
        transfer.addActionListener(this);
        add(transfer);

        
        back =new JButton("Back");
        back.setBounds(450,400,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        clear =new JButton("Clear");
        clear.setBounds(150,320,100,30);
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
        if(ae.getSource()==transfer){
            Date date=new Date();
            String number=ammountTextField.getText();
            String accountno=accountno1TextField.getText();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"please enter the ammount you want to transfer");

            } else if(accountno.equals("")){
                JOptionPane.showMessageDialog(null,"please enter the account number");

            }else{
                try{
                conn conn=new conn();
                ResultSet rs= conn.s.executeQuery("Select pin from login where card ='"+accountno+"'");
                
                String query="insert into transfer values('"+pin+"','"+accountno+"','trasnfer','"+number+"')";
                String query1="insert into bank values('"+pin+"','"+date+"','transfer','"+number+"')";
                rs.next();
               String pin1= rs.getString("pin");
                String query2="insert into bank values('"+pin1+"','"+date+"','Receive','"+number+"')";
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Rs  "+number+"  transfer  Succesfully");
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
                accountno1TextField.setText("");
               
    
            }
        }

    public static void main(String args[]){
        new Transfer("");

    }
    
}
