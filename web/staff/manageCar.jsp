<%@page import="java.util.List"%>
<%@page import="dto.car.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="staff/manageCarStyle.css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/05ec024090.js" crossorigin="anonymous"></script>
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
            <div class="search-box">
                <form action="StaffController" method="GET">
                    <input type="hidden" name="action" value="search">
                    <input type="text" name="query" placeholder="Search..">
                    <button class="search-btn" type="submit"><i class="fa-solid fa-magnifying-glass" style="color: #ffffff;"></i></button>
                </form>
            </div>
        </nav>



        <%
            List<Car> cars = (List<Car>) request.getAttribute("search");
        %>

        <p style="position: relative;top: 110px;left: 200px;color: black;display:inline-block">${searchMessage}</p>


        <div class="manage-warehouse">
            <table>
                <tr>
                    <th>NO.</th>
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
                <%
                    int count = 0;
                    if (cars != null) {
                        for (Car c : cars) {
                            count++;
                %>
                <form action="StaffController">
                    <tr class="choosenRow">
                        <td><%= count%></td>
                        <td><input type="text" name="carId" value="<%= c.getCarId()%>"></td>
                        <td><input type="text" name="model" value="<%= c.getModel()%>"></td>
                        <td><input type="text" name="date" value="<%= c.getDate()%>"></td>
                        <td><input type="text" name="VIN" value="<%= c.getVIN()%>"></td>
                        <td><input type="text" name="colour" value="<%= c.getColour()%>"></td>
                        <td><input type="text" name="licensePlate" value="<%= c.getLicensePlate()%>"></td>
                        <td><input type="text" name="make" value="<%= c.getMake()%>"></td>
                        <td><input type="text" name="location" value="<%= c.getLocation()%>"></td>
                        <td><input type="text" name="price" value="<%= c.getPrice()%>"></td>
                        <td><input type="text" name="quantity" value="<%= c.getQuantity()%>"></td>
                        <td><input type="text" name="imageUrl" value="<%= c.getImageUrl()%>"></td>
                        <td>
                            <input type="submit" name="action" value="edit">
                        </td>
                    </tr>
                </form>
                <%
                        }
                    }
                %>
            </table>
        </div>


        <footer>
            <p>&copy; 2024 Nonobeam page. All rights reserved.</p>
        </footer>
    </body>
</html>
