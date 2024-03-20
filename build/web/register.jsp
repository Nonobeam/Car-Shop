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
            <span class="login">Already have an account? <a class="login-btn" href="login.jsp">Login</a></span>
            <div class="form-container log-in-container">
                <!--                id, name, age, address-->
                <form action="RegisterController">
                    <h1>Sign up</h1>
                    Name: <input type="text" name="name" required=""><br>
                    Password: <input type="password" name="pwd" required=""><br>
                    Phone: <input 
                        id="phone" 
                        name="phone"
                        type="text" 
                        required 
                        pattern="[0-9]{3}[0-9]{3}[0-9]{4}"
                        placeholder="xxx-xxx-xxxx" />
                    <br>                
                    Birth Date: <input type="date" name="birth" required=""><br>
                    Address: <input type="text" name="address" required=""><br>
                    <button type="submit" name="action" value="register">Sign up</button>
                    <p style="position: relative; top: 30px;color:blue;display:inline-block;">${noti}</p>
                </form>
            </div>
        </div>
    </body>
</html>