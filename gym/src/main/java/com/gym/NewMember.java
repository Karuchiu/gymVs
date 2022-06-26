package com.gym;

import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NewMember extends JFrame implements ActionListener{
    Connection conn = null;
    Statement stat = null;
    ResultSet rSet = null;

    NewMember(){
        nmComps();

        conn = (Connection) Connectivity.openConnection();
    }

    public void nmComps(){
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        nmPanel.setBounds(0,0,800,70);
        nmTitle.setFont(new Font("Ink Free", Font.ITALIC, 40));
        nmTitle.setBackground(Color.BLUE);
        nmPanel.add(nmTitle);

        clearButton.setBounds(100,410,180,30);
        dbButton.setBounds(100,450,180,30);
        backButton.setBounds(100,490,180,30);
        backButton.addActionListener(this);
        dbButton.addActionListener(this);
        clearButton.addActionListener(this);

        nmPanel1Comps();
        nmPanel2Comps();
        nmPanel3Comps();

        add(nmPanel);
        add(nmPanel1);
        add(nmPanel2);
        add(nmPanel3);
        add(clearButton);
        add(dbButton);
        add(backButton);
        setVisible(true);
    }

    JPanel nmPanel = new JPanel();
    JLabel nmTitle = new JLabel("Add New Member");
    JPanel nmPanel1 = new JPanel();
    JPanel nmPanel2 = new JPanel();
    JPanel nmPanel3 = new JPanel();
    JButton clearButton = new JButton("Clear All Text Fields");
    JButton dbButton = new JButton("Add to the Database");
    JButton backButton = new JButton("Back");

    JTextField idField, nameField, NICField, contactField, addressField, emailField, emecField, receiptField, heightField, weightField;
    JComboBox<String> categoryBox, planBox;
    ButtonGroup genderGroup;
    JTextArea remarksArea;

    JRadioButton male , female;

    private void nmPanel1Comps(){
        nmPanel1.setBounds(10,70,350,320);
        nmPanel1.setBorder(BorderFactory.createLineBorder(Color.black));
        nmPanel1.setLayout(null);

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel NICLabel = new JLabel("NIC:");
        NICField = new JTextField();
        JLabel contactLabel = new JLabel("Contact:");
        contactField = new JTextField();
        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        JLabel emecLabel = new JLabel("Emergency Contact:");
        emecField = new JTextField();

        idLabel.setBounds(10,20,150,30);
        idField.setBounds(160,20,150,30);
        nameLabel.setBounds(10,60,150,30);
        nameField.setBounds(160,60,150,30);
        NICLabel.setBounds(10,100,150,30);
        NICField.setBounds(160,100,150,30);
        contactLabel.setBounds(10,140,150,30);
        contactField.setBounds(160,140,150,30);
        addressLabel.setBounds(10,180,150,30);
        addressField.setBounds(160,180,150,30);
        emailLabel.setBounds(10,220,150,30);
        emailField.setBounds(160,220,150,30);
        emecLabel.setBounds(10,260,150,30);
        emecField.setBounds(160,260,150,30);

        nmPanel1.add(idLabel);
        nmPanel1.add(idField);
        nmPanel1.add(nameLabel);
        nmPanel1.add(nameField);
        nmPanel1.add(NICLabel);
        nmPanel1.add(NICField);
        nmPanel1.add(contactLabel);
        nmPanel1.add(contactField);
        nmPanel1.add(addressLabel);
        nmPanel1.add(addressField);
        nmPanel1.add(emailLabel);
        nmPanel1.add(emailField);
        nmPanel1.add(emecLabel);
        nmPanel1.add(emecField);
    }

    private void nmPanel2Comps(){
        nmPanel2.setBounds(365,70,400,150);
        nmPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
        nmPanel2.setLayout(null);

        String [] memberCategory= {"Select", "HIITs", "Aerobics", "Anaesthetics"};
        String [] paymentPlan = {"Select", "Weekly", "1 Month", "3 Months", "6 Months"};

        JLabel category = new JLabel("Membership Category:");
        categoryBox = new JComboBox<String>(memberCategory);
        JLabel receipt = new JLabel("Receipt No:");
        receiptField = new JTextField();
        JLabel plan = new JLabel("Payment Plan:");
        planBox = new JComboBox<String>(paymentPlan);

        category.setBounds(15,20,150,30);
        categoryBox.setBounds(170,20,200,30);
        receipt.setBounds(15,60,150,30);
        receiptField.setBounds(170,60,200,30);
        plan.setBounds(15,100,150,30);
        planBox.setBounds(170,100,200,30);

        categoryBox.setSelectedIndex(0);
        planBox.setSelectedIndex(0);
        
        nmPanel2.add(category);
        nmPanel2.add(categoryBox);
        nmPanel2.add(receipt);
        nmPanel2.add(receiptField);
        nmPanel2.add(plan);
        nmPanel2.add(planBox);
    }

    private void nmPanel3Comps(){
        nmPanel3.setBounds(365,225,400,320);
        nmPanel3.setBorder(BorderFactory.createLineBorder(Color.black));
        nmPanel3.setLayout(null);

        JLabel gender = new JLabel("Gender:");
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        JLabel height = new JLabel("Height:");
        heightField = new JTextField();
        JLabel m = new JLabel("m");
        JLabel weight = new JLabel("Weight:");
        weightField = new JTextField();
        JLabel kg = new JLabel("kg");
        JLabel remarks = new JLabel("Remarks:");
        remarksArea = new JTextArea();
        remarksArea.setLineWrap(true);
        remarksArea.setWrapStyleWord(true);

        genderGroup.add(male);
        genderGroup.add(female);

        gender.setBounds(15,20,100,30);
        male.setBounds(125,20,80,30);
        female.setBounds(210,20,80,30);
        height.setBounds(15,60,100,30);
        heightField.setBounds(125,60,120,30);
        m.setBounds(250,60,20,30);
        weight.setBounds(15,100,100,30);
        weightField.setBounds(125,100,120,30);
        kg.setBounds(250,100,20,30);
        remarks.setBounds(15,140,100,30);
        remarksArea.setBounds(125,140,250,150);

        nmPanel3.add(gender);
        nmPanel3.add(male);
        nmPanel3.add(female);
        nmPanel3.add(height);
        nmPanel3.add(heightField);
        nmPanel3.add(m);
        nmPanel3.add(weight);
        nmPanel3.add(weightField);
        nmPanel3.add(kg);
        nmPanel3.add(remarks);
        nmPanel3.add(remarksArea);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton){
           setVisible(false);
           Home home = new Home();
           home.setVisible(true); 
        }
        
        if (e.getSource() == clearButton) {
            idField.setText("");
            nameField.setText("");
            NICField.setText("");
            contactField.setText("");
            addressField.setText("");
            emailField.setText("");
            emecField.setText("");
            categoryBox.setSelectedIndex(0);
            receiptField.setText("");
            planBox.setSelectedIndex(0);
            genderGroup.clearSelection();
            heightField.setText("");
            weightField.setText("");
            remarksArea.setText(" ");
        }

        if(e.getSource() == dbButton){
            try{
                int id = Integer.valueOf(idField.getText());
                String name = nameField.getText();
                String nic = NICField.getText();
                int contact = Integer.valueOf(contactField.getText());
                String address = addressField.getText();
                String email = emailField.getText();
                int emergencyc = Integer.valueOf(emecField.getText());
                String memcategory =  (String) categoryBox.getSelectedItem();
                String receiptno = receiptField.getText();
                String payplan = (String) planBox.getSelectedItem();
                String gender = genderGroup.getSelection().getActionCommand();
                //male.setActionCommand("Male");
                //female.setActionCommand("Female");

                if(male.isSelected()){
                    gender = "Male";
                } else if(female.isSelected()){
                    gender = "Female";
                }

                String height = heightField.getText();
                String weight = weightField.getText();
                String remarks = remarksArea.getText();

                stat = conn.createStatement();
                String sql = "insert into addmember Values('"+id+"', '"+name+"', '"+nic+"','"+contact+"','"+address+"','"+email+"','"+emergencyc+"','"+memcategory+"', '"+receiptno+"','"+payplan+"', '"+gender+"', '"+height+"', '"+weight+"', '"+remarks+"')";
                stat.executeUpdate(sql); // executeUpdate?
                JOptionPane.showMessageDialog(null, "Data added successfully");

                }
                catch(Exception ex){
                    ex.printStackTrace();
                }

                
                
        }
        
    }

}
