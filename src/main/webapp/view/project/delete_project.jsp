<%--
  Created by IntelliJ IDEA.
  User: romka
  Date: 01.11.2021
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en-us">
<head>
    <title>Delete Project</title>
    <style>
        <%@include file="/view/style.css" %>
    </style>
</head>
<body>
<c:import url="/view/navigation.jsp"/>
<h3>To delete Project, provide an ID: </h3>
<form method="post" action="deleteProject">
    <table>
        <tbody>
        <tr>
            <td>
                <p>Project ID: </p>
            </td>
            <td><input type="number" name="id"></td>
        </tr>
        </tbody>
    </table>
    <button type="submit" class="button">Delete</button>
</form>
<c:if test="${not empty message}">
    <p style="color: darkslateblue">${message}</p><br>
</c:if>
</body>
</html>