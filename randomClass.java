package randomproject;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class randomClass extends JFrame implements ActionListener{
    
    JMenuBar menu=new JMenuBar();
    //menu items
    JMenu navigate=new JMenu("navigate");
    //navigate menu
    JMenuItem privacy=new JMenuItem("privacy policy");
    JMenuItem terms=new JMenuItem("terms and conditions");
    JMenuItem disclaimer=new JMenuItem("disclaimer");
    JMenuItem report=new JMenuItem("report bug");
    //frame
    JFrame frame=new JFrame();
    //font
    Font font=new Font(null,Font.BOLD,30);
    //buttons
    JButton button1=new JButton();
    JButton button2=new JButton();
    JButton button5=new JButton();
    JLabel labelcomment3=new JLabel();
    
    Random ran=new Random();
    
    boolean run=true;
    
    randomClass(){
        
        if (run){
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Cool app.");
        frame.setSize(530,390);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        labelcomment3.setText("welcome to cool-app :)..");
        labelcomment3.setForeground(Color.red);
        labelcomment3.setFont(new Font(null,Font.BOLD,35));
        labelcomment3.setBounds(50, 20, 400, 50);
        
        button1.setText("login");
        button1.setFocusable(false);
        button1.addActionListener(this);
        button1.setBounds(50, 90, 400, 50);
        button1.setBackground(Color.red);
        button1.setFont(font);
        
        button2.setText("create account");
        button2.setFocusable(false);
        button2.setBounds(50, 160, 400, 50);
        button2.setBackground(Color.green);
        button2.addActionListener(this);
        button2.setFont(font);
        
        button5.setText("about");
        button5.setFocusable(false);
        button5.setBounds(50, 230, 400, 50);
        button5.setBackground(Color.orange);
        button5.addActionListener(this);
        button5.setFont(font);
        
        navigate.add(privacy);
        navigate.add(disclaimer);
        navigate.add(terms);
        navigate.add(report);
        
        menu.add(navigate);
        int z = ran.nextInt(255);
        int x = ran.nextInt(255);
        int y= ran.nextInt(255);
        menu.setBackground(new Color (x,y,z));
        menu.setEnabled(true);
        
        terms.addActionListener(this);
        privacy.addActionListener(this);
        disclaimer.addActionListener(this);
        report.addActionListener(this);
        
        frame.setJMenuBar(menu);
        frame.add(labelcomment3);
        frame.add(button1);
        frame.add(button2);
        frame.add(button5);
        frame.setVisible(true);
        }
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            new login();
            frame.dispose();
        }
        if(e.getSource()==button2){
            new createaccount();
            frame.dispose();
        }
        if(e.getSource()==button5){
            new about();
            frame.dispose();
        }
        if(e.getSource()==terms){
            new pripol();
            frame.dispose();
        }
        if(e.getSource()==privacy){
            new pripol2();
            frame.dispose();
        }
        if(e.getSource()==disclaimer){
            new dis();
            frame.dispose();
        }
        if(e.getSource()==report){
            new bug();
            frame.dispose();
        }
        
    }
    
}