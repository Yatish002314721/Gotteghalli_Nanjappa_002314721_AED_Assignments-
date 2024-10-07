/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import model.Person;
import model.PersonDirectory;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import model.Address;

/**
 *
 *@author USER
 */
public class MainJFrame extends javax.swing.JFrame {

    private PersonDirectory personDirectory;
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private Person person5;
    
    private Address workAddress1;
    private Address homeAddress1;
    
    private Address workAddress2;
    private Address homeAddress2;
    
    private Address workAddress3;
    private Address homeAddress3;
    
    private Address workAddress4;
    private Address homeAddress4;
    
    private Address workAddress5;
    private Address homeAddress5;
    
    private Address workAddress6;
    private Address homeAddress6;
    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
        this.personDirectory = new PersonDirectory();
        this.workAddress1 = new Address();
        this.homeAddress1 = new Address();
        this.workAddress2 = new Address();
        this.homeAddress2 = new Address();
        this.workAddress3 = new Address();
        this.homeAddress3 = new Address();
        this.workAddress4 = new Address();
        this.homeAddress4 = new Address();
        this.workAddress5 = new Address();
        this.homeAddress5 = new Address();
        this.workAddress6 = new Address();
        this.homeAddress6 = new Address();
        
        Person person1 = personDirectory.addPerson();
        person1.setFirstName("Yatish");
        person1.setLastName("Gowda");
        person1.setSsn(1234567);
        person1.setAge(30);
        person1.setHeight(5.8);
        
        workAddress1.setStreetAddress("1175 Boylston Street");
        workAddress1.setUnitNumber("50");
        workAddress1.setCity("Boston");
        workAddress1.setState("MA");
        workAddress1.setZip(02215);
        workAddress1.setPhoneNumber(111111);
        person1.setWorkAddress(workAddress1);
        
        homeAddress1.setStreetAddress("111 tremont street");
        homeAddress1.setUnitNumber("51");
        homeAddress1.setCity("Boston");
        homeAddress1.setState("Massachusetts");
        homeAddress1.setZip(21150);
        homeAddress1.setPhoneNumber(112233);
        person1.setHomeAddress(homeAddress1);
        
        Person person2 = personDirectory.addPerson();
        person2.setFirstName("Kiran");
        person2.setLastName("Gowda");
        person2.setSsn(1234567);
        person2.setAge(31);
        person2.setHeight(5.9);


        workAddress2.setStreetAddress("550 Mission Main St");
        workAddress2.setUnitNumber("1080");
        workAddress2.setCity("Dallas");
        workAddress2.setState("Texas");
        workAddress2.setZip(1234567890);
        workAddress2.setPhoneNumber(12343221);
        person2.setWorkAddress(workAddress2);

        homeAddress2.setStreetAddress("109 germanian street");
        homeAddress2.setUnitNumber("1111");
        homeAddress2.setCity("Mumbai");
        homeAddress2.setState("Maharashtra");
        homeAddress2.setZip(4010304);
        homeAddress2.setPhoneNumber(475836);
        person2.setHomeAddress(homeAddress2);

        // Person 3
        Person person3 = personDirectory.addPerson();
        person3.setFirstName("Pramod");
        person3.setLastName("Pai");
        person3.setSsn(1234-1234-1234);
        person3.setAge(32);
        person3.setHeight(5.10);

        workAddress3.setStreetAddress("41 calument street");
        workAddress3.setUnitNumber("1550");
        workAddress3.setCity("Malden");
        workAddress3.setState("MA");
        workAddress3.setZip(4011001);
        workAddress3.setPhoneNumber(7236475);
        person3.setWorkAddress(workAddress3);


        Address homeAddress3 = new Address();
        homeAddress3.setStreetAddress("9012 Maple St");
        homeAddress3.setUnitNumber("Apt 5B");
        homeAddress3.setCity("Village Town");
        homeAddress3.setState("GA");
        homeAddress3.setZip(13579);
        homeAddress3.setPhoneNumber(83475634);
        person3.setHomeAddress(homeAddress3);

        // Person 4
        Person person4 = personDirectory.addPerson();
        person4.setFirstName("Sachit");
        person4.setLastName("N");
        person4.setSsn(222334444); // Social Security Number should be an integer
        person4.setAge(33);
        person4.setHeight(5.11);

        Address workAddress4 = new Address();
        workAddress4.setStreetAddress("800 Pine St");
        workAddress4.setUnitNumber("Floor 10");
        workAddress4.setCity("City Center");
        workAddress4.setState("IL");
        workAddress4.setZip(24680);
        workAddress4.setPhoneNumber(763457);
        person4.setWorkAddress(workAddress4);

        Address homeAddress4 = new Address();
        homeAddress4.setStreetAddress("3456 Cedar St");
        homeAddress4.setUnitNumber("Unit 15");
        homeAddress4.setCity("Rural Town");
        homeAddress4.setState("NC");
        homeAddress4.setZip(98765);
        homeAddress4.setPhoneNumber(7345637);
        person4.setHomeAddress(homeAddress4);

        // Person 5
        Person person5 = personDirectory.addPerson();
        person5.setFirstName("Hemanth");
        person5.setLastName("Kumar");
        person5.setAge(31);
        person5.setHeight(6.1);

