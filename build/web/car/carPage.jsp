<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Car Info</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="car/carPageStyle.css">
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
                    <a class="customer-link" href="customer/customerInfo.jsp"><%=currentUser%></a>
                    <div id="customer-dropdown" class="dropdown-content">
                        <a href="../LogoutController?action=logout" class="logout">Logout</a>
                    </div>
                </div>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-4">
                    <img src="${car.imageUrl}" alt="${car.model}" class="img-fluid">
                </div>
                <div class="col-md-8">
                    <div class="row">
                        <div class="col-md-12">
                            <h2>Car Details</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <p><strong>Model:</strong> ${car.model}</p>
                            <p><strong>Date:</strong> ${car.date}</p>
                            <p><strong>VIN:</strong> ${car.VIN}</p>
                            <p><strong>Colour:</strong> ${car.colour}</p>
                        </div>
                        <div class="col-md-6">
                            <p><strong>License Plate:</strong> ${car.licensePlate}</p>
                            <p><strong>Make:</strong> ${car.make}</p>
                            <p><strong>Location:</strong> ${car.location}</p>
                            <p><strong>Recommend Price:</strong> ${car.price}</p>
                            <p><strong>Quantity:</strong> ${car.quantity}</p>
                        </div>
                    </div>
                    <div class="row">
                        <span><strong>Detail</strong></span>
                        <span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu tortor vitae nulla tempor sagittis non in urna. Vivamus quis feugiat quam, id rhoncus nunc. Etiam nibh justo, ullamcorper vitae nunc ut, scelerisque facilisis sapien. Integer eleifend eget justo tempor gravida. In dictum, dui quis faucibus bibendum, ligula nulla porttitor sapien, at pulvinar nisi odio non ex. Vivamus bibendum in diam eu iaculis. Duis tellus lorem, semper vel auctor vel, condimentum sed mauris. Nam dictum bibendum risus, at ultricies massa ultrices quis. Aenean hendrerit felis vitae sem porta consequat. Praesent auctor arcu sit amet purus scelerisque tincidunt. Morbi suscipit lacinia ligula, eu dapibus ligula consectetur ac. Vivamus sit amet dolor ut nibh suscipit ullamcorper. Integer volutpat mauris quis metus facilisis, nec convallis erat gravida. Suspendisse convallis eleifend tellus.</span>
                    </div>
                    <form action="CarController?action=buy" method="post">
                        <input type="hidden" name="carId" value="${carId}">
                        <input type="hidden" name="customerId" value="${customerId}">
                        <button type="submit">Buy Now</button>
                    </form>
                </div>
            </div>
        </div>

        <footer>
            <p>&copy; 2024 Nonobeam page. All rights reserved.</p>
        </footer>

    </body>
</html>