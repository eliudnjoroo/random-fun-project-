package randomproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.sql.PreparedStatement;

public class createaccount implements ActionListener{

    JFrame cframe=new JFrame();
    JFrame pframe=new JFrame("set password");
    //buttons
    JButton back=new JButton("back");
    JButton create=new JButton("create");
    JButton help=new JButton("Clear");
    //buttons2
    JButton back2=new JButton("back");
    JButton create2=new JButton("create");
    JButton help2=new JButton("show password");
    JButton help3=new JButton("hide password");
    //labels
    JLabel name1=new JLabel("first name: ");
    JLabel recword=new JLabel("secret word:");
    JLabel recconf=new JLabel("the secret word would be used when forget your password");
    JLabel name2=new JLabel("second name: ");
    JLabel email=new JLabel("email adress: ");
    JLabel newpass=new JLabel("create password: ");
    JLabel conpass=new JLabel("confirm password: ");
    JLabel username=new JLabel("create username: ");
    //textfields
    JTextField name1t=new JTextField();
    JTextField name2t=new JTextField();
    JTextField emailt=new JTextField();
    JTextField recwordt=new JTextField();
    //JTextField recconft=new JTextField();
    JPasswordField newpasst=new JPasswordField();
    JPasswordField conpasst=new JPasswordField();
    JTextField usernamet=new JTextField();
    static Connection con1;
    static Connection con;
     public static PreparedStatement statement;
     public static PreparedStatement statement1;

