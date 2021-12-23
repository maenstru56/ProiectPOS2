<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
    <a href="hello-servlet">Hello Servlet</a>

    <form method = "post" action = "AddUser">
        <div>
            <input type="text" name="username" />
        </div>
        <div>
            <input type="password" name="password" />
        </div>
        <div>
            <select name="role" name="role">
                <option value="1">Cashier</option>
                <option value="2">Director</option>
                <option value="3">Admin</option>
            </select>
        </div>
        <div>
            <input type="email" name="email" />
        </div>
        <div>
            <input type="submit" value="Add" />
        </div>
    </form>
</body>
</html>