package randomproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class dis  implements ActionListener{

    JFrame aframe=new JFrame();
    JButton back=new JButton("back");
    JLabel l1=new JLabel("  ----------------dear user?-----------------");
    JLabel l2=new JLabel("   once your account is disabled due to");
    JLabel l3=new JLabel("    irrelevant behaviors, you can not  ");
    JLabel l4=new JLabel("     be able to recover. so be sure    ");
    JLabel l5=new JLabel("   to follow the terms and conditions. ");
    JLabel l6=new JLabel("       for more information, please    ");
    JLabel l7=new JLabel("   contact +254704935355. feel at home.");
    JLabel l8=new JLabel("                   copyright @liudkido 2023     ");
    JLabel l9=new JLabel("                         all rights reserved         ");
    
    dis(){
        
        aframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        aframe.setSize(355, 300);
        aframe.setTitle("cool-app-> disclaimer.");
        aframe.setLocationRelativeTo(null);
        aframe.setResizable(false);
        aframe.setLayout(null);
        aframe.getContentPane().setBackground(Color.black);
        
        back.setBounds(10, 230, 80, 25);
        back.setBackground(Color.red);
        back.setFocusable(false);
        back.addActionListener(this);
        
        l1.setBounds(10, 10, 340, 24);
        l2.setBounds(10, 33, 340, 24);
        l3.setBounds(3, 56, 340, 24);
        l4.setBounds(10, 79, 340, 24);
        l5.setBounds(10, 102, 340, 24);
        l6.setBounds(10, 125, 340, 24);
        l7.setBounds(10, 148, 340, 24);
        l8.setBounds(10, 171, 340, 24);
        l9.setBounds(10, 194, 340, 24);
        
        l1.setForeground(Color.yellow);
        l2.setForeground(Color.yellow);
        l3.setForeground(Color.yellow);
        l4.setForeground(Color.yellow);
        l5.setForeground(Color.yellow);
        l6.setForeground(Color.yellow);
        l7.setForeground(Color.yellow);
        l8.setForeground(Color.blue);
        l9.setForeground(Color.red);
        
        l1.setFont(new Font(null,Font.BOLD,17));
        l2.setFont(new Font(null,Font.BOLD,17));
        l3.setFont(new Font(null,Font.BOLD,17));
        l4.setFont(new Font(null,Font.BOLD,17));
        l5.setFont(new Font(null,Font.BOLD,17));
        l6.setFont(new Font(null,Font.BOLD,17));
        l7.setFont(new Font(null,Font.BOLD,17));
        l8.setFont(new Font(null,Font.ITALIC,15));
        l9.setFont(new Font(null,Font.ITALIC,15));
        
        aframe.add(l1);
        aframe.add(l2);
        aframe.add(l3);
        aframe.add(l4);
        aframe.add(l5);
        aframe.add(l6);
        aframe.add(l7);
        aframe.add(l8);
        aframe.add(l9);
        aframe.add(back);
        aframe.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
        new randomClass();
        aframe.dispose();
        }
    }
}