    createaccount(){
        
        cframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        cframe.setSize(355, 260);
        cframe.setTitle("create new cool-app account");
        cframe.setLocationRelativeTo(null);
        cframe.setResizable(false);
        cframe.setLayout(null);
        cframe.getContentPane().setBackground(Color.black);
        
        
        pframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        pframe.setSize(355, 260);
        pframe.setTitle("create new cool-app account");
        pframe.setLocationRelativeTo(null);
        pframe.setResizable(false);
        pframe.setLayout(null);
        pframe.getContentPane().setBackground(Color.black);
        
        back.setBounds(10, 180, 80, 25);
        back.setBackground(Color.red);
        back.setFocusable(false);
        back.addActionListener(this);
        
        create.setBounds(100, 180, 80, 25);
        create.setBackground(Color.green);
        create.setFocusable(false);
        create.addActionListener(this);
        
        help.setBounds(190, 180, 140, 25);
        help.setBackground(Color.green);
        help.setFocusable(false);
        help.addActionListener(this);
        
        back2.setBounds(10, 180, 80, 25);
        back2.setBackground(Color.red);
        back2.setFocusable(false);
        back2.addActionListener(this);
        
        create2.setBounds(100, 180, 80, 25);
        create2.setBackground(Color.green);
        create2.setFocusable(false);
        create2.addActionListener(this);
        
        help2.setBounds(190, 180, 140, 25);
        help2.setBackground(Color.green);
        help2.setFocusable(false);
        help2.addActionListener(this);
        
        help3.setBounds(190, 180, 140, 25);
        help3.setBackground(Color.green);
        help3.setFocusable(false);
        help3.addActionListener(this);
        
        name1.setBounds(10, 20, 90, 30);
        name2.setBounds(10, 60, 90, 30);
        email.setBounds(10, 100, 90, 30);
        username.setBounds(10, 140, 120, 30);
        
        name1.setForeground(Color.yellow);
        name2.setForeground(Color.yellow);
        recword.setForeground(Color.yellow);
        recconf.setForeground(Color.blue);
        email.setForeground(Color.yellow);
        newpass.setForeground(Color.yellow);
        conpass.setForeground(Color.yellow);
        username.setForeground(Color.yellow);
        
        name1t.setBounds(130, 20, 200, 30);
        name2t.setBounds(130, 60, 200, 30);
        emailt.setBounds(130, 100, 200, 30);
        usernamet.setBounds(130, 140, 200, 30);
        
         recconf.setFont(new Font(null,Font.BOLD,12));
         recwordt.setBounds(130, 100, 200, 30);
         recword.setBounds(10, 100, 120, 30);
         recconf.setBounds(2, 140, 335, 30);
        
         newpass.setBounds(10, 20, 100, 30);
         conpass.setBounds(10, 60, 100, 30);
        
         newpasst.setBounds(130, 20, 200, 30);
         conpasst.setBounds(130, 60, 200, 30);
        
         pframe.add(newpasst);
         pframe.add(recconf);
         pframe.add(recword);
         pframe.add(conpasst);
         pframe.add(recwordt);
         pframe.add(newpass);
         pframe.add(conpass);
         pframe.add(help2);
         pframe.add(help3);
         pframe.add(create2);
         pframe.add(back2);
         
        cframe.add(name1t);
        cframe.add(name2t);
        cframe.add(emailt);
        cframe.add(usernamet);
        cframe.add(name1t);
        cframe.add(name1);
        cframe.add(name2);
        cframe.add(email);
        cframe.add(username);
        cframe.add(help);
        cframe.add(create);
        cframe.add(back);
        cframe.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String n1t2=name1t.getText();
        if(e.getSource()==back){
        new randomClass();
        cframe.dispose();
        }
        if(e.getSource()==create){
            String n1t=name1t.getText();
            String n2t=name2t.getText();
            String emt=emailt.getText();
            String unt=usernamet.getText();
            if(n1t.equals("")||n2t.equals("")||emt.equals("")||unt.equals("")){
                JOptionPane.showMessageDialog(null,"please fill in the fields/field!");
            }
            else{
                if(emt.endsWith("@gmail.com")){
                    if(emt.length()>=14){
                        try {
                            String n2t2=name2t.getText();
                            String emt2=emailt.getText();
                            String unt2=usernamet.getText();
                            connect();
                            statement=con1.prepareStatement("insert into cool_tb(fn, sn, ea, un) values(?, ?, ?, ?)");
                            statement.setString(1,n1t2);
                            statement.setString(2,n2t2);
                            statement.setString(3,emt2);
                            statement.setString(4,unt2);
                            statement.executeUpdate();
                            
                            con1.close();
                            JOptionPane.showMessageDialog(null,"saved");
                            cframe.dispose();
                            pframe.setVisible(true);
                        } catch (SQLException ex) {
                            Logger.getLogger(createaccount.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"your email is too short!");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"invalid email!");
                }
            }
        }
        if(e.getSource()==back2){
        cframe.setVisible(true);
        pframe.dispose();
        }
        if(e.getSource()==create2){
            String npt=newpasst.getText();
            String cpt=conpasst.getText();
            if(npt.length()>=4&&cpt.length()>=4){
                if(npt.contentEquals(cpt)){
                    
                    try {
                        connect1();
                        String n12=conpasst.getText();
                        String n22=recwordt.getText();
                        statement1=con.prepareStatement("update cool_tb set pw = ?, sw = ? where fn = ?");
                        statement1.setString(1,n12);
                        statement1.setString(2,n22);
                        statement1.setString(3,n1t2);
                        statement1.executeUpdate();
                            con.close();
                            JOptionPane.showMessageDialog(null,"saved");
                            JOptionPane.showMessageDialog(null,"account created succesfully");
                        new randomClass();
                        pframe.dispose();
                    } catch (SQLException ex) {
                        Logger.getLogger(createaccount.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"password do not match");
                }
            }else{
                JOptionPane.showMessageDialog(null,"password must be more than 4 charactors");
            }
        }
        if(e.getSource()==help2){
            newpasst.setEchoChar((char)0);
            conpasst.setEchoChar((char)0);
            help2.hide();
            help3.show();
        }
        if(e.getSource()==help3){
            newpasst.setEchoChar('*');
            conpasst.setEchoChar('*');
            help3.hide();
            help2.show();
        }
        if(e.getSource()==help){
            name1t.setText("");
            name2t.setText("");
            emailt.setText("");
            usernamet.setText("");
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
                public static void connect1() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:1111/cool_db", "root", "2222");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(createaccount.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
}
  
