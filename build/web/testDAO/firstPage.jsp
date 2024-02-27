<%-- 
    Document   : firstPage
    Created on : Feb 28, 2024, 12:45:10 AM
    Author     : Nonobeam <https://github.com/Nonobeam>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Get Customer by ID</h2>
        <form action="secondPage.jsp" method="get">
            <label for="customerId">Customer ID:</label>
            <input type="text" id="customerId" name="customerId">
            <button type="submit">Submit</button>
        </form>
        <div id="customerDetails">
            <!-- Customer details will be displayed here -->
        </div>
    </body>
</html>
