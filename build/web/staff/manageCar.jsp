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

        <h1>All Cars</h1>

        <form action="CarController" method="GET">
            <input type="text" name="search" placeholder="Search by Car Name">
            <input type="submit" value="Search">
        </form>

        <table>
            <tr>
                <th>Car ID</th>
                <th>Car Name</th>
                <th>Model</th>
                <th>Date</th>
                <th>VIN</th>
                <th>Colour</th>
                <th>License Plate</th>
                <th>Make</th>
                <th>Location</th>
                <th>Price</th>
                <th>Options</th>
            </tr>
        </table>

        <footer>
            <p>&copy; 2024 Nonobeam page. All rights reserved.</p>
        </footer>
    </body>
</html>
