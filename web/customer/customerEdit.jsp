<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Customer edit profile</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="customerEditStyle.css">
        <script src="https://kit.fontawesome.com/05ec024090.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <header>
        </header>

        <nav class="dropdownmenu">
            <div class="navigation">
                <div>
                    <a href="../main.jsp" class="logo" style="text-decoration:none">CAR</a>
                </div>

                <%
                    String currentUser = (String) request.getSession().getAttribute("customerName");
                %>
                <div class="customer-page">
                    <a class="customer-link" href="customer/customerInfo.jsp"><%=currentUser%></a>
                    <div id="customer-dropdown" class="dropdown-content">
                        <a href="../LogoutController?action=logout" class="logout">Logout</a>
                    </div>
                </div>
            </div>
        </nav>


        <form action="../CustomerController">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a class="customer-link">${customer.customerName}</a></h3>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="https://cdn-icons-png.flaticon.com/512/6596/6596121.png" class="img-circle img-responsive"> </div>
                                    <div class=" col-md-9 col-lg-9 ">
                                        <table class="table table-user-information">
                                            <!--                                        id, customerName, password, phone, int age, address-->
                                            <tbody>
                                                <tr>
                                                    <td>Name:</td>
                                                    <td><input type="text" name="customerName" value="${customer.customerName}"></td>
                                                </tr>
                                                <tr>
                                                    <td>Phone:</td>
                                                    <td><input type="text" name="phone" value="${customer.phone}"></td>
                                                </tr>
                                                <tr>
                                                    <td>Birth:</td>
                                                    <td><input type="date" name="birth" value="${customer.birth}"></td>
                                                </tr>
                                                <tr>
                                                    <td>Home Address:</td>
                                                    <td><input type="text" name="address" value="${customer.address}"></td>
                                                </tr>
                                            </tbody> 
                                        </table>
                                        <input type="hidden" name="customerId" value="${customer.customerId}"></td>
                                        <input type="submit" name="action" value="edit">
                                        <p style="color:red;display:inline-block">${editMessage}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>


                    
        <footer>
            <p>&copy; 2024 Nonobeam page. All rights reserved.</p>
        </footer>

    </body>
</html>