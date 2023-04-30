package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java .awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    JButton login,clear,SignUp;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("ATM");
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        
        add(label);
        JLabel text=new JLabel("Welcome to ATM");
        text.setBounds(200,40,400,40);
        text.setFont(new Font("Osward",Font.BOLD,38));
        add(text);
        
        JLabel text1=new JLabel("Card no");
        text1.setBounds(120,150,150,40);
        text1.setFont(new Font("Osward",Font.BOLD,28));
        add(text1);
        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,250,30);
        add(cardTextField);

        JLabel text2=new JLabel("Pin No");
        text2.setBounds(120,220,250,30);
        text2.setFont(new Font("Osward",Font.BOLD,28));
        add(text2);
       pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,250,30);
        add(pinTextField);

        login =new JButton("LOGIN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear =new JButton("Clear");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);

        add(clear);

         SignUp =new JButton("Sign Up");
        SignUp.setBounds(300,350,230,30);
        SignUp.setBackground(Color.BLACK);
        SignUp.setForeground(Color.WHITE);
        SignUp.addActionListener(this);

        add(SignUp);

        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");

        } else if(ae.getSource()==login){
            conn conn=new conn();
            String card=cardTextField.getText();
            String pin=pinTextField.getText();
            String query="Select * from login where card='"+card+"' and pin='"+pin+"'";
            try{
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or pin");
                }

            }catch(Exception e){
                System.out.println(e);
            }



        } else if(ae.getSource()==SignUp){
            setVisible(false);
            new SignupOne().setVisible(true);

        }


    }
    public static void main(String args[]){
        new Login();

    }
    
}
