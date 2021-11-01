<%--
  Created by IntelliJ IDEA.
  User: romka
  Date: 01.11.2021
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en-us">
<head>
    <title>Developer by language</title>
    <style>
        <%@include file="/style.css" %>
    </style>
</head>
<body>
<c:import url="/navigation.jsp"/>
<h3>To find the developers by language enter the language like 'Java' or 'JS'</h3>
<form method="post" action="get_language.jsp">
    <table>
        <tbody>
        <tr>
            <td>
                <p>Enter the programming language</p>
            </td>
            <td>
                <input type="text" name="language" tabindex="1"></td>
        </tr>
        </tbody>
    </table>
    <button type="submit" class="button">Find</button>
</form>
<c:if test="${not empty message}">
    <p style="color: darkslateblue">${message}</p><br>
</c:if>
</body>
</html>
