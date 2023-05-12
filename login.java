package randomproject;

import java.awt.Color;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static randomproject.createaccount.con1;
import static randomproject.createaccount.statement;
import static randomproject.createaccount.statement1;

public class login extends JFrame implements ActionListener{
    public static Connection con;
    JButton back=new JButton("back");
    JFrame fframe=new JFrame("account recovery");
    JButton next=new JButton("login");
    JButton ok=new JButton("confirm");
    JButton forgot=new JButton("Forgot password");
    JLabel username=new JLabel("Username:");
    JLabel password=new JLabel("password:");
    JTextField nametextfield=new JTextField();
    JTextField numt=new JTextField();
    JPasswordField passtextfield=new JPasswordField();
    
    login(){
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(355, 170);
        this.setTitle("cool-app login");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.black);
        
        back.setBounds(10, 100, 80, 25);
        back.setBackground(Color.red);
        back.setFocusable(false);
        back.addActionListener(this);
        
        next.setBounds(100, 100, 80, 25);
        next.setBackground(Color.green);
        next.setFocusable(false);
        next.addActionListener(this);
        
        forgot.setBounds(190, 100, 140, 25);
        forgot.setBackground(Color.green);
        forgot.setFocusable(false);
        forgot.addActionListener(this);
        
        username.setBounds(20, 20, 90, 25);
        username.setForeground(Color.green);
        
        nametextfield.setBounds(130, 20, 150, 25);
        
        password.setBounds(20, 60, 90, 25);
        password.setForeground(Color.green);
        
        passtextfield.setBounds(130, 60, 150, 25);
        
        this.add(nametextfield);
        this.add(passtextfield);
        this.add(username);
        this.add(password);
        this.add(back);
        this.add(next);
        this.add(forgot);
        this.setVisible(true);
    }
    public void checkbox() throws SQLException{
        String passtxt=passtextfield.getText();
        String subtxt=nametextfield.getText();
        if(subtxt.contentEquals("") || passtxt.contentEquals("")){
            JOptionPane.showMessageDialog(null,"please fill in the empty fields/field.");
        }
        else{
            if(passtxt.length()>=4){
                checkdetails();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null,"invalid pssword!");
            }
        }
    }
    public void checkdetails() throws SQLException{
        try {
                        connect1();
                        String n12=nametextfield.getText();
                        String n121=passtextfield.getText();
                        statement1=con.prepareStatement("select un, pw from cool_tb where un = ? and pw = ?");
                        statement1.setString(1,n12);
                        statement1.setString(2,n121);
                        ResultSet rs=statement1.executeQuery();
                        if (rs.next()==true){
                        String p=rs.getString(1);
                        String p1=rs.getString(2);
                        String pass=rs.getString(1);
                        String pass1=rs.getString(2);
                        p.concat(pass);
                        p1.concat(pass1);
                        JOptionPane.showMessageDialog(null, "welcome "+n12+", \nyour login \n is successfull.");
                        con.close();
                        new customerpage();
                        
                        
                        }else{
                       nametextfield.setText("");
                       passtextfield.setText("");
                       JOptionPane.showMessageDialog(null, "invalid details,\ncreate account if you \ndon't have one.","error",JOptionPane.ERROR_MESSAGE);
                        new login();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(createaccount.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }
    public void rempass(){
        
        JOptionPane.showMessageDialog(null,"please enter your recovery password\nin the next window"
                + " to retrieve your\naccount details.");
        
        fframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fframe.setSize(280, 85);
        fframe.setLocationRelativeTo(null);
        fframe.setResizable(false);
        fframe.setLayout(null);
        fframe.getContentPane().setBackground(Color.black);
        
        ok.setBounds(170, 10, 80, 25);
        ok.setBackground(Color.green);
        ok.setFocusable(false);
        ok.addActionListener(this);
        
        numt.setBounds(10, 10, 150, 25);
        
        fframe.add(ok);
        fframe.add(numt);
        fframe.setVisible(true);
        
    }
    public void confirm(){
        String a=numt.getText();
        if(a.contentEquals("")){
            JOptionPane.showMessageDialog(null,"please enter your recovery password\nbefore confiming");
        }
        else{
            try {
                        connect1();
                        String n12=numt.getText();
                        statement=con.prepareStatement("select fn, sn, ea, un, pw from cool_tb where sw = ?");
                        statement.setString(1,n12);
                        ResultSet rs=statement.executeQuery();
                        if (rs.next()==true){
                        String f=rs.getString(1);
                        String s=rs.getString(2);
                        String e=rs.getString(3);
                        String u=rs.getString(4);
                        String p=rs.getString(5);
                        JOptionPane.showMessageDialog(null, "your details are"
                                + "\n first name: "+f+
                                "\n second name: "+s+
                                "\n email adress: "+e+
                                "\n username: "+u+
                                "\n password: "+p+
                                "\nyour details your secret.\n thanks much"
                        );
                        con.close();
                        new login();
                        
                        
                        }else{
                       numt.setText("");
                       JOptionPane.showMessageDialog(null, "wrong recovery password\nor no account is with such details","error",JOptionPane.ERROR_MESSAGE);
                        new login();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(createaccount.class.getName()).log(Level.SEVERE, null, ex);
                    }
        fframe.dispose();
        }
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
        new randomClass();
        this.dispose();
        }
        if(e.getSource()==next){
            try {
                checkbox();
            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==forgot){
            rempass();
        }
        if(e.getSource()==ok){
            confirm();
        }
    }      public static void connect1() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:1111/cool_db", "root", "2222");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(createaccount.class.getName()).log(Level.SEVERE, null, ex);
        }
  } 
       public static void connect() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:1111/cool_db", "root", "2222");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(createaccount.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
}
    

