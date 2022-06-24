package com.gym;


import java.awt.*;

import java.sql.Connection;
import java.sql.*;
import java.awt.event.*;

import javax.swing.*;


/**
 * 
 * @author Karuchiu
 */

public class Login extends JFrame implements ActionListener{
    
    Connection conn = null;
    Statement stmt = null;
    ResultSet rSet = null;

    String username;
    String password;
   

    Login(){
        inComponents();
        
        conn = Connectivity.openConnection();
    }

   public void actionPerformed(ActionEvent event){
        if(event.getSource() == button){
            try {
                stmt = conn.createStatement();
                username = userField.getText();
                password = String.valueOf(passwordField.getPassword()) ;

                String sql = "select * from login where Name = '"+username+"' && Password = '"+password+"' ";
                rSet = stmt.executeQuery(sql);

                if(rSet.next()){
                    setVisible(false);
                    Home fHome = new Home();
                    fHome.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Enter correct details");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
       
    }

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    
    //ClassLoader loader = this.getClass().getClassLoader();
    //java.net.URL gymIconURL = loader.getResource("/images/ufg.png");
    ImageIcon gymIcon = new ImageIcon("K:/ufg.png");
    JLabel label1 = new JLabel(gymIcon);

    ImageIcon gymLogo = new ImageIcon("K:/ufglogo.jpg");
    JLabel label2 = new JLabel(gymLogo);

    JLabel userLabel = new JLabel("Username: ");
    JLabel passLabel = new JLabel("Password: ");
    JTextField userField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton button = new JButton("LOG IN");
    Font myFont = new Font("Tahoma", Font.PLAIN, 20);

    private void inComponents(){
        setSize(900, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        panel1.setBounds(0,0,450,450);
        panel1.setBackground(Color.WHITE);
        
        panel2.setBounds(450,0,450,450);
        panel2.setLayout(null);
        panel2.setBackground(Color.WHITE);

        panel1.add(label1);
        panel2.add(label2);
        panel2.add(userLabel);
        panel2.add(userField);
        panel2.add(passLabel);
        panel2.add(passwordField);
        panel2.add(button);

        label2.setBounds(75,10,300,160);
        userLabel.setBounds(100,180,250,30);
        userField.setBounds(100,211,250,30);
        passLabel.setBounds(100,240,250,30);
        passwordField.setBounds(100,271,250,30);
        button.setBounds(175,308,100,30);
        button.addActionListener(this);

        button.setFocusable(false);
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);

        userLabel.setFont(myFont);
        passLabel.setFont(myFont);
        button.setFont(myFont);

        add(panel1);
        add(panel2);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main( String[] args )
    {
        new Login();
    }
}
