<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="staff/manageCarStyle.css"/>
        <title>Manage Car</title>
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
                    String currentUser = (String) request.getSession().getAttribute("employeeName");
                %>
                <div class="customer-page">
                    <a class="customer-link" href="customer/customerInfo.jsp"><%=currentUser%></a>
                    <div id="customer-dropdown" class="dropdown-content">
                        <a href="LogoutController?action=logout" class="logout">Logout</a>
                    </div>
                </div>
            </div>
        </nav>


        <div class="manage-warehouse">
            <h1>All Cars</h1>
            <form action="CarController" method="GET">
                <input type="text" name="search" placeholder="Search by Car Name">
                <input type="submit" value="Search">
            </form>

            <table>
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
                    <th>Quantity</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${carList}" var="car">
                    <tr>
                        <td id="carId_${car.carId}">${car.carId}</td>
                        <td id="model_${car.carId}">${car.model}</td>
                        <td id="date_${car.carId}">${car.date}</td>
                        <td id="VIN_${car.carId}">${car.VIN}</td>
                        <td id="colour_${car.carId}">${car.colour}</td>
                        <td id="licensePlate_${car.carId}">${car.licensePlate}</td>
                        <td id="make_${car.carId}">${car.make}</td>
                        <td id="location_${car.carId}">${car.location}</td>
                        <td id="price_${car.carId}">${car.price}</td>
                        <td id="quantity_${car.carId}">${car.quantity}</td>
                        <td>
                            <form>
                                <input type="button" value="Edit" onclick="toggleInputs('${car.carId}', this)">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>


        <footer>
            <p>&copy; 2024 Nonobeam page. All rights reserved.</p>
        </footer>

        <script>
            function toggleInputs(carId, button) {
                var attributes = ['model', 'date', 'VIN', 'colour', 'licensePlate', 'make', 'location', 'price', 'quantity'];
                for (var i = 0; i < attributes.length; i++) {
                    var tdElement = document.getElementById(attributes[i] + '_' + carId);
                    if (tdElement.children.length === 0) {
                        var inputElement = document.createElement('input');
                        inputElement.type = 'text';
                        inputElement.name = attributes[i];
                        inputElement.value = tdElement.innerText;
                        inputElement.readOnly = true;
                        tdElement.innerHTML = '';
                        tdElement.appendChild(inputElement);
                    } else {
                        var inputElement = tdElement.children[0];
                        tdElement.innerHTML = inputElement.value;
                    }
                }
                if (button.value === 'Edit') {
                    button.value = 'Save';
                } else {
                    button.value = 'Edit';
                }
            }
        </script>
    </body>
</html>
