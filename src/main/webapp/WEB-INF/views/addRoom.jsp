<%--
  Created by IntelliJ IDEA.
  User: dferb
  Date: 9/23/2021
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Travel Agency</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <h2>Add room</h2>
    <form:form action="/rooms/addRoom" modelAttribute="room" method="post">
        <input type="hidden" name="hotelId" value="${room.id}">
        <p>
            <label for="number">Number</label>
            <form:input path="number" type="number" id="number" placeholder="Number" required="true" min="1"/>
        </p>
        <p>
            <label for="price">Room price</label>
            <form:input path="price" type="number" id="price" placeholder="Price" required="true" min="1"/>
        </p>
        <p>
            <input type="submit" value="Add room">
        </p>
    </form:form>
</div>

</body>
</html>
