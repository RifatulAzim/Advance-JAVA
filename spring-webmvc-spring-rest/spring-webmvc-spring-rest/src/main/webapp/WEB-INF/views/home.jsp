<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>
    <title>Save User</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-user-style.css">
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>Home</h2>
    </div>
</div>

<div id="container">
    <h3>Select an option!</h3>

    <input type="button" value="Add Courses"
                       onclick="window.location.href='../courses/list'; return false;"
                       class="add-button">

    <input type="button" value="Log out"
                   onclick="window.location.href='login-form'; return false;"
                   class="add-button">

    <div style="clear: both;"></div>



</div>
</body>
</html>










