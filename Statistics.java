/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Admins.AdminDashboard;
import Suppliers.SupplierDashboard;
import User.MainView;
import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class Statistics {
    
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    
    private int total(String tableName)
    {
        int total=0;
        try {
              st = con.createStatement();
              rs = st.executeQuery("select count(*) as 'total' from "+ tableName + "");
             if(rs.next())
             {
                 total=rs.getInt(1);
             }
        } catch (SQLException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
        
    }
    
    
    private double totalSales()
    {
        double total=0.0;
        try {
              st = con.createStatement();
              rs = st.executeQuery("select sum(total) as 'total' from purchase");
             if(rs.next())
             {
                 total=rs.getDouble(1);
             }
        } catch (SQLException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
        
    }
    
    private double todaySales()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
        Date date = new Date();
        String today= df.format(date);
        double total=0.0;
        try {
              st = con.createStatement();
              rs = st.executeQuery("select sum(total) as 'total' from purchase where p_date = '"+today+"'");
             if(rs.next())
             {
                 total=rs.getDouble(1);
             }
        } catch (SQLException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
        
    }
    
    
    //user total purchase
    private double totalPurchase(int id)
    {
        double total=0.0;
        try {
              st = con.createStatement();
              rs = st.executeQuery("select sum(total) as 'total' from purchase where uid = "+id+"");
             if(rs.next())
             {
                 total=rs.getDouble(1);
             }
        } catch (SQLException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
        
    }
    
     private int totalDeliveries(String name)
    {
        int total=0;
        try {
              st = con.createStatement();
              rs = st.executeQuery("select count(*) as 'total' from purchase where supplier_name = '"+name+"' and status = 'Received'");
             if(rs.next())
             {
                 total=rs.getInt(1);
             }
        } catch (SQLException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
        
    }
    
    
    
    //admin dashboard
    
    public void admin()
    {
        AdminDashboard.jCat.setText(String.valueOf(total("category")));
        AdminDashboard.jPro.setText(String.valueOf(total("product")));
        AdminDashboard.jUsers.setText(String.valueOf(total("user")));
        AdminDashboard.jSuppliers.setText(String.valueOf(total("supplier")));
        AdminDashboard.jSales.setText(String.valueOf(totalSales()));
        AdminDashboard.jTsales.setText(String.valueOf(todaySales()));
    }
    
    //user dashboard
    public void user(int id)
    {
        MainView.jCat.setText(String.valueOf(total("category")));
        MainView.jPro.setText(String.valueOf(total("product")));
        MainView.jPur.setText(String.valueOf(totalPurchase(id)));
    }
    
    //supplier
    public void supplier(String name)
    {
        SupplierDashboard.jDel.setText(String.valueOf(totalDeliveries(name)));
    }
    
}
