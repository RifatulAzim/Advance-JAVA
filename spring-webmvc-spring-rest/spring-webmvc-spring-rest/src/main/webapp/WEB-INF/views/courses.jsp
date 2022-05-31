<%--
  Created by IntelliJ IDEA.
  User: kawsu
  Date: 11/29/2021
  Time: 11:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.util.SortUtils" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Courses List</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Courses List</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <input type="button" value="Home"
               onclick="window.location.href='../users/home'; return false;"
               class="add-button">

        <br><br>



        <table>
            <tr>
                <th>Course Name</th>

                <th>Action</th>
            </tr>

            <c:forEach var="course" items="${courses}">

                <tr>
                    <td> ${course.cname} </td>

                    <td>
                        <a href="${updateLink}">Add</a>
                    </td>
                </tr>

            </c:forEach>

        </table>

    </div>

</div>

</body>
</html>
