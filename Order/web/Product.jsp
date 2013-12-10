<%-- 
    Document   : Product
    Created on : Dec 10, 2013, 2:02:01 PM
    Author     : STASСтас
--%>

<%@page import="models.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.ejb.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <table>
        <% ProductDAO pd=new ProductDAO();
        ArrayList<Product> ap=new ArrayList<Product>();
        ap=pd.getAllPayments();
        request.setCharacterEncoding("UTF-8");
        %>
        
        <table border="2">
 <TR>
                    <TH>ID</TH>
                    <TH>Name</TH>
                </TR>
        <% for(int i=0;i<ap.size();i++){%>

                 <TR>
                     <TD> <%=ap.get(i).getId() %> </TD>
                    <TD> <%=ap.get(i).getName() %> </TD>
                </TR>
                <% } %>
</table>
    </body>
</html>
