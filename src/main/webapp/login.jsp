
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
 <h1>Pentagon Space</h1>
        <h2>Login</h2>
        <%String success=(String)request.getAttribute("success"); %>
        <%if(success!=null){%>
        <h3 class="success"><%=success %></h3>
        <%} %>
        <form action="login" method="post">
            <lable>Enter your mail ID:</lable>
<input type="mail" name="mail"><br><br> 
 <lable>Enter the password:</lable>
<input type="password" name="password"><br><br> 
 
<input type="submit" value="Login"> <a href="Resetpassword.html">forgot password</a><br> <br>Don't have a account?<a href="signup.html
">signup</a>

  

</body>
</html>