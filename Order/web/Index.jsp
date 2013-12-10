<%-- 
    Document   : index
    Created on : Dec 8, 2013, 8:22:06 PM
    Author     : STASСтас
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="models.Print_Orders"%>
<%@page import="models.ejb.Print_OrderDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <% Print_OrderDAO pd=new Print_OrderDAO();
        ArrayList<Print_Orders> ao=new ArrayList<Print_Orders>();
        ao=pd.getPrintOrders();
        request.setCharacterEncoding("UTF-8");
        %>
        
        <table border="2">
 <TR>
                    <TH>№</TH>
                    <TH>Номер заказа</TH>
                    <TH>Имя заказчика</TH>
                    <TH>Телефон заказчика</TH>
                    <TH>Адрес заказчика</TH>
                    <TH>Дата заказа</TH>
                    <TH>Кол-во</TH>
                    <TH>Сумма платежа</TH>
                    <TH>Номер счета</TH>
                    <TH>Продукт</TH>
                </TR>
        <% for(int i=0;i<ao.size();i++){%>

                 <TR>
                     <TD> <%=ao.get(i).getID() %> </TD>
                    <TD> <%=ao.get(i).getNumber() %> </TD>
                    <TD> <%=ao.get(i).getCustomerName() %> </TD>
                    <TD> <%=ao.get(i).getCustomerMobile() %> </TD>
                    <TD> <%=ao.get(i).getCustomerAddress() %> </TD>
                    <TD> <%=ao.get(i).getDateOrder() %> </TD>
                    <TD> <%=ao.get(i).getSumm() %> </TD>
                    <TD> <%=ao.get(i).getPaymentSumm() %> </TD>
                    <TD> <%=ao.get(i).getPaymentBill() %> </TD>
                    <TD> <%=ao.get(i).getProductName() %> </TD>
                </TR>
                <% } %>
</table>
    <body>
        <a href="Customer.jsp">CUSTOMERS</a>;
        <a href="Payment.jsp">PAYMENTS</a>;
        <a href="Product.jsp">PRODUCT</a>;
        <a href="Orders.jsp">ORDERS</a>;
    </body>
</html>
