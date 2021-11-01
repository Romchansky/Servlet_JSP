<%--
  Created by IntelliJ IDEA.
  User: romka
  Date: 01.11.2021
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html lang="en-us">
<head>
    <title>Create customer</title>
    <style>
        <%@include file="/style.css" %>
    </style>
</head>
<body>
<c:import url="/navigation.jsp"/>
<h3>To Create Customer provide an ID, name, city and industry: </h3>
<form method="post" action="create_customer.jsp">
    <table>
        <tbody>
        <tr>
            <td>
                <p>ID</p>
            </td>
            <td>
                <input type="text" name="id" tabindex="1"></td>
        </tr>
        <tr>
            <td>
                <p>Name</p>
            </td>
            <td>
                <input type="text" name="name" tabindex="1"></td>
        </tr>
        <tr>
            <td>
                <p>City</p>
            </td>
            <td>
                <input type="text" name="city" tabindex="2">
            </td>
        </tr>
        <tr>
            <td>
                <p>Industry</p>
            </td>
            <td>
                <input type="text" name="industry" tabindex="3">
            </td>
        </tr>
        <tr>
        <tr>
        </tbody>
    </table>
    <button type="submit" class="button">Create</button>
</form>
<c:if test="${not empty errors}">
    <c:forEach items="${errors}" var="error">
        <p style="color: red">${error.field} ${error.error}</p><br>
    </c:forEach>
</c:if>
<c:if test="${not empty message}">
    <p style="color: #4e8b3d">${message}</p><br>
</c:if>
</body>
</html>