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
                    <div class="buy-box">
                        <button class="btn btn-primary" id="buyNowBtn">Buy Now</button>
                    </div>
                </div>
            </div>
        </div>


        <!-- Modal -->
        <div class="modal fade" id="confirmationModal" tabindex="-1" role="dialog" aria-labelledby="confirmationModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="confirmationModalLabel">Confirm Purchase</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Are you sure you want to buy this car?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="button" class="btn btn-primary" id="confirmPurchaseBtn">Yes, Buy Now</button>
                    </div>
                </div>
            </div>
        </div>


        <footer>
            <p>&copy; 2024 Nonobeam page. All rights reserved.</p>
        </footer>

        <script>
            // JavaScript
            document.getElementById('buyNowBtn').addEventListener('click', function () {
                $('#confirmationModal').modal('show'); // Show the modal
            });

            document.getElementById('confirmPurchaseBtn').addEventListener('click', function () {
                // You can perform any additional actions here, such as submitting a form or making an AJAX request
                alert('Car purchased successfully!');
                $('#confirmationModal').modal('hide'); // Hide the modal after purchase is confirmed
            });
        </script>
    </body>
</html>