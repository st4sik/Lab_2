/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Customer;
import models.Orders;
import models.ejb.OrdersDAO;

/**
 *
 * @author STASСтас
 */
@WebServlet("/OrdersServlet")
public class OrdersServlet extends HttpServlet {
    private OrdersDAO od=new OrdersDAO();
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
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id=request.getParameter("id").isEmpty()? 0:Integer.parseInt(request.getParameter("id"));
        int n_o=request.getParameter("number_orders").isEmpty()? 0: Integer.parseInt(request.getParameter("number_orders"));
        int c_fk=request.getParameter("c_fk").isEmpty()? 0 : Integer.parseInt(request.getParameter("c_fk"));
        String date=request.getParameter("d_o");
        int count=request.getParameter("count").isEmpty()? 0: Integer.parseInt(request.getParameter("count"));
        int p_fk=request.getParameter("p_fk").isEmpty()? 0: Integer.parseInt(request.getParameter("p_fk"));
        int pr_fk = request.getParameter("pr_fk").isEmpty()? 0: Integer.parseInt(request.getParameter("pr_fk"));
        
        Orders or=new Orders(id,n_o,c_fk,date,count,p_fk,pr_fk);
        
         String command=request.getParameter("command");
        if(command.equals("Add"))
        {
                try {
                    od.addOrders(or);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(OrdersServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(OrdersServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            request.setAttribute("orders", or);
        }
        if(command.equals("Delete"))
        {
            try {
                od.delOrders(id);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(OrdersServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(OrdersServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
         request.getRequestDispatcher("Orders.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
