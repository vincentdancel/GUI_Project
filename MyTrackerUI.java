package view;

import util.MySQLConnector;
import Controller.TrackerController;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.List;

public class MyTrackerUI extends javax.swing.JFrame {

    private DefaultTableModel dtm = new DefaultTableModel(
            new String[]{"Number", "Month", "Category", "Money Spend"}, 99);

    public MyTrackerUI() {
        initComponents();
        loadTrackerList();
    }

    private void loadTrackerList() {
        TrackerController p = new TrackerController();
        ResultSet rs = p.getTrackerList();
        dtm.setRowCount(0);

        if (rs != null) {

            try {

                while (rs.next()) {
                    ArrayList row = new ArrayList(4);
                    row.add(rs.getString("Number"));
                    row.add(rs.getString("Month"));
                    row.add(rs.getString("Category"));
                    row.add(rs.getString("Money_Spend"));

                    dtm.addRow(row.toArray());

                }
                tableTracker.setModel(dtm);
            } catch (SQLException ex) {
                Logger.getLogger(MyTrackerUI.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                } catch (SQLException e) {
                    Logger.getLogger(MyTrackerUI.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        tableTracker.setModel(dtm);

    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AddDialog = new javax.swing.JDialog();
        txtMONEYSPEND = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSAVE = new javax.swing.JButton();
        comboMONTH = new javax.swing.JComboBox<>();
        comboCATEGORY = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTracker = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        btnADD = new javax.swing.JButton();
        btnDELETE = new javax.swing.JButton();
        btnTOTAL = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextArea2 = new javax.swing.JTextArea();

        AddDialog.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMONEYSPEND.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        txtMONEYSPEND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMONEYSPENDActionPerformed(evt);
            }
        });
        AddDialog.getContentPane().add(txtMONEYSPEND, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 140, 30));

        jLabel8.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 204));
        jLabel8.setText("CATEGORY:");
        AddDialog.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        jLabel9.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 255));
        jLabel9.setText("MONEY SPEND:");
        AddDialog.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        jLabel7.setBackground(new java.awt.Color(0, 51, 204));
        jLabel7.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 204));
        jLabel7.setText("MONTH:");
        AddDialog.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        btnSAVE.setBackground(new java.awt.Color(204, 204, 204));
        btnSAVE.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        btnSAVE.setText("SAVE");
        btnSAVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSAVEActionPerformed(evt);
            }
        });
        AddDialog.getContentPane().add(btnSAVE, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 70, 30));

        comboMONTH.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        comboMONTH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        comboMONTH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMONTHActionPerformed(evt);
            }
        });
        AddDialog.getContentPane().add(comboMONTH, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 140, 30));

        comboCATEGORY.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        comboCATEGORY.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Housing", "Transportation", "Food", "Health and Wellness", "Personal Care", "Entertainment and Recreation", "Education", "Savings and Investments", "Debt Payments", "Gifts and Donations", "Insurance", "Miscellaneous", "Childcare", "Travel and Vacations", "Pets", "Subscriptions", "Technology and Gadgets", "Professional Development", "Legal and Administrative Fees", "Taxes", "Emergency Expenses", "Events and Celebrations" }));
        comboCATEGORY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCATEGORYActionPerformed(evt);
            }
        });
        AddDialog.getContentPane().add(comboCATEGORY, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 140, 30));

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Bold", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("PERSONAL EXPENSES TRACKER");
        AddDialog.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 290, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/download-removebg-preview.png"))); // NOI18N
        AddDialog.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-110, -80, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Download Folha A4 Com Linhas Para Imprimir Pdf - Vrogue 833.jpg"))); // NOI18N
        jLabel4.setText("jLabel1");
        AddDialog.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 450, 310));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableTracker.setBackground(new java.awt.Color(204, 204, 204));
        tableTracker.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 51, 204)));
        tableTracker.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 10)); // NOI18N
        tableTracker.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Number", "Month", "Category", "Money Spend"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTracker.setGridColor(new java.awt.Color(0, 0, 204));
        tableTracker.setSelectionBackground(new java.awt.Color(0, 51, 255));
        tableTracker.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableTracker.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tableTracker.setShowGrid(true);
        tableTracker.getTableHeader().setReorderingAllowed(false);
        tableTracker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTrackerMouseClicked(evt);
            }
        });
        tableTracker.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableTrackerKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableTracker);
        if (tableTracker.getColumnModel().getColumnCount() > 0) {
            tableTracker.getColumnModel().getColumn(0).setResizable(false);
            tableTracker.getColumnModel().getColumn(1).setResizable(false);
            tableTracker.getColumnModel().getColumn(2).setResizable(false);
            tableTracker.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 360, 430));

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, 70, 20));

        btnADD.setBackground(new java.awt.Color(204, 204, 204));
        btnADD.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        btnADD.setText("ADD");
        btnADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDActionPerformed(evt);
            }
        });
        getContentPane().add(btnADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, -1, -1));

        btnDELETE.setBackground(new java.awt.Color(204, 204, 204));
        btnDELETE.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 10)); // NOI18N
        btnDELETE.setText("DELETE SELECTED ROWS");
        btnDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELETEActionPerformed(evt);
            }
        });
        getContentPane().add(btnDELETE, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, -1, -1));

        btnTOTAL.setBackground(new java.awt.Color(204, 204, 204));
        btnTOTAL.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        btnTOTAL.setText("CLICK TOTAL:");
        btnTOTAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTOTALActionPerformed(evt);
            }
        });
        getContentPane().add(btnTOTAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, -1, -1));

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("PERSONAL EXPENSES TRACKER");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 370, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/download-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-110, -70, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Download Folha A4 Com Linhas Para Imprimir Pdf - Vrogue 833.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, -10, 520, 610));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("rgrrgrgr");
        getContentPane().add(jTextArea2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboCATEGORYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCATEGORYActionPerformed

        String selectedCategory = comboCATEGORY.getSelectedItem().toString();
        JOptionPane.showMessageDialog(this, "You selected: " + selectedCategory, "Category Selected", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_comboCATEGORYActionPerformed


    private void btnDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELETEActionPerformed

        int selectedRow = tableTracker.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an item!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int num = Integer.parseInt(tableTracker.getValueAt(selectedRow, 0).toString());

            int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this item?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {

                Connection connection = MySQLConnector.getConnection();
                try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM number WHERE Number = ?")) {

                    preparedStatement.setInt(1, num);
                    int rowsAffected = preparedStatement.executeUpdate();
                    boolean success = rowsAffected > 0;

                    if (success) {
                        JOptionPane.showMessageDialog(this, "Item deleted successfully!", "Notification", JOptionPane.INFORMATION_MESSAGE);

                        DefaultTableModel model = (DefaultTableModel) tableTracker.getModel();
                        model.removeRow(selectedRow);

                        model.fireTableDataChanged();
                    } else {
                        JOptionPane.showMessageDialog(this, "No item found with Number: " + num, "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid item ID.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnDELETEActionPerformed

    private void btnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDActionPerformed

        AddDialog.pack();
        AddDialog.setLocationRelativeTo(this);
        AddDialog.setVisible(true);

    }//GEN-LAST:event_btnADDActionPerformed

    private void btnTOTALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTOTALActionPerformed

        double totalSum = 0.0;

        for (int i = 0; i < tableTracker.getRowCount(); i++) {
            String moneySpend = tableTracker.getValueAt(i, 3).toString();

            if (moneySpend != null && !moneySpend.isEmpty()) {
                try {
                    totalSum += Double.parseDouble(moneySpend);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in row " + i + ": " + moneySpend);
                }
            } else {
                System.out.println("Empty or null value in row " + i);
            }

            System.out.println(String.format("%.2f", totalSum));
        }

        if (jLabel10 != null) {
            jLabel10.setText(String.format("%.2f", totalSum));
        } else {
            System.out.println("jLabel10 is null.");
        }

    }//GEN-LAST:event_btnTOTALActionPerformed

    private void comboMONTHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMONTHActionPerformed
        String selectedMonth = comboMONTH.getSelectedItem().toString();
        JOptionPane.showMessageDialog(this, "You selected: " + selectedMonth, "Category Selected", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_comboMONTHActionPerformed

    private void txtMONEYSPENDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMONEYSPENDActionPerformed

        try {
            double moneySpend = Double.parseDouble(txtMONEYSPEND.getText());
            JOptionPane.showMessageDialog(this, "Valid amount entered: " + moneySpend, "Input Validated", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric value!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            txtMONEYSPEND.setText("");
        }


    }//GEN-LAST:event_txtMONEYSPENDActionPerformed

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b); 
    }
    
    private void btnSAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSAVEActionPerformed

        String month = comboMONTH.getSelectedItem().toString();
        String category = comboCATEGORY.getSelectedItem().toString();
        String moneySpendText = txtMONEYSPEND.getText();

        try {
            double moneySpend = Double.parseDouble(moneySpendText);

            TrackerController controller = new TrackerController();
            boolean success = controller.addTracker(month, category, moneySpend);

            if (success) {
                JOptionPane.showMessageDialog(this, "Record saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                AddDialog.setVisible(false);
                loadTrackerList();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save the record. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid money amount. Please enter a numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnSAVEActionPerformed

    private void tableTrackerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTrackerMouseClicked
        boolean a = tableTracker.isEditing();
        if (a == false) {
            JOptionPane.showMessageDialog(this, "\nYou cannot edit this table!", "REMINDER!", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_tableTrackerMouseClicked

    private void tableTrackerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableTrackerKeyPressed

    }//GEN-LAST:event_tableTrackerKeyPressed

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
            java.util.logging.Logger.getLogger(MyTrackerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyTrackerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyTrackerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyTrackerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyTrackerUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog AddDialog;
    private javax.swing.JButton btnADD;
    private javax.swing.JButton btnDELETE;
    private javax.swing.JButton btnSAVE;
    private javax.swing.JButton btnTOTAL;
    private javax.swing.JComboBox<String> comboCATEGORY;
    private javax.swing.JComboBox<String> comboMONTH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTable tableTracker;
    private javax.swing.JTextField txtMONEYSPEND;
    // End of variables declaration//GEN-END:variables

}
