package com.gym;

import java.awt.*;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Home extends JFrame{

    JPanel heading = new JPanel();
    JLabel homeTitle = new JLabel("Gym Management App");
    JTabbedPane tabbedPane = new JTabbedPane();
    JPanel overviewPanel =new JPanel();
    JPanel memberPanel =new JPanel();
    JPanel financialPanel =new JPanel();
    
     Home(){
        setSize(1100, 680);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        heading.setBounds(0,0,1050,70);
       
        homeTitle.setFont(new Font("Ink Free", Font.ITALIC, 40));
        homeTitle.setBackground(Color.BLUE);

        heading.add(homeTitle);

        //Adding tabbed panes
        tabbedPane.setBounds(0,100,1100,610);
        tabbedPane.addTab("Overview", overviewPanel);
        tabbedPane.addTab("Get Member Info", memberPanel);
        tabbedPane.addTab("Financial Details", financialPanel);

        overviewPanelComps();
        memberPanelComps();

        add(heading);
        add(tabbedPane);

        setVisible(true);
     }

     private void overviewPanelComps(){
      JButton homeButton = new JButton("Add New Member");
      JLabel homLabel =new JLabel("At a glance...");
    
      //creating a table
      String[] columns = {"ID", "Name", "Contact number", "Registered on", "Registered By"};
      int numrows = 5;
      //  Object[][] row = {{"", "","","",""}, {"", "","","",""}, {"", "","","",""}, {"", "","","",""}, {"", "","","",""}, {"", "","","",""},};
      DefaultTableModel tableModel = new DefaultTableModel(numrows, columns.length);
      JTable homTable = new JTable(tableModel);
      JScrollPane scrollPane = new JScrollPane(homTable);

      JLabel dateLabel = new JLabel("Date");
      JLabel timeLabel = new JLabel("Time");

      homeButton.setBounds(0, 0, 1100, 100);
      homeButton.setBackground(new Color(173,216,230));;
      homeButton.setFont(new Font("Arial", Font.BOLD, 30));
      homeButton.setFocusable(false);

      homLabel.setBounds(10, 110, 200, 30);
      homLabel.setFont(new Font("Arial", Font.ROMAN_BASELINE, 20));

      scrollPane.setBounds(10,150,1020,230);
      homTable.setRowHeight(40);
      tableModel.setColumnIdentifiers(columns);
      
      dateLabel.setBounds(15, 400, 50, 20);
      timeLabel.setBounds(120, 400, 50, 20);
      
      overviewPanel.setLayout(null);

      overviewPanel.add(homeButton);
      overviewPanel.add(homLabel);
      overviewPanel.add(scrollPane);
      overviewPanel.add(dateLabel);
      overviewPanel.add(timeLabel);
     }

     private void memberPanelComps(){

         TitledBorder title1, title2;
         JPanel panel1 = new JPanel();
         JPanel panel2 = new JPanel();
         JPanel panel3 = new JPanel();
         JPanel panel4 = new JPanel();
         JPanel panel5 = new JPanel();
         JButton button2 = new JButton("Update Member");
         JButton button3 = new JButton("Delete Member");

         panel1.setBounds(0,0,700,110);

         JLabel label1 = new JLabel("Enter a valid ID to get related member information");
         JLabel label2 = new JLabel("Membership ID: ");
         JTextField txtField1 = new JTextField();
         JButton button1 = new JButton("Search");
        
         panel1.add(label1);
         panel1.add(label2);
         panel1.add(txtField1);
         panel1.add(button1);

         panel2.setBounds(0,110,700,140);
         panel2.setBorder(BorderFactory.createLineBorder(Color.black));

         panel3.setBounds(710,0,370,250);
         title1 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Basic Details");
         title1.setTitleJustification(TitledBorder.LEFT);
         panel3.setBorder(title1);

         panel4.setBounds(340,250,350,265);
         title2 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Body Statistics");
         title2.setTitleJustification(TitledBorder.LEFT);
         panel4.setBorder(title2);

         panel5.setBounds(710,250,370,265);
         panel5.setBorder(BorderFactory.createLineBorder(Color.black));

         button2.setBounds(100, 300, 150, 40);
         button3.setBounds(100, 360, 150, 40);

         memberPanel.setLayout(null);

         memberPanel.add(panel1);
         memberPanel.add(panel2);
         memberPanel.add(panel3);
         memberPanel.add(panel4);
         memberPanel.add(panel5);
         memberPanel.add(button2);
         memberPanel.add(button3);
     }
     
}
