/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package User;

import dao.ProductDao;
import dao.PurchaseDao;
import dao.Statistics;
import dao.UserDao;
import java.awt.Color;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author HP
 */


public class Purchase extends javax.swing.JFrame {
    /**
     * Creates new form Purchase
     */
    public Purchase() {
        initComponents();
        adjustTableProperties();
        //adjustTablePropertiesTable2();
        init();
        
    }
   private void adjustTableProperties()
   {
        //jTable2.setRowHeight(30);
        int[] columnWidths ={150,100,200,80,80,100};
        for(int i=0;i< columnWidths.length;i++)
        {
            TableColumn column = jTable2.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
        
    }
   /*
   private void adjustTablePropertiesTable2()
   {
        //jTable2.setRowHeight(30);
        int[] columnWidths ={100,150,200,80,80,100};
        for(int i=0;i< columnWidths.length;i++)
        {
            TableColumn column = jTable1.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
        
    }*/
    Statistics statistics = new Statistics();
    UserDao user = new UserDao();
    Color textPrimaryColor = new Color(102,120,138);
    Color primaryColor = new Color(42,58,73);
    int xx,xy;
    int rowIndex;
    Color notEdit = new Color(255,255,255);
    PurchaseDao purchaseDao= new PurchaseDao();
    ProductDao productDao= new ProductDao();
    DefaultTableModel model;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
    Date date = new Date();
    
    private int qty = 0;
    private double price = 0.0;
    private double total = 0.0;
    private int pId;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private void init()
    {
        BtnAdd.setBackground(notEdit);
        BtnPurchase.setBackground(notEdit);
        Btnprint.setBackground(notEdit);
        BtnClear.setBackground(notEdit);
        //jButton1.setBackground(notEdit);
        jTextField2.setText(String.valueOf(purchaseDao.getMaxRow()));
        productsTable();
        purchaseTable();
        pId= purchaseDao.getMaxRow();
        setLocation(450,110);
        
    }
    
    //extra
    //public void Purchase(String productName, double price, int quantity) {
    //jTextField3.setText("Product: " + productName);
    
    //jTextField4.setText("Quantity: " + quantity);
    //this.dispose();
    //}

    
    private void productsTable()
    {
        //24
        productDao.getProductsValue(jTable1,"");
        model = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowHeight(30);
        jTable1.setShowGrid(true);
        jTable1.setGridColor(Color.BLACK);
        jTable1.setBackground(Color.WHITE);
        jTable1.setSelectionBackground(Color.LIGHT_GRAY); 
        
    }
    
    private void purchaseTable()
    {
        //cat.getCategoriesValue(jTable1,"");
        model = (DefaultTableModel) jTable2.getModel();
        jTable2.setRowHeight(30);
        jTable2.setShowGrid(true);
        jTable2.setGridColor(Color.BLACK);
        jTable2.setBackground(Color.WHITE);
        jTable2.setSelectionBackground(Color.LIGHT_GRAY);    
    }
    
    
    private void clear()
    {
        jTextField2.setText(String.valueOf(purchaseDao.getMaxRow()));
        jTextField3.setText("");
        jTextField4.setText("0");
        jTextField1.setText("");
        jTable1.clearSelection();
        price = 0.0;
        qty = 0;
        
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btnprint = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        BtnAdd = new javax.swing.JButton();
        BtnPurchase = new javax.swing.JButton();
        BtnClear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        Btnprint.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Btnprint.setForeground(new java.awt.Color(0, 102, 102));
        Btnprint.setText("PRINT");
        Btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnprintActionPerformed(evt);
            }
        });

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Category", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 480, 229));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Purchase ID", "Product ID", "Product Name", "Quantity", "Price", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 500, 240));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 35)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("x");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 33, 32));

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
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 315, 28));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 145, 190, 28));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 214, 190, 28));

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 283, 190, 28));

        BtnAdd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BtnAdd.setForeground(new java.awt.Color(0, 102, 102));
        BtnAdd.setText("ADD");
        BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 103, 37));

        BtnPurchase.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BtnPurchase.setForeground(new java.awt.Color(0, 102, 102));
        BtnPurchase.setText("PURCHASE");
        BtnPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPurchaseActionPerformed(evt);
            }
        });
        jPanel1.add(BtnPurchase, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, -1, 37));

        BtnClear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BtnClear.setForeground(new java.awt.Color(0, 102, 102));
        BtnClear.setText("CLEAR");
        BtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClearActionPerformed(evt);
            }
        });
        jPanel1.add(BtnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 130, 34));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Purchase ID:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 116, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Product Name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 185, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quantity:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 254, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Search Product");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 110, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Total:0.0");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 452, 28));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/search.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 30, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("BACK");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 20));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/CART.png"))); // NOI18N
        jLabel8.setText("Logout");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
       // setVisible(false);
        //24
        //MainView.jPanel4.setBackground(primaryColor);
        //MainView.jPanel8.setBackground(primaryColor);
        //MainView.jLabel5.setForeground(textPrimaryColor);
        //MainView.jLabel6.setVisible(true);
        //MainView.jLabel19.setVisible(false);
        setDefault();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i=0;i<=1;i+=0.1)
        {
            String s = ""+ i;
            float f = Float.parseFloat(s);
            this.setOpacity(f);
            try{
                Thread.sleep(40);
            } catch (InterruptedException ex) {
                Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
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

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked

        int a = JOptionPane.showConfirmDialog(this, "Do You Want To Logout Now?", "Logout", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
         goBack();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // TODO add your handling code here:
        if(!Character.isDigit(evt.getKeyChar()))
        {
            evt.consume();
        } 
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        model = (DefaultTableModel) jTable1.getModel();
        rowIndex = jTable1.getSelectedRow();
        jTextField3.setText(model.getValueAt(rowIndex,1).toString());
        String s1 = model.getValueAt(rowIndex, 3).toString();
        String s2 = model.getValueAt(rowIndex, 4).toString();
        qty = Integer.parseInt(s1);
        price = Double.parseDouble(s2);
    }//GEN-LAST:event_jTable1MouseClicked

    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed
        // TODO add your handling code here:
        if(jTextField3.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Please select a product","Warning",2);
        }
        else if(jTextField4.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Product quantity is required","Warning",2);
        }
        else
        {
            model = (DefaultTableModel) jTable1.getModel();
            int proId = Integer.parseInt(model.getValueAt(rowIndex,0).toString());
           if(!isProductExist(proId))
            {
              if(!(qty <=0))
               {
                  int newQty = Integer.parseInt(jTextField4.getText());
                  if(newQty != 0)
                   {
                      if(!(newQty>qty))
                      {
                        String pname= jTextField3.getText();
                        String t = String.format("%.2f", price * (double) newQty);
                        Object[] data = {pId,proId,pname,newQty,price,t};
                        model=(DefaultTableModel) jTable2.getModel();
                        model.addRow(data);
                        total += price*(double)newQty;
                        jLabel5.setText(String.format("Total : " + "%.2f", total));
                        pId++;
                        clear();
                        //adjustTableProperties();
                      }
                      else
                      {
                        JOptionPane.showMessageDialog(this,"Not enough stock","Warning",2);
                      }
                    }
                  else
                   {
                    JOptionPane.showMessageDialog(this,"Please increase the product quantity","Warning",2);
                   }
                }
              else
              {
                JOptionPane.showMessageDialog(this,"Stock is empty","Warning",2);
              }
             }
            else
            {
                JOptionPane.showMessageDialog(this,"Product already purchased","Warning",2);
            }
        }
    }//GEN-LAST:event_BtnAddActionPerformed

    private void BtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearActionPerformed
        // TODO add your handling code here:
        clear();
        //adjustTableProperties();
    }//GEN-LAST:event_BtnClearActionPerformed

    private void BtnPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPurchaseActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) jTable2.getModel();
        if(model.getRowCount()>0)
        {
            String[] value = new String[5];
            String email = MainView.userEmail.getText();
            value= purchaseDao.getUserValue(email);
            int uid = Integer.parseInt(value[0]);
            String uname = value[1];
            String uPhone = value[2];
            String address = value[3] +", "+value[4];
            String purchaseDate = df.format(date);
            for(int i = 0;i<model.getRowCount();i++)
            {
                int id = Integer.parseInt(model.getValueAt(i,0).toString());
                int pid = Integer.parseInt(model.getValueAt(i,1).toString());
                String pName = model.getValueAt(i,2).toString();
                int q = Integer.parseInt(model.getValueAt(i,3).toString());
                double pri = Double.parseDouble(model.getValueAt(i,4).toString());
                double tot = Double.parseDouble(model.getValueAt(i,5).toString());
                purchaseDao.insert(id, uid, uname, uPhone, pid, pName, q, pri, tot, purchaseDate, address, null, null, "pending");
                int newQuantity = purchaseDao.getQty(pid) - q;
                purchaseDao.qtyUpdate(pid, newQuantity);
                //setDefault();
                adjustTableProperties();
            }
            statistics.user(user.getUserId(email));
            JOptionPane.showMessageDialog(this,"Successfully purchased!!"); 
            setDefault();
            adjustTableProperties();
        }
        else
        {
           JOptionPane.showMessageDialog(this,"You haven't purchased any product","Warning",2); 
        }
        
    }//GEN-LAST:event_BtnPurchaseActionPerformed

    private void BtnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnprintActionPerformed
        /*try {
            // TODO add your handling code here:
            String email = MainView.userEmail.getText();
            MessageFormat header = new MessageFormat("Receipt-->    "+ "Email: "+email+"    "+"Total: "+total);
            MessageFormat footer = new MessageFormat("Page{0 ,number ,integer}");
            jTable2.print(JTable.PrintMode.FIT_WIDTH,header,footer);
            adjustTableProperties();
        } catch (PrinterException ex) {
            Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        
        try {
          // Get the user's email
          String email = MainView.userEmail.getText();
        
          // Create header and footer
          MessageFormat header = new MessageFormat("Receipt --> Email: " + email + " Total: " + total);
          MessageFormat footer = new MessageFormat("Page {0,number,integer}");
        
           // Print the table
           jTable2.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        
           // Adjust table properties after printing
           adjustTableProperties();
           } catch (PrinterException ex) {
        Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
    }//GEN-LAST:event_BtnprintActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        jTable1.setModel(new DefaultTableModel(null,new Object[]{"Product ID","Product Name","Category Name","Quantity","Price"}));
        productDao.getProductsValue(jTable1,jTextField1.getText());
        adjustTableProperties();
    }//GEN-LAST:event_jTextField1KeyReleased
    
    private boolean isProductExist(int proId)
    {
        model = (DefaultTableModel) jTable2.getModel();
        if(model.getRowCount()>0)
        {
            for(int i=0; i<model.getRowCount();i++)
            {
                int newProId = Integer.parseInt(model.getValueAt(i, 1).toString());
                if(newProId==proId)
                {
                    return true;
                }
            }
        }
        return false;
    }
        private void goBack() {
         if (NavigationTracker.previousFrame != null) {
            NavigationTracker.previousFrame.setVisible(true);
        }
        this.dispose(); // Close the PurchaseFrame
    }
        
    public void setDefault()
    {
        setVisible(false);
        MainView.jPanel4.setBackground(primaryColor);
        MainView.jPanel8.setBackground(primaryColor);
        MainView.jLabel5.setForeground(textPrimaryColor);
        MainView.jLabel19.setVisible(true);
        MainView.jLabel6.setVisible(false);
    }
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
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Purchase().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdd;
    private javax.swing.JButton BtnClear;
    private javax.swing.JButton BtnPurchase;
    private javax.swing.JButton Btnprint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
