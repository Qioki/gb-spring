<%@ page import="com.example.l1.entity.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<H1>Product list:</H1>


<%--<c:forEach items="${productList}" var="ListItem">--%>
<%--    <li>${ListItem.name}</li>--%>
<%--</c:forEach>--%>
<table>
    <tr>
        <td>Id</td>
        <td>Title</td>
        <td>Cost</td>
    </tr>
<%
    ArrayList<Product> productList = (ArrayList<Product>) (request.getAttribute("productList"));

    for (Product product : productList)
    {
%>
        <tr>
            <td><%=product.getId()%></td>
            <td><%=product.getTitle()%></td>
            <td><%=product.getCost()%></td>
        </tr>
<%
    }
%>

</table>
</body>
</html>
