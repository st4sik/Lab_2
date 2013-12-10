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
import models.Orders;
import models.Payment;

/**
 *
 * @author STASСтас
 */
public class OrdersDAO {
    
    public void addOrders(Orders o) throws ClassNotFoundException, SQLException
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
         Locale.setDefault(Locale.ENGLISH);
         Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:"
                + "1521:XE","st4sik","st4nislav");
        String insertTableSQL="INSERT INTO orders"
                + "(id,number_order,customer_fk,date_order,summ,payment_fk,product_fk) values"
                + "(?,?,?,?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(insertTableSQL);
        ps.setInt(1, o.getId());
        ps.setInt(2, o.getNumber());
        ps.setInt(3, o.getCustomer());
        ps.setString(4, o.getDate());
        ps.setInt(5,o.getSumm());
        ps.setInt(6, o.getPayment());
        ps.setInt(7, o.getProduct());
        ps.executeQuery();
        ps.close();
        conn.close();
    }
    
    public ArrayList<Orders> getAllOrders() throws ClassNotFoundException, SQLException
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Locale.setDefault(Locale.ENGLISH);
        ArrayList<Orders> ap=new ArrayList<Orders>();
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:"
                + "1521:XE","st4sik","st4nislav");
        String selectTableSQL="SELECT * FROM orders";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(selectTableSQL);
        int i=0;
        while(rs.next())
        {
            Orders t_ord=new Orders();
            t_ord.setId(rs.getInt("ID"));
            t_ord.setNumber(rs.getInt("NUMBER_ORDER"));
            t_ord.setCustomer(rs.getInt("CUSTOMER_FK"));
            t_ord.setDate(rs.getString("DATE_ORDER"));
            t_ord.setSumm(rs.getInt("SUMM"));
            t_ord.setPayment(rs.getInt("PAYMENT_FK"));
            t_ord.setProduct(rs.getInt("PRODUCT_FK"));
            ap.add(t_ord);
        }
        rs.close();
        conn.close();
        return ap;
    }
    
    public void delOrders(int id) throws ClassNotFoundException, SQLException
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
         Locale.setDefault(Locale.ENGLISH);
         Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:"
                + "1521:XE","st4sik","st4nislav");
         String deleteTableSQL="DELETE FROM orders WHERE id=?";
          PreparedStatement ps=conn.prepareStatement(deleteTableSQL);
          ps.setInt(1, id);
           ps.executeQuery();
        ps.close();
        conn.close();
    }
}
