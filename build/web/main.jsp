<%@page import="dao.CarDAO"%>
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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/05ec024090.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <header>
        </header>
        
        <%  
            CarDAO carDao = new CarDAO();
            List<Car> carList = carDao.getAllCars();
            if (carList.isEmpty()){
        %>
        <span style="color: red">Connect fail to database</span>
        <% 
            }else{
        %>
        <span style="color: blue">Connect successful to database</span>
        <% 
            }
        %>

        <nav class="dropdownmenu">
            <div class="navigation">
                <div>
                    <button id="openNav"><i class="fa-solid fa-bars fa-2xl" style="color: white;"></i></button>
                    <a href="main.jsp" class="logo" style="text-decoration:none">CAR</a>
                </div>
                <ul class="menu-items">
                    <li><a href="main.jsp">HOME</a></li>
                    <li><a href="information/aboutMe.jsp">ABOUT ME</a></li>
                    <li><a href="#bigfoot">PRODUCTOR</a></li>
                    <li><a href="#bigfoot">CONTACT</a></li>
                </ul>

                <%
                    Integer userId = (Integer) request.getSession().getAttribute("customerId");

                    if (userId == null) {
                %>
                <div class="register-login">
                    <a href="register.jsp">Register</a>
                    <a>/</a>
                    <a href="login.jsp">Login</a>
                </div>
                <%
                } else {
                    String currentUser = (String) request.getSession().getAttribute("customerName");
                    Integer currentUserId = (Integer) request.getSession().getAttribute("customerId");
                %>
                <div class="customer-page">
                    <a class="customer-link" href="CustomerController?action=info&customerId=<%=currentUserId%>"><%= currentUser%></a>
                    <div id="customer-dropdown" class="dropdown-content">
                        <a href="CustomerController?action=info&customerId=<%=currentUserId%>">My Account</a>
                        <a href="LogoutController?action=logout" class="logout">Logout</a>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
        </nav>

            
<!--        Car find navigation              -->
        <div class="content">
            <button id="closeNav">&#10006;</button>
            <h2>FIND YOUR CAR</h2>
            <form id="car-search-form" action="main.jsp">
                <label for="brand">Brand:</label>
                <select id="brand" name="brand">
                    <!-- Options for brands -->  
                    <option value="">All</option>
                    <%
                        CarDAO dao = new CarDAO();
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

        <% if (cars.isEmpty()) {

        %>
        <div class="car-status">
            <span>Oops! Sorry, we are currently <span style="color: red">out of stock</span> for that car. However, we are working diligently to replenish our inventory. If you would like us to notify you as soon as the car becomes available, please leave your contact information <a href="#" style="text-decoration: underline; color: blue">here</a>. Thank you for your patience!</span>
        </div>
        <% } %>

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
                        Integer currentUserId = (Integer) request.getSession().getAttribute("customerId");
                    %>
                    <td>
                        <%
                            if (currentUserId == null){
                        %>
                        <a href="CarController?action=info&carId=<%= car.getCarId()%>&customerId=<%=currentUserId%>" class="car-cell">
                            <img src="<%= car.getImageUrl()%>" alt="<%= car.getModel()%>">
                            <span><%= car.getModel()%> Info</span>
                        </a>
                        <%
                            }else{
                        %>
                        <a href="CarController?action=info&carId=<%= car.getCarId()%>&customerId=<%=currentUserId%>" class="car-cell">
                            <img src="<%= car.getImageUrl()%>" alt="<%= car.getModel()%>">
                            <span><%= car.getModel()%> Info</span>
                        </a>
                        <%
                            }
                        %>
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
        <footer id="bigfoot">
            <table class="footer-productor">
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
            <table class="footer-phone">
                <tr>
                    <td>
                        <span>(tel+):</span>
                    </td>
                    <td>
                        <span>05396475297</span>
                    </td>
                </tr>
            </table>
            <p>&copy; 2024 Nonobeam page. All rights reserved.</p>
        </footer>

        <script src="script.js"></script>
    </body>
</html>
