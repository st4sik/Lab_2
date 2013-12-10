<%-- 
    Document   : Orders
    Created on : Dec 10, 2013, 2:05:19 PM
    Author     : STASСтас
--%>

<%@page import="models.Orders"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.ejb.OrdersDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% OrdersDAO pd=new OrdersDAO();
        ArrayList<Orders> ao=new ArrayList<Orders>();
        ao=pd.getAllOrders();
        request.setCharacterEncoding("UTF-8");
        %>
        
        <table border="2">
 <TR>
                    <TH>ID</TH>
                    <TH>Number_Order</TH>
                    <TH>Customer_FK</TH>
                    <TH>Date_Orders</TH>
                    <TH>Count</TH>
                    <TH>Payment_FK</TH>
                    <TH>Product_FK</TH>
                </TR>
        <% for(int i=0;i<ao.size();i++){%>

                 <TR>
                     <TD> <%=ao.get(i).getId() %> </TD>
                    <TD> <%=ao.get(i).getNumber() %> </TD>
                    <TD> <%=ao.get(i).getCustomer() %> </TD>
                    <TD> <%=ao.get(i).getDate() %> </TD>
                    <TD> <%=ao.get(i).getSumm() %> </TD>
                    <TD> <%=ao.get(i).getPayment() %> </TD>
                    <TD> <%=ao.get(i).getProduct() %> </TD>
                </TR>
                <% } %>
</table>
        <form action="OrdersServlet" method="POST">
            <table>
    <tr>
        <td>ID:</td>
        <td><input type="text" name="id" value="${Orders.id}"></td>  
    </tr>
    <tr>
        <td>Number_Orders:</td>
        <td><input type="text" name="number_orders" value="${Orders.number_orders}"></td>
    </tr>
    
    <tr>
        <td>Customer_FK:</td>
        <td><input type="text" name="c_fk" value="${Orders.customer_fk}"></td>
    </tr>
    <tr>
        <td>Date_Orders:</td>
        <td><input type="text" name="d_o" value="${Orders.date}"></td>
    </tr>
    
    <tr>
        <td>Count:</td>
        <td><input type="text" name="count" value="${Orders.summ}"></td>
    </tr>
    <tr>
        <td>Payment_FK</td>
        <td><input type="text" name="p_fk" value="${Orders.payment_fk}"></td>
    </tr>
    <tr>
        <td>Product_FK</td>
        <td><input type="text" name="pr_fk" value="${Orders.product_fk}"></td>
    </tr>
</table>
    <input type="Submit" name="command" value="Add">
    <input type="Submit" name="command" value="Delete">
    <input type="Submit" name="command" value="Update">
 </form>
    </body>
</html>
