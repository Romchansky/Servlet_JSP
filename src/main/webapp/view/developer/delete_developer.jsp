<%--
  Created by IntelliJ IDEA.
  User: romka
  Date: 01.11.2021
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en-us">
<head>
    <title>Delete Developer</title>
    <style>
        <%@include file="/view/style.css" %>
    </style>
</head>
<body>
<c:import url="/view/navigation.jsp"/>
<h3>To delete Developer, provide an ID: </h3>
<form method="post" action="deleteDeveloper">
    <table>
        <tbody>
        <tr>
            <td>
                <p>Developer ID: </p>
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
