<%@page import="dto.car.Productor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DAO"%>
<%@page import="dto.car.Car"%>
<%@page import="java.util.List"%>
<%@page import="dto.customer.Customer"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Main Page</title>
        <link rel="stylesheet" href="style.css">
        <script src="https://kit.fontawesome.com/05ec024090.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <header>
        </header>

        <nav class="dropdownmenu">
            <div>
                <button id="openNav"><i class="fa-solid fa-bars fa-2xl" style="color: white;"></i></button>
                <a class="logo">CAR</a>
            </div>
            <ul class="menu-items">
                <li><a href="#">Home</a></li>
                <li><a href="#">About Me</a></li>
                <li><a href="#">Articles on HTML5 & CSS3</a>
                    <ul id="submenu">
                        <li><a href="http://www.jochaho.com/wordpress/difference-between-svg-vs-canvas/">Difference between SVG vs. Canvas</a></li>
                        <li><a href="http://www.jochaho.com/wordpress/new-features-in-html5/">New features in HTML5</a></li>
                        <li><a href="http://www.jochaho.com/wordpress/creating-links-to-sections-within-a-webpage/">Creating links to sections within a webpage</a></li>
                    </ul>
                </li>
                <li><a href="#">BLOGS</a></li>
                <li><a href="#">CONTACT</a></li>
            </ul>

            <%
                String userId = (String) request.getSession().getAttribute("customerId");

                if (userId == null || userId.isEmpty()) {
            %>
            <div class="register-login">
                <a href="register.jsp">Register</a>
                <a>/</a>
                <a href="login.jsp">Login</a>
            </div>
            <%
            } else {
            %>
            <div class="customer-page">
                <a class="customer-link" href="customer/customerInfo.jsp">Customer Page</a>
                <i class="customer-btn fa-solid fa-caret-down fa-rotate-90 fa-lg"></i>
                <div id="customer-dropdown" class="dropdown-content">
                    <a href="#home">Home</a>
                    <a href="#about">About</a>
                    <a href="#contact">Contact</a>
                </div>
            </div>
            <%
                }
            %>
        </nav>

        <div class="content">
            <button id="closeNav">&#10006;</button>
            <h2>FIND YOUR CAR</h2>
            <form id="car-search-form">
                <label for="brand">Brand:</label>
                <select id="brand" name="brand">
                    <!-- Options for brands -->  
                    <option value="">All</option>
                    <%
                        DAO dao = new DAO();
                        String selectedBrand = request.getParameter("brand");
                        String selectedLocation = request.getParameter("location");
                        String selectedDate = request.getParameter("date");
                        String minPrice = request.getParameter("minPrice");
                        String maxPrice = request.getParameter("maxPrice");
                        List<String> carModels = dao.getAllModels();
                        for (String model : carModels) {
                    %>
                    <option value="<%= model%>" <%= (selectedBrand != null && selectedBrand.equals(model)) ? "selected" : ""%>><%= model%></option>
                    <%
                        }
                    %>
                </select>
                <br><br>


                <label for="location">Location:</label>
                <select id="location" name="location">
                    <option value="">All</option>
                    <%
                        List<String> locations = dao.getAllLocations();
                        for (String location : locations) {
                    %>
                    <option value="<%= location%>" <%= (selectedLocation != null && selectedLocation.equals(location)) ? "selected" : ""%>><%= location%></option>
                    <%
                        }
                    %>
                </select><br><br>

                <label for="date">Date:</label>
                <input type="date" id="date" name="date" value="<%= selectedDate%>"><br><br>

                <div class="custom-wrapper"> 

                    <div class="header"> 
                        <h2 class="projtitle"> 
                            Price Range Slider 
                        </h2> 
                    </div> 

                    <div class="price-input-container"> 
                        <div class="price-input"> 
                            <div class="price-field"> 
                                <span>Minimum Price</span> 
                                <input type="number" 
                                       class="min-input" 
                                       value="25000"> 
                            </div> 
                            <div class="price-field"> 
                                <span>Maximum Price</span> 
                                <input type="number" 
                                       class="max-input" 
                                       value="85000"> 
                            </div> 
                        </div> 
                        <div class="slider-container"> 
                            <div class="price-slider"> 
                            </div> 
                        </div> 
                    </div> 

                    <!-- Slider -->
                    <div class="range-input"> 
                        <input type="range" 
                               class="min-range"
                               name="minPrice"
                               min="0" 
                               max="100000" 
                               value="25000" 
                               step="1"> 
                        <input type="range" 
                               class="max-range" 
                               name="maxPrice"
                               min="0" 
                               max="100000" 
                               value="85000" 
                               step="1"> 
                    </div> 
                </div> 

                <button type="submit">Search</button>
            </form>
        </div>

        <%
            List<Car> cars = dao.getFilteredCars(selectedBrand, selectedLocation, selectedDate, minPrice, maxPrice);
        %>


        <div class="car-table">
            <table>
                <%
                    int count = 0;
                    for (Car car : cars) {
                        if (count % 3 == 0) {
                %>
                <tr>
                    <%
                        }
                    %>
                    <td>
                        <div class="car-cell">
                            <img src="<%= car.getImageUrl()%>" alt="<%= car.getModel()%>">
                            <span><%= car.getModel()%> Info</span>
                        </div>
                    </td>
                    <%
                        count++;
                        if (count % 3 == 0) {
                    %>
                </tr>
                <%
                        }
                    }
                    if (count % 3 != 0) {
                %>
                </tr>
                <%
                    }
                %>
            </table>
        </div>


        <%
            List<Productor> productors = dao.getAllProductors();
        %>
        <footer>
            <table>
                <tr>
                    <th>Brand</th>
                    <th>Address</th>
                </tr>
                <%
                    int countProductors = 0;
                    for (Productor productor : productors) {
                %>
                <tr>
                    <td>
                        <span><%= productor.getProductorName()%></span>
                    </td>
                    <td>
                        <span><%= productor.getAddress()%></span>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
            <p>&copy; 2024 Nonobeam page. All rights reserved.</p>
        </footer>

        <script src="script.js"></script>
    </body>
</html>
