<%--
  Created by IntelliJ IDEA.
  User: dferb
  Date: 9/21/2021
  Time: 11:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Travel Agency</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Add hotel</h1>
    <form:form action="${contextPath}/hotels/addHotel" modelAttribute="hotel" method="post">
        <label for="hotelName">Hotel name</label>
        <form:input path="hotelName" type="text" id="hotelName" placeholder="Hotel name" required="true"/>
        <br />
        <label for="countryName">Country name</label>
        <select name="countryName" id="countryName">
            <c:forEach var="c" items="${countryList}">
                <option value="${c.id}">${c.name}</option>
            </c:forEach>
        </select>
        <br />
        <input type="submit" value="Add hotel">

    </form:form>
</div>
</body>
</html>
