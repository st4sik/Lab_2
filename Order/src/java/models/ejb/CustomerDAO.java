/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.ejb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;
import models.Customer;



/**
 *
 * @author STASСтас
 */

public class CustomerDAO {
    public void addCustomer(Customer c) throws ClassNotFoundException, SQLException
    {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Locale.setDefault(Locale.ENGLISH);
         Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:"
                + "1521:XE","st4sik","st4nislav");
        String insertTableSQL="INSERT INTO customers"
                + "(id,name,mobile,address)values"
                + "(?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(insertTableSQL);
        ps.setInt(1, c.getId());
        ps.setString(2, c.getName());
        ps.setString(3, c.getMobile());
        ps.setString(4, c.getAddress());
        ps.executeQuery();
        ps.close();
        conn.close();
    }
    
    public void delCustomer(int id) throws ClassNotFoundException, SQLException
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
         Locale.setDefault(Locale.ENGLISH);
         Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:"
                + "1521:XE","st4sik","st4nislav");
         String deleteTableSQL="DELETE FROM customers WHERE id=?";
          PreparedStatement ps=conn.prepareStatement(deleteTableSQL);
          ps.setInt(1, id);
           ps.executeQuery();
        ps.close();
        conn.close();
        
    }
    public void updateCustomer(Customer c) throws ClassNotFoundException, SQLException
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Locale.setDefault(Locale.ENGLISH);
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:"
                + "1521:XE","st4sik","st4nislav");
        String updateTableSQL="UPDATE customers SET name=?, mobile=?, address=?"
                + " where id=?";
        PreparedStatement ps=conn.prepareStatement(updateTableSQL);
        ps.setString(1, c.getName());
        ps.setString(2,c.getMobile());
        ps.setString(3, c.getAddress());
        ps.setInt(4, c.getId());
        ps.executeQuery();
        ps.close();
        conn.close();
                
         
    }
    
    public ArrayList<Customer> getAllCustomer() throws ClassNotFoundException, SQLException
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Locale.setDefault(Locale.ENGLISH);
        ArrayList<Customer> ac=new ArrayList<Customer>();
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:"
                + "1521:XE","st4sik","st4nislav");
        String selectTableSQL="SELECT * FROM Customers";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(selectTableSQL);
        int i=0;
        while(rs.next())
        {
            Customer t_cust=new Customer();
            t_cust.setId(rs.getInt("ID"));
            t_cust.setName(rs.getString("NAME"));
            t_cust.setMobile(rs.getString("MOBILE"));
            t_cust.setAddress(rs.getString("ADDRESS"));
            ac.add(t_cust);
        }
        rs.close();
        conn.close();
        return ac;
    }
}
