<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="customerLoginStyle.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Customer Login Page</title>
    </head>
    <body>
        <div class="container" id="container">
            <div class="form-container log-in-container">
                <form action="LoginController" method="POST">
                    <input type="hidden" name="formType" value="customer">
                    <h1>Login</h1>
                    <input 
                        id="phone" 
                        name="phone"
                        type="text" 
                        required 
                        pattern="[0-9]{3}[0-9]{3}[0-9]{4}"
                        placeholder="xxx-xxx-xxxx" />
                    <input type="password" name="pwd" placeholder="Password" required/>
<!--                    <a href="#">Forgot your password?</a>-->
                    <button name="action" type="submit" value="Login">Log In</button>
                    <span class='register'>Don't have an account?</span>
                    <span class='register'>Create new account now. <a class="register-btn" href="register.jsp">Register</a></span>
                    <span class="staff-login">Staff Login Only <a class="staff-login-btn" href="staffLogin.jsp">Staff-Login</a></span>
                    <p style="color:red;display:inline-block">${loginMessage}</p>
                </form>
            </div>
            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-right">
                        <h1>Car Store</h1>
                        <p>CAP COMPANY</p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>