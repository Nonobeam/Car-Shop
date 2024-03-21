<%-- 
    Document   : error
    Created on : Mar 16, 2024, 10:54:59 PM
    Author     : Nonobeam <https://github.com/Nonobeam>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR PAGE</title>
    </head>
    <body>
        <% if (response.getStatus() == 500) {%>
        <font color="red">Error: <%=exception.getMessage()%></font><br>

    </body>
</html>
