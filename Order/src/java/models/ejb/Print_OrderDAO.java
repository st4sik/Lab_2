/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.ejb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;
import models.Payment;
import models.Print_Orders;

/**
 *
 * @author STASСтас
 */
public class Print_OrderDAO {
    
    public ArrayList<Print_Orders> getPrintOrders() throws SQLException, ClassNotFoundException
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Locale.setDefault(Locale.ENGLISH);
        ArrayList<Print_Orders> po=new ArrayList<Print_Orders>();
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:"
                + "1521:XE","st4sik","st4nislav");
        String selectTableSQL="SELECT * FROM print_orders";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(selectTableSQL);
        int i=0;
        while(rs.next())
        {
            Print_Orders t_pr=new Print_Orders();
            t_pr.setID(rs.getInt("ID"));
            t_pr.setCustomerName(rs.getString("NAME"));
            t_pr.setCustomerMobile(rs.getString("MOBILE"));
            t_pr.setCustomerAddress(rs.getString("ADDRESS"));
            t_pr.setDateOrder(rs.getString("DATE_ORDER"));
            t_pr.setSumm(rs.getInt("COUNT"));
            t_pr.setPaymentSumm(rs.getInt("SUMM"));
            t_pr.setPaymentBill(rs.getInt("BILL"));
            t_pr.setProductName(rs.getString("NAME_PRODUCT"));
            t_pr.setNumber(rs.getInt("NUMBER_ORDER"));
            po.add(t_pr);
        }
        rs.close();
        conn.close();
        return po;
    }
    
}
