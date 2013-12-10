<%-- 
    Document   : Payment
    Created on : Dec 10, 2013, 1:10:47 PM
    Author     : STASСтас
--%>

<%@page import="models.Payment"%>
<%@page import="models.ejb.PaymentDAO"%>
<%@page import="models.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.ejb.CustomerDAO"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <table>
        <% PaymentDAO pd=new PaymentDAO();
        ArrayList<Payment> ap=new ArrayList<Payment>();
        ap=pd.getAllPayments();
        request.setCharacterEncoding("UTF-8");
        %>
        
        <table border="2">
 <TR>
                    <TH>ID</TH>
                    <TH>Summ</TH>
                    <TH>Bill</TH>
                </TR>
        <% for(int i=0;i<ap.size();i++){%>

                 <TR>
                     <TD> <%=ap.get(i).getId() %> </TD>
                    <TD> <%=ap.get(i).getSumm() %> </TD>
                    <TD> <%=ap.get(i).getBill() %> </TD>
                </TR>
                <% } %>
</table>

    <body>
        <form action="PaymentServlet" method="POST">
            <table>
    <tr>
        <td>Summ:</td>
        <td><input type="text" name="summ" value="${Payment.summ}"></td>  
    </tr>
    <tr>
        <td>Bill:</td>
        <td><input type="text" name="bill" value="${Payment.bill}"></td>
    </tr>
    
    <tr>
        <td>ID:</td>
        <td><input type="text" name="id" value="${Payment.id}"></td>
    </tr>
</table>
    <input type="Submit" name="command" value="Add">
    <input type="Submit" name="command" value="Delete">
    <input type="Submit" name="command" value="Update">
 </form>
    </body>
</html>