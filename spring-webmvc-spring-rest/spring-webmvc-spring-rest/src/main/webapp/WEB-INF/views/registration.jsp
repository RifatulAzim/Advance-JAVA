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
        <h2>Registration</h2>
    </div>
</div>

<div id="container">
    <h3>Enter your details here!</h3>
    <form:form action="register" modelAttribute="users" method="POST">
        <form:hidden path="id"/>
        <table>
            <tbody>
             <tr>
                    <td><label>Name:</label></td>
                    <td><form:input path="name"/></td>
             </tr>
            <tr>
                <td><label>Email:</label></td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td><label>Password:</label></td>
                <td><form:input path="password"/></td>
            </tr>
            <tr>
                <td><label></label></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Register" class="login"/></td>
            </tr>
            </tbody>
        </table>
    </form:form>
    <div style="clear: both;"></div>

    <p>
        <a href="${pageContext.request.contextPath}/users/login-form">Already has an account?</a>
    </p>

</div>
</body>
</html>










