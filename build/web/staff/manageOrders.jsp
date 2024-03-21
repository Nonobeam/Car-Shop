<%@page import="dao.CarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%
    Gson gsonObj = new Gson();
    Map<Object, Object> map = null;
    List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();

    CarDAO carDao = new CarDAO();
    List<String> cars = carDao.getCarsInInventory();
    for (String c : cars) {
        map = new HashMap<Object, Object>();
        map.put("label", carDao.getCarById(c).getModel());
        map.put("y", carDao.getCarById(c).getQuantity());
        list.add(map);
    }

    String dataPoints = gsonObj.toJson(list);
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Manage Order</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="staff/pdfViewStyle.css">
        <script src="https://kit.fontawesome.com/05ec024090.js" crossorigin="anonymous"></script>
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

            #chartContainer{
                position: relative;
                top: 100px;
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
        </nav>

        <div>
            <button id="openNav"><i class="fa-solid fa-bars fa-2xl" style="color: white;"></i></button>
        </div>
        <div class="content">
            <button id="closeNav">&#10006;</button>
            <a href="http://localhost:8085/carManagement/StaffController?action=search&query=">Manage Car</a>
            <a href="http://localhost:8085/carManagement/staff/addCar.jsp">Add Car</a>
        </div>

        <div id="chartContainer" style="height: 570px; width: 100%;"></div>
        <script src="https://cdn.canvasjs.com/canvasjs.min.js"></script>

        <footer>
            <p>&copy; 2024 Nonobeam page. All rights reserved.</p>
        </footer>

        <script type="text/javascript">
            window.onload = function () {

                var chart = new CanvasJS.Chart("chartContainer", {
                    theme: "light2", // "light1", "dark1", "dark2"
                    exportEnabled: true,
                    animationEnabled: true,
                    title: {
                        text: "Car Orders"
                    },
                    data: [{
                            type: "pie",
                            toolTipContent: "<b>{label}</b>: {y}",
                            indexLabelFontSize: 16,
                            indexLabel: "{label} - {y}",
                            dataPoints: <%out.print(dataPoints);%>
                        }]
                });
                chart.render();
            };
            
            document.getElementById("openNav").addEventListener("click", function () {
                document.querySelector(".content").classList.add("open");
            });

            document.getElementById("closeNav").addEventListener("click", function () {
                document.querySelector(".content").classList.remove("open");
            });
        </script>
    </body>
</html>