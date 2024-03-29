<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="staffLoginStyle.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Staff Login Page</title>
    </head>
    <body>
        <div class="container" id="container">
            <div class="form-container log-in-container">
                <form action="LoginController" method="POST">
                    <input type="hidden" name="formType" value="staff">
                    <h1>Login</h1>
                    <input type="text" name="empId" placeholder="Employee Id" required/>
                    <input type="password" name="pwd" placeholder="Password" required/> 
                    <button name="action" type="submit" value="Login">Log In</button>
                    <p style="color:red;display:inline-block">${loginMessage}</p>
                </form>
            </div>
            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-right">
                        <h1>STAFF ONLY</h1>
                        <p>CAP COMPANY</p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>