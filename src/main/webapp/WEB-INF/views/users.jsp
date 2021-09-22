<%--
  Created by IntelliJ IDEA.
  User: dferb
  Date: 9/22/2021
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Travel Agency</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <%@include file="header.jsp" %>
    <br>
    <h1>List of users</h1>
    <table class="table table-striped">
        <tr>
            <th>Name</th>
            <th>Role</th>
            <th></th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.fullName}"/></td>
                <td><c:out value="${user.role.toString()}"/></td>
                <td><a href="<c:url value="/booking/all/${user.id}"/>">Bookings</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
