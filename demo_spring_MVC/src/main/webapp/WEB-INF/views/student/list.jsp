<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 6/17/2025
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${mess!=null}">
    <p>${mess}</p>
</c:if>
<table>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Subject</th>
        <th>Classname</th>
        <th>RP-Detail</th>
        <th>PV-Detail</th>
    </tr>
    <c:forEach items="${studentList}" var="student" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.gender}</td>
            <td>
            <c:forEach items="${student.subjects}" var="subject">
                <span>${subject} </span>
            </c:forEach>
            </td>
            <td>${student.name}</td>
            <td>${student.className}</td>
            <td><a href="/students/detail?id=${student.id}">Detail1</a></td>
            <td><a href="/students/detail/${student.id}">Detail2</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
