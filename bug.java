package randomproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class bug  implements ActionListener{

    JFrame aframe=new JFrame();
    JButton back=new JButton("back");
    JButton submit=new JButton("submit report");
    JLabel l1=new JLabel("     sory if your having any bug issues.  ");
    JLabel l2=new JLabel("   kindly describe your bug in detail. our");
    JLabel l3=new JLabel("support team will fix as soon as possible.");
    JTextField bugt=new JTextField();
    
    bug(){
        
        aframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        aframe.setSize(355, 200);
        aframe.setTitle("cool-app-> privacy policy. ");
        aframe.setLocationRelativeTo(null);
        aframe.setResizable(false);
        aframe.setLayout(null);
        aframe.getContentPane().setBackground(Color.black);
        
        back.setBounds(10, 130, 80, 25);
        submit.setBounds(200, 130, 130, 25);
        back.setBackground(Color.red);
        submit.setBackground(Color.green);
        back.setFocusable(false);
        submit.setFocusable(false);
        back.addActionListener(this);
        submit.addActionListener(this);
        
        l1.setBounds(10, 10, 340, 24);
        l2.setBounds(10, 33, 340, 24);
        l3.setBounds(3, 56, 340, 24);
        
        l1.setForeground(Color.yellow);
        l2.setForeground(Color.yellow);
        l3.setForeground(Color.yellow);
        
        l1.setFont(new Font(null,Font.BOLD,17));
        l2.setFont(new Font(null,Font.BOLD,17));
        l3.setFont(new Font(null,Font.BOLD,17));
        
        bugt.setBounds(10, 90, 320, 34);
        bugt.setFont(new Font(null,Font.BOLD,15));
        bugt.addActionListener(this);
        
        aframe.add(bugt);
        aframe.add(l1);
        aframe.add(l2);
        aframe.add(l3);
        aframe.add(back);
        aframe.add(submit);
        aframe.setVisible(true);
        
    }
    public void checkbox(){
        String subtxt=bugt.getText();
        if(subtxt.contentEquals("")){
            JOptionPane.showMessageDialog(null,"cannot submit empty report");
        }
        else{
            JOptionPane.showMessageDialog(null,"bug reported succesfully");
            new randomClass();
        aframe.dispose();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
        new randomClass();
        aframe.dispose();
        }
        if(e.getSource()==submit){
            checkbox();
        }
    }
}