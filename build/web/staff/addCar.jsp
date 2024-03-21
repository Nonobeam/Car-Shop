<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.CarDAO"%>
<%@page import="dto.car.Productor"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add Car</title>
        <link rel="stylesheet" href="staff/addCarStyle.css" />
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://kit.fontawesome.com/05ec024090.js"
        crossorigin="anonymous"></script>
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

            .search-box {
                margin: 0 auto; /* Center the search box horizontally */
            }

            .search-box input[type="text"] {
                padding: 10px;
                border-radius: 5px;
                border: none;
                outline: none;
                font-size: 16px;
                width: 1000px;
            }

            .search-btn{
                border-radius: 5px;
                border: none;
                outline: none;
                height: 40px;
                width: 55px;
                background: #ff4b2b;
                position: relative;
                left: -65px;
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

            footer {
                background-color: #ff4b2b;
                color: white;
                text-align: center;
                padding: 10px;
                position: fixed;
                bottom: 0;
                width: 100%;
            }

            table {
                margin: 20px auto;
                margin-top: 150px;
                margin-bottom: 50px;
                border-collapse: collapse;
                width: 80%;
            }

            th, td {
                padding: 10px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }

            th {
                background-color: #f2f2f2;
            }

            input[type="text"] {
                padding: 5px;
                border-radius: 5px;
                border: 1px solid #ddd;
                width: 100%;
            }

            input[type="submit"] {
                padding: 10px 20px;
                background-color: #ff4b2b;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #ff816a;
            }

            img {
                max-width: 30%;
                height: auto;
            }

            #in {
                color: black;
                outline: none;  
                box-shadow: blue;
                -webkit-transition: all .2s;
                -moz-transition: all .2s;
                transition: all .2s
            }

            #in:focus {
                outline: 0;
            }

            #in:valid {
                border-color: green;
                border-width: 2px;
            }

            #in:focus:invalid {
                border-color: red;
                border-width: 2px;
            }

            #imageUrlInput {
                color: black;
                outline: none;  
                box-shadow: blue;
                -webkit-transition: all .2s;
                -moz-transition: all .2s;
                transition: all .2s
            }

            #imageUrlInput:focus {
                outline: 0;
            }

            #imageUrlInput:valid {
                border-color: green;
                border-width: 2px;
            }

            #imageUrlInput:focus:invalid {
                border-color: red;
                border-width: 2px;
            }

            .message {
                position: relative;
                font-size: 20px;
                left: 800px;
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
        </style>
    </head>

    <body>
        <header>
        </header>

        <nav class="dropdownmenu">
            <div class="navigation">
                <div>
                    <a href="http://localhost:8085/carManagement/main.jsp" class="logo"
                       style="text-decoration:none">CAR</a>
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
        </nav>

        <div>
            <button id="openNav"><i class="fa-solid fa-bars fa-2xl" style="color: white;"></i></button>
        </div>
        <div class="content">
            <button id="closeNav">&#10006;</button>
            <a href="http://localhost:8085/carManagement/StaffController?action=search&query=">Manage Car</a>
            <a href="http://localhost:8085/carManagement/staff/manageOrders.jsp">Manage Orders</a>
        </div>


        <form action="CarController">
            <table>
                <tr>
                    <td>Car ID:</td>
                    <td><input type="text" name="carId" pattern="[A-Za-z0-9]{1,5}" placeholder="5 characters" required id="in"></td>
                </tr>
                <tr>
                    <td>Car Make:</td>
                    <td>
                        <select name="make" id="in">
                            <%
                                CarDAO carDao = new CarDAO();
                                List<Productor> productors = carDao.getAllProductors();

                                for (Productor product : productors) {
                            %>
                            <option value="<%= product.getProductorId()%>"><%= product.getProductorName()%></option>
                            <% }%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Car Model:</td>
                    <td><input type="text" name="model" pattern="[A-Za-z0-9 ]{1,20}" placeholder="10 characters" required id="in"></td>
                </tr>
                <tr>
                    <td>Manufacturing Date:</td>
                    <td><input type="date" name="date" required oninput="validateDate(this)" id="in"></td>
                </tr>
                <tr>
                    <td>Car Color:</td>
                    <td><input type="text" name="colour" pattern="[A-Za-z]{1,10}" placeholder="10 characters" required id="in"></td>
                </tr>

                <tr>
                    <td>Car Price:</td>
                    <td><input type="text" name="price" pattern="[0-9]{1,7}(\.[0-9]{1,2})?" placeholder="xxxxxxx.xx" required id="in"></td>
                </tr>

                <tr>
                    <td>VIN:</td>
                    <td><input type="text" name="VIN" pattern="[A-Za-z0-9]{17}" placeholder="17 characters" required id="in"></td>
                </tr>
                <tr>
                    <td>License Plate:</td>
                    <td><input type="text" name="licensePlate" pattern="[A-Za-z0-9]{1,10}" placeholder="10 characters" required id="in"></td>
                </tr>
                <tr>
                    <td>Location:</td>
                    <td><input type="text" name="location" pattern="[A-Za-]{1,10}" placeholder="10 characters" required id="in"></td>
                </tr>
                <tr>
                    <td>Image URL:</td>
                    <td><input type="text" name="imageUrl" id="imageUrlInput" required></td>
                </tr>
                <tr>
                    <td>Preview:</td>
                    <td><img src="" id="imagePreview" alt="Image Preview"></td>
                </tr>
                <tr>
                    <td>Quantity:</td>
                    <td><input type="number" name="quantity" required id="in"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" name="action" value="add"></td>
                </tr>
            </table>
        </form>
        <p class="message" style="color:red;display:inline-block">${addMessage}</p>

        <footer>
            <p>&copy; 2024 Nonobeam page. All rights reserved.</p>
        </footer>

        <script>
            const imageUrlInput = document.getElementById('imageUrlInput');
            const imagePreview = document.getElementById('imagePreview');

            imageUrlInput.addEventListener('input', function () {
                imagePreview.src = imageUrlInput.value;
            });
            function validateDate(input) {
                var selectedDate = new Date(input.value);
                var currentDate = new Date();
                if (selectedDate > currentDate) {
                    input.setCustomValidity("Please select a date that is not in the future.");
                } else {
                    input.setCustomValidity("");
                }
            }
            document.getElementById("openNav").addEventListener("click", function () {
                document.querySelector(".content").classList.add("open");
            });

            document.getElementById("closeNav").addEventListener("click", function () {
                document.querySelector(".content").classList.remove("open");
            });
        </script>
    </body>
</html>