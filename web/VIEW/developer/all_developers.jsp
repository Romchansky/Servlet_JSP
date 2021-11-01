<%--
  Created by IntelliJ IDEA.
  User: romka
  Date: 01.11.2021
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en-us">
<head>
    <title>Developers list</title>
    <style>
        <%@include file="/style.css" %>
    </style>
</head>
<body>
<c:import url="/navigation.jsp"/>
<table>
    <tbody>
    <c:if test="${not empty developers}">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Gender</th>
                <th>Salary</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${developers}" var="developer">
                <tr>
                    <td>
                        <c:out value="${developer.id}"/>
                    </td>
                    <td>
                        <c:out value="${developer.name}"/>
                    </td>
                    <td>
                        <c:out value="${developer.age}"/>
                    </td>
                    <td>
                        <c:out value="${developer.gender}"/>
                    </td>
                    <td>
                        <c:out value="${developer.salary}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    </tbody>
</table>
</body>
</html>
