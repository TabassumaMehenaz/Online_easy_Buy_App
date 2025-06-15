
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MyConnection {
    public static final String username = "root";//here you have to provide your mysql username
    public static final String password = "cuet@112023";//here you have to provide your mysql password
    //public static final String url= "jdbc:mysql://localhost:3306/Online_Easy_Buy";
    public static final String url= "jdbc:mysql://localhost:3306/new_Data_Base";
    public static Connection con= null;
    
    public static Connection getConnection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,username,password);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,""+ ex,"",JOptionPane.WARNING_MESSAGE);
        }
        return con;
    }
    
}
