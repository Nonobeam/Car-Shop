<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Customer</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="customerInforStyle.css">
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
        </nav>

        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Jordan Ramey</h3>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="https://cdn-icons-png.flaticon.com/512/6596/6596121.png" class="img-circle img-responsive"> </div>
                                <div class=" col-md-9 col-lg-9 ">
                                    <table class="table table-user-information">
<!--                                        id, customerName, password, phone, int age, address-->
                                        <tbody>
                                            <tr>
                                                <td>ID:</td>
                                                <td>1</td>
                                            </tr>
                                            <tr>
                                                <td>Name:</td>
                                                <td>Test Name</td>
                                            </tr>
                                            <tr>
                                                <td>Phone:</td>
                                                <td>04567890</td>
                                            </tr>
                                            <tr>
                                            <tr>
                                                <td>Age:</td>
                                                <td>20</td>
                                            </tr>
                                            <tr>
                                                <td>Home Address:</td>
                                                <td>Street in, State</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        
        
        <footer>
            <p>&copy; 2024 Nonobeam page. All rights reserved.</p>
        </footer>

    </body>
</html>

