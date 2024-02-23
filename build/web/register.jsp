<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="registerStyle.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Register</title>
    </head>
    <body>
        <div class="container" id="container">
            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-right">
                        <h1>Car Store</h1>
                        <p>CAP COMPANY</p>
                    </div>
                </div>
            </div>
            <div class="form-container log-in-container">
<!--                id, name, age, address-->
                <form action="RegisterController" method="POST">
                    <h1>Sign up</h1>
                    <span class="login">Already have an account? <a class="login-btn" href="login.jsp">Login</a></span>
                    Name: <input type="text" name="name" required=""><br>
                    Password: <input type="password" name="pwd" required=""><br>
                    Phone: <input type="text" name="phone" required=""><br>                
                    Birth Date: <input type="date" name="birth" required=""><br>
                    Address: <input type="text" name="address" required=""><br>
                    <button type="submit" name="action" value="register">Sign up</button>
                </form>
            </div>
        </div>
        <p style="margin-top:20px; margin-left: 200px;color:black;display:inline-block;">${noti}</p>
    </body>
</html>