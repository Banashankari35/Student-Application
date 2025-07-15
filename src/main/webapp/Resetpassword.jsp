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
        <h2>Reset your password here</h2>
        <%String error=(String)request.getAttribute("error"); %>
        <%if(error!=null){%>
        <h3 class="error"><%=error%></h3>
        <%} %>
        <form action="Resetpassword" method="post">
            <lable>Enter the Phone number:</lable>
<input type="number" name="phone"><br><br> 
<lable>Enter the Mail ID:</lable>
<input type="text" name="mail"><br><br>
<lable>Enter the Password</lable>
<input type="password" name="password"><br><br>
<lable>Confirm the password</lable>
<input type="password" name="confirm"> <br> <br>
<input type="submit" value="Reset Password"><br><br><a href="Back">Back</a>
</form>
</body>
</html>