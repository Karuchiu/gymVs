package com.gym;

import java.awt.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Home extends JFrame{

    JPanel heading = new JPanel();
    JLabel homeTitle = new JLabel("Gym Management App");
    JTabbedPane tabbedPane = new JTabbedPane();
    JPanel overviewPanel =new JPanel();
    JPanel memberPanel =new JPanel();
    JPanel financialPanel =new JPanel();
    
     Home(){
        setSize(1050, 780);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        heading.setBounds(0,0,1050,100);
       
        homeTitle.setFont(new Font("Ink Free", Font.ITALIC, 40));
        homeTitle.setBackground(Color.BLUE);

        heading.add(homeTitle);

        //Adding tabbed panes
        tabbedPane.setBounds(0,100,1050,680);
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

      homeButton.setBounds(0, 0, 1050, 100);
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

     }
     
}
