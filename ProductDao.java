/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hello
 */
public class ProductDao {
    
    
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    
    //get product table maxrow
    public int getMaxRow()
    {
        int row =0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select max(pid) from product");
            while(rs.next())
            {
                row = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row+1;
    }
    
    
    public int countCategories()
    {
        int total=0;
        try {
              st = con.createStatement();
              rs = st.executeQuery("select count(*) as 'total' from category");
             if(rs.next())
             {
                 total=rs.getInt(1);
             }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
        
    }
    
    public String[] getCat()
    {
        String[] categories = new String[countCategories()];
        try {
              st= con.createStatement();
              rs=st.executeQuery("select * from category");
              int i=0;
              while(rs.next())
              {
                  categories[i]=rs.getString(2);
                  i++;
              }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       return categories;
    }
    ///*
    //checking if product id already exists
    public boolean isProductIdExist(int id)
    {
        try {
            ps = con.prepareStatement("select * from product where pid = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next())
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    //checking if product and category already exists(pname cname of product table)
    public boolean isProCatExist(String pro,String cat)
    {
        try {
            ps = con.prepareStatement("select * from product where pname = ? and cname=?");
            ps.setString(1, pro);
            ps.setString(2, cat);
            rs = ps.executeQuery();
            if(rs.next())
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    //*/
    
    
    
    
    
    /*
    public boolean isProductIdExist(int id) {
    String sql = "SELECT pid FROM product WHERE pid = ?";
    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        return rs.next();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

public boolean isProCatExist(String pname, String cname) {
    String sql = "SELECT pname, cname FROM product WHERE pname = ? AND cname = ?";
    try {
        ps = con.prepareStatement(sql);
        ps.setString(1, pname);
        ps.setString(2, cname);
        rs = ps.executeQuery();
        return rs.next();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
*/

    
    
    
    
    
    
    
    
    
    //insert data into product table
    
    public void insert(int id, String pname, String cname,int qty,double price)
    {
        String sql = "insert into product values (?,?,?,?,?)";
        try {
               ps = con.prepareStatement(sql);
               ps.setInt(1, id);
               ps.setString(2, pname);
               ps.setString(3, cname);
               ps.setInt(4, qty);
               ps.setDouble(5, price);
               
               
               if(ps.executeUpdate()>0)
               {
                   JOptionPane.showMessageDialog(null,"Product added successfully");
               }
               
               
            }catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //get products data
    public void getProductsValue(JTable table ,String search)
    {
        String sql = "select * from product where concat(pid,pname,cname) like? order by pid desc";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%"+search+"%");
            rs=ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object [] row;
            while(rs.next())
            {
                row = new Object[5];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getInt(4);
                row[4] = rs.getDouble(5);
                model.addRow(row);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //update product data
    public void update(int id, String pname, String cname,int qty,double price)
    {
        String sql = "update product set pname= ?, cname = ?, pqty = ?, pprice = ? where pid = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pname);
            ps.setString(2, cname);
            ps.setInt(3, qty);
            ps.setDouble(4, price);
            ps.setInt(5, id);
            if(ps.executeUpdate()>0)
            {
                JOptionPane.showMessageDialog(null,"Product successfully updated");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    //delete product
    
    public void delete(int id)
    {
        int x =JOptionPane.showConfirmDialog(null,"Are you sure want to delete this product?","Delete Product",JOptionPane.OK_CANCEL_OPTION);
        if(x == JOptionPane.OK_OPTION)
        {
            try {
                ps = con.prepareStatement("Delete from product where pid = ?");
                ps.setInt(1,id);
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null,"Product deleted");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
