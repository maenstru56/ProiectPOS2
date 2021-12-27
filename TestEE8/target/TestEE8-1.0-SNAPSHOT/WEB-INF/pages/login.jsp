<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Login">
    <html>
        <head>
            <c:if test="${login_error_message != null}">
            <div class="alert alert-warning" role="alert">
                ${login_error_message}
            </div>
            </c:if>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/loginstyle.css" type="text/css">
        </head>
        <body>
            <div class="wrapper">
                <div class="title"> Login </div>
                <form action="Login" method="POST">
                    <div class="field">
                        <input type="text" id="username" name="username" required>
                        <label>Username</label>
                    </div>
                    <div class="field">
                        <input type="password" id="password" name="password" required>
                        <label>Password</label>
                    </div>
                    <div class="field">
                        <input type="submit" value="Login">
                    </div>
                </form>
            </div>
        </body>
    </html>
</t:pageTemplate>