        Address workAddress5 = new Address();
        workAddress5.setStreetAddress("900 Walnut St");
        workAddress5.setUnitNumber("Suite 20");
        workAddress5.setCity("Midtown");
        workAddress5.setState("MI");
        workAddress5.setZip(13579); // Zip code changed to 13579
        workAddress5.setPhoneNumber(1111111111);
        person5.setWorkAddress(workAddress5);

        Address homeAddress5 = new Address();
        homeAddress5.setStreetAddress("6789 Birch St");
        homeAddress5.setUnitNumber("Apt 30");
        homeAddress5.setCity("Coastal City");
        homeAddress5.setState("OR");
        homeAddress5.setZip(2468); // Zip code changed to 2468
        homeAddress5.setPhoneNumber(222222);
        person5.setHomeAddress(homeAddress5);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        topJPanel = new javax.swing.JPanel();
        btnAddPerson = new javax.swing.JButton();
        btnListPersons = new javax.swing.JButton();
        btnSearchPerson = new javax.swing.JButton();
        txtSearchInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        userProcessContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        topJPanel.setBackground(new java.awt.Color(204, 255, 255));
        topJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddPerson.setBackground(new java.awt.Color(0, 102, 102));
        btnAddPerson.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        btnAddPerson.setForeground(new java.awt.Color(0, 0, 51));
        btnAddPerson.setText("Add Person");
        btnAddPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPersonActionPerformed(evt);
            }
        });
        topJPanel.add(btnAddPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 126, 167, -1));

        btnListPersons.setBackground(new java.awt.Color(0, 102, 102));
        btnListPersons.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        btnListPersons.setForeground(new java.awt.Color(0, 0, 51));
        btnListPersons.setText("List Person");
        btnListPersons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListPersonsActionPerformed(evt);
            }
        });
        topJPanel.add(btnListPersons, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 165, 167, -1));

        btnSearchPerson.setBackground(new java.awt.Color(0, 102, 102));
        btnSearchPerson.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        btnSearchPerson.setForeground(new java.awt.Color(0, 0, 51));
        btnSearchPerson.setText("Search for Person");
        btnSearchPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchPersonActionPerformed(evt);
            }
        });
        topJPanel.add(btnSearchPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 330, 167, 37));

        txtSearchInput.setForeground(new java.awt.Color(102, 102, 102));
        txtSearchInput.setText("Type name or street address");
        txtSearchInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchInputFocusLost(evt);
            }
        });
        txtSearchInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchInputActionPerformed(evt);
            }
        });
        topJPanel.add(txtSearchInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 302, 167, -1));

        jLabel1.setBackground(new java.awt.Color(51, 204, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Person Profile");
        topJPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 48, -1, -1));

        jSplitPane1.setTopComponent(topJPanel);

        userProcessContainer.setBackground(new java.awt.Color(204, 204, 204));
        userProcessContainer.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(userProcessContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPersonActionPerformed
        // TODO add your handling code here:
        CreatePersonJPanel panel = new CreatePersonJPanel(userProcessContainer, personDirectory);
        userProcessContainer.add("CreatePersonJPanel", panel);
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnAddPersonActionPerformed

    private void btnListPersonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListPersonsActionPerformed
        // TODO add your handling code here:
        ManagePersonJPanel panel = new ManagePersonJPanel(userProcessContainer, personDirectory);
        
        userProcessContainer.add("ManagePersonJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnListPersonsActionPerformed

    private void btnSearchPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchPersonActionPerformed
        
        Person result = personDirectory.searchPerson(txtSearchInput.getText());
        
        if("".equals(txtSearchInput.getText())) {
            JOptionPane.showMessageDialog(null, "Please enter a first name/last name or street address!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else {
            if(result == null) {
                JOptionPane.showMessageDialog(null, "Person does not exist!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                Address workResult = result.getWorkAddress();
                Address homeResult = result.getHomeAddress();
        
                ViewPersonJPanel panel = new ViewPersonJPanel(userProcessContainer, result, workResult, homeResult);
                userProcessContainer.add("ViewPersonJPanel", panel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }
        }
    }//GEN-LAST:event_btnSearchPersonActionPerformed

    private void txtSearchInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchInputActionPerformed

    private void txtSearchInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchInputFocusGained
        // TODO add your handling code here:
        if(txtSearchInput.getText().equalsIgnoreCase("Type name or street address"))
        {
            txtSearchInput.setText("");
            txtSearchInput.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_txtSearchInputFocusGained

    private void txtSearchInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchInputFocusLost
        // TODO add your handling code here:
        if(txtSearchInput.getText().equalsIgnoreCase(""))
        {
            txtSearchInput.setText("Type name or street address");
            txtSearchInput.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_txtSearchInputFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPerson;
    private javax.swing.JButton btnListPersons;
    private javax.swing.JButton btnSearchPerson;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel topJPanel;
    private javax.swing.JTextField txtSearchInput;
    private javax.swing.JPanel userProcessContainer;
    // End of variables declaration//GEN-END:variables
}
