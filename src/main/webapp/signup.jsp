<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=<device-width>, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
   
        <h1>Pentagon Space</h1>
        <h2>Application form</h2>
        <%String error=(String)request.getAttribute("error"); %>
        <%if(error!=null){%>
        <h3 class="error"><%=error%></h3>
        <%} %>
        
        <form action="signup" method="post">
            <lable>Enter your Name:</lable>
<input type="text" name="name"><br><br>

<lable>Enter the Phone number:</lable>
<input type="number" name="phone"><br><br>

<lable>Enter the Mail ID:</lable>
<input type="mail" name="mail" ><br> <br>

<lable>Enter the Branch</lable>
<input type="text" name="branch"> <br> <br>

<lable>Enter the Location</lable>
<input type="text" name="loc"> <br> <br>

<lable>Enter the password</lable>
<input type="password" name="password"> <br> <br>

<lable>Confirm the password</lable>
<input type="password" name="confirm"> <br> <br>
<button type="submit">create Account</button><br><br>
<p>already have an account?</p>
<a href="login.html">login</a>


    </form>
</body>
</html>