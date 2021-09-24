<%--
  Created by IntelliJ IDEA.
  User: dferb
  Date: 9/24/2021
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Travel agency</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <div>
        <%@include file="header.jsp" %>
        <br>
        <h2>All Rooms</h2>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Room id</th>
                <th>Room number</th>
                <th>Room price</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="room" items="${rooms}">
                <tr>
                    <td align="center" >${room.id}</td>
                    <td align="center" >${room.number}</td>
                    <td align="center">${room.price}</td>
                </tr>
                <c:set var="hotelId" value="${room.hotel.id}"/>
            </c:forEach>
            </tbody>
        </table>
        <p><a href="<c:url value="${contextPath}/rooms/add/${hotelId}"/>">Add room</a></p>
    </div>
</div>
</body>
</html>
