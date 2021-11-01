<%--
  Created by IntelliJ IDEA.
  User: romka
  Date: 01.11.2021
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en-us">
<head>
    <title>Update Project</title>
    <style>
        <%@include file="/style.css" %>
    </style>
</head>
<body>
<c:import url="/navigation.jsp"/>
<h3>To update Project, provide an ID and new cost: </h3>
<form method="post" action="update_project.jsp">
    <table>
        <tbody>
        <tr>
            <td>
                <p>Project ID:</p>
            </td>
            <td><input type="number" name="id"></td>
        </tr>
        <tr>
            <td>
                <p>New cost: </p>
            </td>
            <td><input type="number" name="cost"></td>
        </tr>
        </tbody>
    </table>
    <button type="submit" class="button">Update</button>
</form>
<c:if test="${not empty message}">
    <p style="color: darkslateblue">${message}</p><br>
</c:if>
</body>
</html>