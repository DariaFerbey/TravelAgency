<%--
  Created by IntelliJ IDEA.
  User: dferb
  Date: 9/22/2021
  Time: 6:04 PM
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
    <h2>Management</h2>
    <table class="table table-sm">
        <p><a href="/hotels/hotelList">Hotels</a></p>
        <p><a href="/users/all">Users</a></p>
    </table>
</div>
</body>
</html>
