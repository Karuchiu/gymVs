package com.gym;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;


public class Home extends JFrame implements ActionListener{

    Connection conn;
    Statement statement = null;
    Resultset rset;

    JPanel heading = new JPanel();
    JLabel homeTitle = new JLabel("Gym Management App");
    JTabbedPane tabbedPane = new JTabbedPane();
    JPanel overviewPanel =new JPanel();
    JPanel memberPanel =new JPanel();
    JPanel financialPanel =new JPanel();
    JButton homeButton, searchId;
    JTextField searchIdField, memEmerg, memName, memNic, memContact, memAddress, memEmail, memGender, memHeight, memWeight, memBmi, memCategory, memId, regOn, regBy, memReceipt, memPayplan, memUpdate;
    JTextArea memRemarks;
    
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
        financialPanelComps();

        add(heading);
        add(tabbedPane);

        conn = Connectivity.openConnection();

        setVisible(true);
     }

      void overviewPanelComps(){
      homeButton = new JButton("Add New Member");
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
      homeButton.addActionListener(this);

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

         //PANEL 1
         panel1.setBounds(0,0,700,110);
         panel1.setLayout(null);

         JLabel label1 = new JLabel("Enter a valid ID to get related member information");
         JLabel label2 = new JLabel("Membership ID: ");
         searchIdField = new JTextField();
         searchId = new JButton("Search");

         label1.setBounds(5,5,600,40);
         label2.setBounds(15,60,100,30);
         searchIdField.setBounds(120,60,180,30);
         searchId.setBounds(350,60,100,30);
        
         panel1.add(label1);
         panel1.add(label2);
         panel1.add(searchIdField);
         panel1.add(searchId);

         //PANEL 2
         panel2.setBounds(0,110,700,140);
         panel2.setBorder(BorderFactory.createLineBorder(Color.black));
         panel2.setLayout(null);

         JLabel label3 = new JLabel("In case of an emergency");
         JLabel label4 = new JLabel("Emergency contact:");
         memEmerg = new JTextField();

         label3.setBounds(20,20,300,30);
         label4.setBounds(100,70,150,40);
         memEmerg.setBounds(270,70,180,40);

         panel2.add(label3);
         panel2.add(label4);
         panel2.add(memEmerg);

         //PANEL 3
         panel3.setBounds(710,0,370,250);
         title1 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Basic Details");
         title1.setTitleJustification(TitledBorder.LEFT);
         panel3.setBorder(title1);
         panel3.setLayout(null);

         JLabel label5 = new JLabel("Name:");
         JLabel label6 = new JLabel("NIC:");
         JLabel label7 = new JLabel("Contact number:");
         JLabel label8 = new JLabel("Address:");
         JLabel label9 = new JLabel("Email Address:");
         memName = new JTextField();
         memNic = new JTextField();
         memContact = new JTextField();
         memAddress = new JTextField();
         memEmail = new JTextField();

         label5.setBounds(10,30,150,20);
         memName.setBounds(165,30,150,20);
         label6.setBounds(10,70,150,20);
         memNic.setBounds(165,70,150,20);
         label7.setBounds(10,110,150,20);
         memContact.setBounds(165, 110,150,20);
         label8.setBounds(10,150,150,20);
         memAddress.setBounds(165,150,150,20);
         label9.setBounds(10,190,150,20);
         memEmail.setBounds(165,190,150,20);

         panel3.add(label5);
         panel3.add(label6);
         panel3.add(label7);
         panel3.add(label8);
         panel3.add(label9);
         panel3.add(memName);
         panel3.add(memNic);
         panel3.add(memContact);
         panel3.add(memAddress);
         panel3.add(memEmail);

         //PANEL 4
         panel4.setBounds(340,250,350,265);
         title2 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Body Statistics");
         title2.setTitleJustification(TitledBorder.LEFT);
         panel4.setBorder(title2);
         panel4.setLayout(null);

         JLabel jLabel1 = new JLabel("Gender:");
         JLabel jlabel2 = new JLabel("Height:");
         JLabel jlabel3 = new JLabel("Weight:");
         JLabel jlabel4 = new JLabel("BMI:");
         JLabel jlabel5 = new JLabel("Remarks:");
         memGender = new JTextField();
         memHeight = new JTextField();
         memWeight = new JTextField();
         memBmi = new JTextField();
         memRemarks = new JTextArea(5,40);

         jLabel1.setBounds(10,30,150,20);
         memGender.setBounds(165,30,150,20);
         jlabel2.setBounds(10,70,150,20);
         memHeight.setBounds(165,70,150,20);
         jlabel3.setBounds(10,110,150,20);
         memWeight.setBounds(165, 110,150,20);
         jlabel4.setBounds(10,150,150,20);
         memBmi.setBounds(165,150,150,20);
         jlabel5.setBounds(10,190,150,20);
         memRemarks.setBounds(165,190,150,60);
         memRemarks.setLineWrap(true);
         memRemarks.setWrapStyleWord(true);

         panel4.add(jLabel1);
         panel4.add(jlabel2);
         panel4.add(jlabel3);
         panel4.add(jlabel4);
         panel4.add(jlabel5);
         panel4.add(memGender);
         panel4.add(memHeight);
         panel4.add(memWeight);
         panel4.add(memBmi);
         panel4.add(memRemarks);

         //PANEL 5
         panel5.setBounds(710,250,370,265);
         panel5.setBorder(BorderFactory.createLineBorder(Color.black));
         panel5.setLayout(null);

         JLabel labelField1 = new JLabel("Membership Category:");
         JLabel labelField2 = new JLabel("Membership ID:");
         JLabel labelField3 = new JLabel("Registered On:");
         JLabel labelField4 = new JLabel("Registered By:");
         JLabel labelField5 = new JLabel("Receipt No:");
         JLabel labelField6 = new JLabel("Payment Plan:");
         JLabel labelField7 = new JLabel("Last updated on:");
         memCategory = new JTextField();
         memId = new JTextField();
         regOn = new JTextField();
         regBy = new JTextField();
         memReceipt = new JTextField();
         memPayplan = new JTextField();
         memUpdate = new JTextField();

         labelField1.setBounds(10,10,150,20);
         memCategory.setBounds(165,10,150,20);
         labelField2.setBounds(10,45,150,20);
         memId.setBounds(165,45,150,20);
         labelField3.setBounds(10,85,150,20);
         regOn.setBounds(165,85,150,20);
         labelField4.setBounds(10,125,150,20);
         regBy.setBounds(165,125,150,20);
         labelField5.setBounds(10,165,150,20);
         memReceipt.setBounds(165,165,150,20);
         labelField6.setBounds(10,205,150,20);
         memPayplan.setBounds(165,205,150,20);
         labelField7.setBounds(10,240,150,20);
         memUpdate.setBounds(165,240,150,20);

         panel5.add(labelField1);
         panel5.add(memCategory);
         panel5.add(labelField2);
         panel5.add(memId);
         panel5.add(labelField3);
         panel5.add(regOn);
         panel5.add(labelField4);
         panel5.add(regBy);
         panel5.add(labelField5);
         panel5.add(memReceipt);
         panel5.add(labelField6);
         panel5.add(memPayplan);
         panel5.add(labelField7);
         panel5.add(memUpdate);
         
         //End of Panels!

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

     private void financialPanelComps(){
        JLabel fLabel = new JLabel("Payment Details");
        TitledBorder fBorder;
        fLabel.setBounds(20,20,200,40);


        JPanel fPanel = new JPanel();

        fPanel.setBounds(20,100,400,400);
        fBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Add Payment to the Database");
        fBorder.setTitleJustification(TitledBorder.LEFT);
        fPanel.setBorder(fBorder);
        fPanel.setLayout(null);

        JLabel flabel1 = new JLabel("Membership ID:");
        JTextField fTextField = new JTextField();
        JButton fButton = new JButton("Check name related to ID");
        JLabel fLabel2 = new JLabel("Payment                    Kshs");
        JTextField fmemId = new JTextField();
        JLabel fLabel3 = new JLabel("/=");
        JLabel fLabel4 = new JLabel("Receipt No:");
        JTextField fTexmemWeight = new JTextField();
        JButton fButton2 = new JButton("Submit");

        String[] fColumns = {"ID", "Count", "Receipt No", "Payment", "Date", "Added By"};
        int fNumrows = 0;
        DefaultTableModel fTableModel = new DefaultTableModel(fNumrows, fColumns.length);
        JTable finTable = new JTable(fTableModel);
        JScrollPane fScrollPane = new JScrollPane(finTable);
        finTable.setRowHeight(30);
        fTableModel.setColumnIdentifiers(fColumns);

        flabel1.setBounds(20,25,100,30);
        fTextField.setBounds(150, 25,200,30);
        fButton.setBounds(20,100,350,50);
        fLabel2.setBounds(20,180,150,30);
        fmemId.setBounds(200,180,100,30);
        fLabel3.setBounds(310,180,30,30);
        fLabel4.setBounds(20,250,100,30);
        fTexmemWeight.setBounds(150,250,200,30);
        fButton2.setBounds(20,320,350,50);
        fScrollPane.setBounds(430,100,650,400);

        fPanel.add(flabel1);
        fPanel.add(fTextField);
        fPanel.add(fButton);
        fPanel.add(fLabel2);
        fPanel.add(fmemId);
        fPanel.add(fLabel3);
        fPanel.add(fLabel4);
        fPanel.add(fTexmemWeight);
        fPanel.add(fButton2);

        financialPanel.setLayout(null);
        financialPanel.add(fLabel);
        financialPanel.add(fPanel);
        financialPanel.add(fScrollPane);
     }

   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == homeButton){
         setVisible(false);
         NewMember nm = new NewMember();
         nm.setVisible(true);
      }      

      if(e.getSource() == searchId){
         try {
            statement = conn.createStatement();
            String memberId = searchIdField.getText();
            String sql = "select * from addmember where Id = '"+memberId+"'";
         } catch (Exception exc) {
            //TODO: handle exception
         }
      }
   }
}
