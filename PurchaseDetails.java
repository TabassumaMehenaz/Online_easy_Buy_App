/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package User;

import dao.PurchaseDao;
import dao.Statistics;
import dao.UserDao;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author HP
 */
public class PurchaseDetails extends javax.swing.JFrame {

    /**
     * Creates new form PurchaseDetails
     */
    public PurchaseDetails() {
        initComponents();
        adjustTableProperties();
        init();
    
    }
   private void adjustTableProperties()
   {
        //jTable2.setRowHeight(30);
        int[] columnWidths ={100,150,120,80,80,100,120,120,150,100};
        for(int i=0;i< columnWidths.length;i++)
        {
            TableColumn column = jTable2.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
        
    }
    Statistics statistics = new Statistics();
    PurchaseDao pd = new PurchaseDao();
    UserDao user = new UserDao(); 
    Color textPrimaryColor = new Color(102,120,138);
    Color primaryColor = new Color(42,58,73);
    int xx,xy;
    Color notEdit = new Color(255,255,255);
    int rowIndex;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
    Date date = new Date();
    private int uId;
    DefaultTableModel model;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private void init()
    {
        BtnRefund.setBackground(notEdit);
        BtnClear.setBackground(notEdit);
        jButton1.setBackground(notEdit);
        jScrollPane2.setBackground(notEdit);
        jTable2.setBackground(notEdit);       
        jTextField4.setText(df.format(date));
        uId = user.getUserId(MainView.userEmail.getText());
        productTable();
        setLocation(450,120);
    }
    
    private void productTable()
    {
        pd.getProductsValue(jTable2,"", uId);
       model = (DefaultTableModel) jTable2.getModel();
       jTable2.setRowHeight(30);
       jTable2.setShowGrid(true);
       jTable2.setGridColor(Color.BLACK);
       jTable2.setBackground(Color.WHITE);
       jTable2.setSelectionBackground(Color.LIGHT_GRAY);
    }
    
    private void clear()
    {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTable2.clearSelection();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        BtnRefund = new javax.swing.JButton();
        BtnClear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Purchase ID", "Product ID", "Product Name", "Quantity", "Price", "Total", "Purchase Date", "Received Date", "Supplier Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 530, 360));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 35)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("x");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 40, 30));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 315, 28));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 180, 28));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 180, 28));
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 180, 28));

        BtnRefund.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BtnRefund.setForeground(new java.awt.Color(0, 102, 102));
        BtnRefund.setText("Refund");
        BtnRefund.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRefundActionPerformed(evt);
            }
        });
        jPanel1.add(BtnRefund, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 160, 37));

        BtnClear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BtnClear.setForeground(new java.awt.Color(0, 102, 102));
        BtnClear.setText("CLEAR");
        BtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClearActionPerformed(evt);
            }
        });
        jPanel1.add(BtnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 160, 34));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Purchase ID:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Received Date:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 20));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Current Date:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Search Product");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 114, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/search.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, -1, 40));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 160, 40));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("BACK");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/CART.png"))); // NOI18N
        jLabel14.setText("Logout");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
       /* setVisible(false);
        MainView.jPanel7.setBackground(primaryColor);
        MainView.jPanel11.setBackground(primaryColor);
        MainView.jLabel7.setForeground(textPrimaryColor);
        MainView.jLabel8.setVisible(true);
        MainView.jLabel20.setVisible(false);*/
        setDefault();
    }//GEN-LAST:event_jLabel12MouseClicked
    
    public void setDefault()
    {
        setVisible(false);
        MainView.jPanel7.setBackground(primaryColor);
        MainView.jPanel11.setBackground(primaryColor);
        MainView.jLabel7.setForeground(textPrimaryColor);
        MainView.jLabel20.setVisible(true);
        MainView.jLabel8.setVisible(false);
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i=0;i<=1;i+=0.1)
        {
            String s = ""+ i;
            float f = Float.parseFloat(s);
            this.setOpacity(f);
            try{
                Thread.sleep(40);
            } catch (InterruptedException ex) {
                Logger.getLogger(PurchaseDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }//GEN-LAST:event_formWindowOpened

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel1MouseDragged


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new MainView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        //MainView mainView = new MainView();
        //mainView.setVisible(true);
        //this.dispose();
        goBack();
    }//GEN-LAST:event_jLabel13MouseClicked
     
   private void goBack() {
         if (NavigationTracker.previousFrame != null) {
            NavigationTracker.previousFrame.setVisible(true);
        }
        this.dispose(); // Close the PurchaseFrame
    }
    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked

        int a = JOptionPane.showConfirmDialog(this, "Do You Want To Logout Now?", "Logout", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jLabel14MouseClicked

    private void BtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearActionPerformed
        // TODO add your handling code here:
        clear();
        adjustTableProperties();
        
    }//GEN-LAST:event_BtnClearActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        model = (DefaultTableModel) jTable2.getModel();
        rowIndex = jTable2.getSelectedRow();
        
        jTextField2.setText(model.getValueAt(rowIndex,0).toString());
        if(model.getValueAt(rowIndex,7)== null)
        {
            jTextField3.setText(null);
        }
        else
        {
            jTextField3.setText(model.getValueAt(rowIndex,7).toString());
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void BtnRefundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRefundActionPerformed
        // TODO add your handling code here:
        if(jTextField2.getText().isEmpty() || jTextField3.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Purchase id or received date is missing");
        }
        else
        {
            String receivedDate = jTextField3.getText();
            String currentDate = jTextField4.getText();
            try {
                
                Date d1 = df.parse(receivedDate);
                Date d2 = df.parse(currentDate);
                
                long dateReceivedInMs = d1.getTime();
                long dateCurrentInMs = d2.getTime();
                long timeDiff = (dateCurrentInMs - dateReceivedInMs);
                long daysDiff = TimeUnit.DAYS.convert(timeDiff , TimeUnit.MILLISECONDS);
                
                if(daysDiff > 30)
                {
                    JOptionPane.showMessageDialog(this,"Sorry refund time is over! \n Refund applicable 30 days from the received day..");
                }
                else
                {
                    int id = Integer.parseInt(jTextField2.getText());
                    pd.refund(id);
                    jTable2.setModel(new DefaultTableModel(null, new Object[]{"Purchase ID","Product ID","Product Name",
                                                                              "Quantity","Price",
                                                                              "Total","Purchased Date","Received Date",
                                                                              "Supplier Name","Status"}));
                    pd.getProductsValue(jTable2,"", uId);
                    statistics.user(user.getUserId(String.valueOf(MainView.userEmail.getText())));
                    clear();
                }
                
            } catch (ParseException ex) {
                Logger.getLogger(PurchaseDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BtnRefundActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        jTable2.setModel(new DefaultTableModel(null, new Object[]{"Purchase ID","Product ID","Product Name",
                                                                              "Quantity","Price",
                                                                              "Total","Purchased Date","Received Date",
                                                                              "Supplier Name","Status"}));
                    pd.getProductsValue(jTable2,jTextField1.getText(), uId);
        
    }//GEN-LAST:event_jTextField1KeyReleased


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
            java.util.logging.Logger.getLogger(PurchaseDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchaseDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchaseDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchaseDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PurchaseDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnClear;
    private javax.swing.JButton BtnRefund;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
