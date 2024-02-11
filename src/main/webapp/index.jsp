<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Todo app</title>
</head>
<body>
<h1><%= "Welcome to Todo app!" %>
</h1>

<form action="todo" method="post">
    <h2>Enter your next todo details:</h2>
    Enter todo title: <input type="text" name="title" size="20"> <br /> <br />
    Enter todo description: <input type="text" name="description" size="20"> <br /><br />
    <input type="submit" value="Create" />
</form>

</body>
</html>