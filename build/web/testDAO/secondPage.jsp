<%@page import="dao.DAO"%>
<%@page import="dto.customer.Customer"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Get the customer ID from the request parameter
    String customerId = request.getParameter("customerId");

    // Create an instance of the CustomerDAO class
    DAO customerDAO = new DAO();

    // Call the getCustomerById method to retrieve the customer details
    Customer customer = customerDAO.getCustomerById(customerId);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Details</title>
</head>
<body>
    <h2>Customer Details</h2>
    <div>
        <% if (customer != null) { %>
            <p>Customer ID: <%= customer.getCustomerId() %></p>
            <p>Name: <%= customer.getCustomerName() %></p>
            <p>Password: <%= customer.getPassword() %></p>
            <p>Phone: <%= customer.getPhone() %></p>
            <p>Birth Date: <%= customer.getBirth() %></p>
            <p>Address: <%= customer.getAddress() %></p>
        <% } else { %>
            <p>No customer found with ID <%= customerId %></p>
        <% } %>
    </div>
</body>
</html>
