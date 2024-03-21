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
        <style>
            body, h1, h2, h3, p, ul, li {
                margin: 0;
                padding: 0;
            }

            body {
                background: #f3e0e2;
                height: fit-content;
                font-family: 'Montserrat', sans-serif;
                margin: 0;
            }

            header {
            }

            .user-info {
            }

            .search-box {
                margin: 0 auto; /* Center the search box horizontally */
            }

            .dropdownmenu {
                position: fixed;
                top: 0;
                background: #ff4b2b;
                display: flex;
                flex-direction: column;
                height: 110px;
                width: 100%;
                z-index: 9;
            }

            .navigation{
                padding-top: 10px;
                display: flex;
                align-items: center;
                justify-content: space-between;
            }

            .logo {
                color: white;
                font-weight: bold;
                font-size: 30px;
                padding-left: 80px;
            }

            .logo::before{
                content: "SHOP";
                color: blue;
            }

            .logo:hover{
                color: green;
            }

            .menu-items {
                list-style: none;
                margin: 0;
                padding: 0;
                display: flex;
            }

            .menu-items li {
                margin-left: 20px;
                position: relative;
            }

            .dropdownmenu .menu-items li a {
                font-size: 14px;
                font-weight: bold;
            }

            .dropdownmenu li:hover a {
                color: #e6e6e6;
                text-decoration:none;
            }

            #submenu {
                left: 0;
                opacity: 0;
                position: absolute;
                top: 35px;
                visibility: hidden;
                z-index: 1;
            }

            li:hover ul#submenu {
                opacity: 1;
                top: 40px;
                visibility: visible;
            }

            #submenu li {
                width: 100%;
            }

            #submenu a:hover {
                background: #DF4B05;
            }

            #submenu a {
                background-color: #000000;
            }

            .register-login a:hover {
                color: red; /* Change color on hover */
            }

            .register-login a + a {
                margin-left: 5px; /* Adjust spacing between register and login links */
            }

            .customer-page {
                position: relative;
                display: inline-block;
            }

            .dropdown-content{
                display: none;
                position: absolute;
                background-color: white;
                min-width: 120px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1;
            }

            .dropdown-content a{
                display: block;
            }

            .dropdown-content>a:hover{
                background-color: #ff816a;
            }

            .customer-link{
                color: white;
                text-decoration: none;
                font-weight: bold;
                padding-right: 20px;
            }

            .customer-page:hover .dropdown-content{
                display: block;
                z-index: 1000;
            }

            .customer-btn{
                color: white;
            }

            .logout {
                display: inline;
            }

            .search-form{
                position: relative;
                top: 80px;
            }

            .manage-warehouse {
                position: relative;
                top: 100px;
                padding-bottom: 100px;
                text-align: center;
            }

            h1 {
                text-align: center;
                margin-top: 20px;
            }

            .search-box{
                width: 500px;
            }

            table {
                font-size: 11px;
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            th, td {
                padding: 1px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }

            th {
                background-color: #f2f2f2;
            }

            tr:hover {
                background-color: #f5f5f5;
            }

            form {
                text-align: center;
                margin-top: 20px;
            }

            input[type="text"], input[type="submit"] {
                padding: 8px;
                margin: 5px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #45a049;
            }

            .search-box {
                margin: 0 auto; /* Center the search box horizontally */
            }

            .search-box input[type="text"] {
                padding: 10px;
                border-radius: 5px;
                border: none;
                outline: none;
                background: whitesmoke;
                font-size: 16px;
                width: 500px;
            }

            .search-btn{
                position: relative;
                left: -65px;
                top: -50px;
                border-radius: 5px;
                border: none;
                outline: none;
                height: 40px;
                width: 55px;
                background: #4169E1;

            }

            .search-box > form {
                text-align: left;
            }

            .choosenRow:hover{
                background: greenyellow;
            }

            .content {
                position: fixed;
                top: 0;
                left: -320px;
                width: 300px;
                height: 100%;
                background-color: #f4f4f4;
                transition: left 0.3s ease;
                z-index: 10;
            }

            .open {
                left: 0; /* Slide the navigation into view */
            }

            #openNav {
                position: absolute;
                top: 20px;
                left: 10px;
                border: none;
                background: none;
                z-index: 9;
            }

            #openNav:hover {
                cursor:pointer;
            }

            #closeNav {
                position: absolute;
                color: red;
                top: 0px;
                left: 75%;
                font-size: 24px;
                background: none;
                border: none;
                cursor: pointer;
                z-index: 11;
            }

            #closeNav:hover {
                color: #ff816a;
            }

            .content {
                display: flex;
                flex-direction: column;
                align-items: center;
                padding-top: 80px;
            }

            .content a {
                width: 100%;
                height: 80px;
                background-color: gainsboro;
                margin-left: 5px;
                text-decoration: none;
                display: flex;
                align-items: center;
                margin-bottom: 5px;
                transition: background-color 0.3s ease;
            }


            .content a:hover {
                background-color: darkorange;
            }


            footer {
                background-color: #ff4b2b;
                color: white;
                text-align: center;
                padding: 10px;
                position: fixed;
                bottom: 0;
                width: 100%;
            }

        </style>
    </head>
    <body>
        <header>
        </header>

        <nav class="dropdownmenu">
            <div class="navigation">
                <div>
                    <a href="http://localhost:8085/carManagement/main.jsp" class="logo" style="text-decoration:none">CAR</a>
                </div>

                <%
                    String currentUser = (String) request.getSession().getAttribute("employeeName");
                %>
                <div class="customer-page">
                    <a class="customer-link">HI <%=currentUser%>, wish you a good day</a>
                    <div id="customer-dropdown" class="dropdown-content">
                        <a href="../LogoutController?action=logout" class="logout">Logout</a>
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

        <div>
            <button id="openNav"><i class="fa-solid fa-bars fa-2xl" style="color: white;"></i></button>
        </div>
        <div class="content">
            <button id="closeNav">&#10006;</button>
            <% session.removeAttribute("addMessage"); %>
            <a href="staff/addCar.jsp">Add Car</a>
            <a href="staff/manageOrders.jsp">Manage Orders</a>
        </div>

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

        <script>
            document.getElementById("openNav").addEventListener("click", function () {
                document.querySelector(".content").classList.add("open");
            });

            document.getElementById("closeNav").addEventListener("click", function () {
                document.querySelector(".content").classList.remove("open");
            });
        </script>
    </body>
</html>
