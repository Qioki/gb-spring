<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Andrew
  Date: 20.12.2021
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<h1>Product list</h1>

<ul>
    <jsp:useBean id="products" scope="request" type="java.util.List"/>

    <c:forEach var="product" items="${products}">

        <c:url var="viewUrl" value="/product/ + ${product.id}"/>

        <li>
            <a href="${viewUrl}">View</a>
            <br>
            Product title ${product.title}
            <br>
            Product price ${product.price}
        </li>

    </c:forEach>
</ul>
<br>

<c:url var="createUrl" value="/product/create" />

<a href="${createUrl}">Create</a>

</body>
</html>
