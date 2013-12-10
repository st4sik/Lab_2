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
import models.Payment;

/**
 *
 * @author STASСтас
 */
public class PaymentDAO {
    public void addPayment(Payment p) throws ClassNotFoundException, SQLException
    {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Locale.setDefault(Locale.ENGLISH);
         Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:"
                + "1521:XE","st4sik","st4nislav");
        String insertTableSQL="INSERT INTO payment"
                + "(id,summ,bill) values"
                + "(?,?,?)";
        PreparedStatement ps=conn.prepareStatement(insertTableSQL);
        ps.setInt(1, p.getId());
        ps.setInt(2, p.getSumm());
        ps.setInt(3, p.getBill());
        ps.executeQuery();
        ps.close();
        conn.close();
    }
    
    public void updatePayment(Payment p) throws SQLException, ClassNotFoundException
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Locale.setDefault(Locale.ENGLISH);
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:"
                + "1521:XE","st4sik","st4nislav");
        String updateTableSQL="UPDATE payment SET summ=?, bill=? WHERE"
                + " id =?";
        PreparedStatement ps=conn.prepareStatement(updateTableSQL);
        ps.setInt(1, p.getSumm());
        ps.setInt(2, p.getBill());
        ps.setInt(3, p.getId());
        ps.executeQuery();
        ps.close();
        conn.close();
    }
    
    public ArrayList<Payment> getAllPayments() throws SQLException, ClassNotFoundException
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Locale.setDefault(Locale.ENGLISH);
        ArrayList<Payment> ap=new ArrayList<Payment>();
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:"
                + "1521:XE","st4sik","st4nislav");
        String selectTableSQL="SELECT * FROM payment";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(selectTableSQL);
        int i=0;
        while(rs.next())
        {
            Payment t_cust=new Payment();
            t_cust.setId(rs.getInt("ID"));
            t_cust.setSumm(rs.getInt("SUMM"));
            t_cust.setBill(rs.getInt("BILL"));
            ap.add(t_cust);
        }
        rs.close();
        conn.close();
        return ap;
    }
    
    public void delPayment(int id) throws ClassNotFoundException, SQLException
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
         Locale.setDefault(Locale.ENGLISH);
         Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:"
                + "1521:XE","st4sik","st4nislav");
         String deleteTableSQL="DELETE FROM payment WHERE id=?";
          PreparedStatement ps=conn.prepareStatement(deleteTableSQL);
          ps.setInt(1, id);
           ps.executeQuery();
        ps.close();
        conn.close();
    }

    
    
}
