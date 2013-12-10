<%-- 
    Document   : Customer
    Created on : Dec 8, 2013, 8:23:38 PM
    Author     : STASСтас
--%>

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
        <% CustomerDAO cd= new CustomerDAO();
        ArrayList<Customer> ac=new ArrayList<Customer>();
        ac=cd.getAllCustomer();
        request.setCharacterEncoding("UTF-8");
        %>
        
        <table border="2">
 <TR>
                    <TH>ID</TH>
                    <TH>Name</TH>
                    <TH>Mobile</TH>
                    <TH>Address</TH>
                </TR>
        <% for(int i=0;i<ac.size();i++){%>

                 <TR>
                     <TD> <%=ac.get(i).getId() %> </TD>
                    <TD> <%=ac.get(i).getName() %> </TD>
                    <TD> <%=ac.get(i).getMobile() %> </TD>
                    <TD> <%=ac.get(i).getAddress() %> </TD>
                </TR>
                <% } %>
</table>

    <body>
        <form action="CustomerServlet" method="POST">
            <table>
    <tr>
        <td>Name:</td>
        <td><input type="text" name="name" value="${Customer.name}"></td>  
    </tr>
    <tr>
        <td>Mobile:</td>
        <td><input type="text" name="mobile" value="${Customer.mobile}"></td>
    </tr>
    
    <tr>
        <td>Address:</td>
        <td><input type="text" name="address" value="${Customer.address}"></td>
    </tr>
    
    <tr>
        <td>Id:</td>
        <td><input type="text" name="id" value="${Customer.id}"></td>
    </tr>
</table>
    <input type="Submit" name="command" value="Add">
    <input type="Submit" name="command" value="Delete">
    <input type="Submit" name="command" value="Update">
 </form>
    </body>
</html>
