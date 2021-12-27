<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Andrew
  Date: 20.12.2021
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>

<%--@elvariable id="product" type="com.example.l3.entity.Product"--%>
<form:form action="create" modelAttribute="product">

    <form:hidden path="id" value="${product.id}" />

    Title: <form:input path="title" />
    <br>
    Price: <form:input path="price" />

    <br>
    <input type="submit" value="Submit">

</form:form>
</body>
</html>
