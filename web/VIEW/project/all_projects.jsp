<%--
  Created by IntelliJ IDEA.
  User: romka
  Date: 01.11.2021
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en-us">
<head>
  <title>View all projects</title>
  <style>
    <%@include file="/style.css" %>
  </style>
</head>
<body>
<c:import url="/navigation.jsp"/>
<table>
  <tbody>
  <c:if test="${not empty projects}">
    <table class="table">
      <thead>
      <tr>
        <th>ID</th>
        <th>Project Name</th>
        <th>Field</th>
        <th>Cost</th>
        <th>Create Date</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${projects}" var="project">
        <tr>
          <td>
            <c:out value="${project.id}"/>
          </td>
          <td>
            <c:out value="${project.name}"/>
          </td>
          <td>
            <c:out value="${project.field}"/>
          </td>
          <td>
            <c:out value="${project.cost}"/>
          </td>
          <td>
            <c:out value="${project.create_date}"/>
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