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
                    <a class="customer-link" href="customer/customerInfo.jsp">HI <%=currentUser%>, wish you a good day</a>
                    <div id="customer-dropdown" class="dropdown-content">
                        <a href="LogoutController?action=logout" class="logout">Logout</a>
                    </div>
                </div>
            </div>
        </nav>


        <div class="manage-warehouse">
            <h1>All Cars</h1>
            <form action="CarController" method="GET">
                <input class="search-box" type="text" name="search" placeholder="Search by Car Name">
                <input type="submit" value="Search">
            </form>

            <p style="color:red;display:inline-block">${message}</p>
            
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
                    <th>Image</th>
                    <th>Edit</th>
                </tr>
                <form action="CarController">
                    <c:forEach items="${carList}" var="car">
                        <tr>
                            <td><input type="text" name="carId" value=${car.carId}></td>
                            <td><input type="text" name="model" value="${car.model}"></td>
                            <td><input type="text" name="date" value="${car.date}"></td>
                            <td><input type="text" name="VIN" value="${car.VIN}"></td>
                            <td><input type="text" name="colour" value="${car.colour}"></td>
                            <td><input type="text" name="licensePlate" value="${car.licensePlate}"></td>
                            <td><input type="text" name="make" value="${car.make}"></td>
                            <td><input type="text" name="location" value="${car.location}"></td>
                            <td><input type="text" name="price" value="${car.price}"></td>
                            <td><input type="text" name="quantity" value="${car.quantity}"></td>
                            <td><input type="text" name="imageUrl" value="${car.imageUrl}"></td>
                            <td>
                                <input type="submit" value="Edit">
                            </td>
                        </tr>
                    </c:forEach>
                </form>
            </table>
        </div>


        <footer>
            <p>&copy; 2024 Nonobeam page. All rights reserved.</p>
        </footer>
    </body>
</html>
