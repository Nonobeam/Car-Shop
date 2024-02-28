<%@page import="java.util.List"%>
<%@page import="dto.car.Car"%>
<%@page import="dao.carDAO"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Customer</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="customer/customerInforStyle.css">
        <script src="https://kit.fontawesome.com/05ec024090.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <header>
        </header>

        <nav class="dropdownmenu">
            <div class="navigation">
                <div>
                    <a href="main.jsp" class="logo" style="text-decoration:none">CAR</a>
                </div>
                
                <%
                    String currentUser = (String) request.getSession().getAttribute("customerName");
                %>
                <div class="customer-page">
                    <a class="customer-link" href="customer/customerInfo.jsp">${customer.customerName}</a>
                    <div id="customer-dropdown" class="dropdown-content">
                        <a href="../LogoutController?action=logout" class="logout">Logout</a>
                    </div>
                </div>
            </div>
        </nav>

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
                                                <td>${customer.customerName}</td>
                                            </tr>
                                            <tr>
                                                <td>Phone:</td>
                                                <td>${customer.phone}</td>
                                            </tr>
                                            <tr>
                                            <tr>
                                                <td>Birth:</td>
                                                <td>${customer.birth}</td>
                                            </tr>
                                            <tr>
                                                <td>Home Address:</td>
                                                <td>${customer.address}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

                                            
        <%
            // Assuming you have already retrieved the customerId
            String customerId =  (String) request.getSession().getAttribute("customerId");

            // Create an instance of your DAO class
            carDAO dao = new carDAO();

            // Get all cars by customer ID
            List<Car> cars = dao.getAllCarByCustomerId(customerId);
        %>

        <h1>Cars Owned by Customer</h1>

        <%
            // Check if there are cars for the customer
            if (cars.isEmpty()) {
        %>
        <p>No cars found for this customer.</p>
        <%
        } else {
        %>
        <table border="1">
            <tr>
                <th>Car ID</th>
                <th>Model</th>
                <th>Date</th>
                <th>VIN</th>
                <th>Colour</th>
                <th>License Plate</th>
                <th>Make</th>
                <th>Location</th>
                <th>Price</th>
                <!-- Add more columns if needed -->
            </tr>

            <%
                // Iterate over the list of cars and display their details
                for (Car car : cars) {
            %>
            <tr>
                <td><%= car.getCarId()%></td>
                <td><%= car.getModel()%></td>
                <td><%= car.getDate()%></td>
                <td><%= car.getVIN()%></td>
                <td><%= car.getColour()%></td>
                <td><%= car.getLicensePlate()%></td>
                <td><%= car.getMake()%></td>
                <td><%= car.getLocation()%></td>
                <td><%= car.getPrice()%></td>
                <!-- Add more columns if needed -->
            </tr>
            <%
                }
            %>
        </table>
        <%
            }
        %>                                   
        
        
        <footer>
            <p>&copy; 2024 Nonobeam page. All rights reserved.</p>
        </footer>

    </body>
</html>

