package bankmanagementsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class SignupOne extends JFrame  implements ActionListener {
    JTextField nameTextField,fnameTextField,dobTextField,emailTextField,phTextField,addTextField;
    JButton next;
    JRadioButton r1,r2;

    SignupOne(){
        setLayout(null);

    
        JLabel formno=new JLabel("Application form ");
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        getContentPane().setBackground(Color.WHITE);
        add(formno);

        JLabel personaldetails=new JLabel("page 1:personal Details");
        personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        personaldetails.setBounds(290,80,400,30);
        add(personaldetails);

        JLabel name=new JLabel("Name");
        name.setFont(new Font("Raleway",Font.BOLD,20));
       name.setBounds(100,140,100,30);
        add(name);
        nameTextField=new JTextField();
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);


        JLabel fname=new JLabel(" father's Name");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameTextField=new JTextField();
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);


        JLabel gender=new JLabel(" Gender");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,240,200,30);
        add(gender);
        r1=new JRadioButton("Male");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(350,240,150,20);
        add(r1);

        r2=new JRadioButton("Female");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(500,240,250,20);
        add(r2);
  
        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);

        JLabel emails=new JLabel(" Emails");
        emails.setFont(new Font("Raleway",Font.BOLD,20));
        emails.setBounds(100,290,200,30);
        add(emails);

         emailTextField=new JTextField();
        emailTextField.setBounds(300,290,400,30);
        add(emailTextField);


        JLabel phoneno=new JLabel(" phoneno");
        phoneno.setFont(new Font("Raleway",Font.BOLD,20));
        phoneno.setBounds(100,340,200,30);
        add(phoneno);
    
        phTextField=new JTextField();
        phTextField.setBounds(300,340,400,30);
        add(phTextField);


        JLabel address=new JLabel(" Address");
        address.setFont(new Font("Raleway",Font.BOLD,20));
       address.setBounds(100,390,200,30);
        add(address);

        
        addTextField=new JTextField();
        addTextField.setBounds(300,390,400,30);
        add(addTextField);

        

        JLabel dob=new JLabel(" Date of Birth");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
       dob.setBounds(100,440,400,30);
        add(dob);

        
       dobTextField=new JTextField();
        dobTextField.setBounds(300,440,400,30);
        add(dobTextField);

         next =new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        setSize(850,800);
        setLocation(350,10);
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
        String name =nameTextField.getText();
        String fname =fnameTextField.getText();
        
        String emails =emailTextField.getText();
        String phoneno=phTextField.getText();
        String address =addTextField.getText();
        String dob =dobTextField.getText();
        String gender=null;
    
      
            if(r1.isSelected()){
                gender="Male";
            }else if(r2.isSelected()){
                gender="Female";
            }
       
        
    try{
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null,"Name is required");
        
        } else {
            conn c=new conn();
            String query="insert into signup values('"+name+"','"+fname+"','"+gender+"','"+emails+"','"+phoneno+"','"+address+"','"+dob+"')";
            c.s.executeUpdate(query);
              
        setVisible(false);
        new SignupTwo().setVisible(true);
        }
           
        
      
    }catch(Exception e){
         System.out.println(e);
    }
}    
}

    
    

    public static void main(String args []) {
        
    
    new SignupOne();
    }
    
}
