<%@page import="dto.car.Car"%>
<%@page import="dao.carDAO"%>
<%@ page import="java.util.List" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.sql.SQLException" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Display Cars by Customer ID</title>
    </head>
    <body>

        <%
            // Assuming you have already retrieved the customerId
            String customerId = "1";

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

    </body>
</html>
