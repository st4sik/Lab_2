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
import models.Product;

/**
 *
 * @author STASСтас
 */
public class ProductDAO {
    public ArrayList<Product> getAllPayments() throws SQLException, ClassNotFoundException
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Locale.setDefault(Locale.ENGLISH);
        ArrayList<Product> ap=new ArrayList<Product>();
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:"
                + "1521:XE","st4sik","st4nislav");
        String selectTableSQL="SELECT * FROM product";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(selectTableSQL);
        int i=0;
        while(rs.next())
        {
            Product t_pr=new Product();
            t_pr.setId(rs.getInt("ID"));
            t_pr.setName(rs.getString("NAME"));
            ap.add(t_pr);
        }
        rs.close();
        conn.close();
        return ap;
    }
    
}
