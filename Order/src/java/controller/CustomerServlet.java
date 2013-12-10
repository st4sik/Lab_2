/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Customer;
import models.ejb.CustomerDAO;

/**
 *
 * @author STASСтас
 */
//@WebServlet(name = "CustomerServlet", urlPatterns = {"/CustomerServlet"})
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
private CustomerDAO cd=new CustomerDAO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        request.setCharacterEncoding("UTF-8");
        String name=request.getParameter("name");
        String mobile=request.getParameter("mobile");
        String address=request.getParameter("address");
        int id=Integer.parseInt(request.getParameter("id"));
        Customer cus=new Customer(name,mobile,address,id);
        

        String command=request.getParameter("command");
        if(command.equals("Add"))
        {
            cd.addCustomer(cus);
            request.setAttribute("customer", cus);
        }
        if(command.equals("Delete"))
        {
            cd.delCustomer(id);
        }
        if(command.equals("Update"))
        {
            cd.updateCustomer(cus);
        }
        
       
//            response.setContentType("text/html;charset=UTF-8");
//            PrintWriter out = response.getWriter();
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<P ALIGN='center'><TABLE BORDER=1>");
//            out.println("<TR>");
//            out.println("<TH>ID</TH>");
//            out.println("<TH>Name</TH>");
//            out.println("<TH>Mobile</TH>");
//            out.println("<TH>Address</TH>");
//            out.println("</TR>");
//
//            ArrayList<Customer> temp=new ArrayList<Customer>();
//            temp=cd.getAllCustomer();
//            out.println("<TR>");
//            for (int i = 0; i < temp.size(); i++) {
//                out.println("<TD>" + "43434" + "</TD>");
//                out.println("<TD>" + "43434" + "</TD>");
//                out.println("<TD>" + "43434" + "</TD>");
//                out.println("<TD>" + "43434"+ "</TD>");
//            }
//            out.println("</TR>");
//            out.println("</TABLE></P>");
//            
//
//            out.println("</body>");
//            out.println("</html>");
//            out.close();
        
       request.getRequestDispatcher("Customer.jsp").forward(request, response);
        
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(CustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(CustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(CustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(CustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
