package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import dao.DAO;
import dto.car.Car;
import java.util.List;
import dto.customer.Customer;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Main Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("        <script src=\"https://kit.fontawesome.com/05ec024090.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <nav class=\"dropdownmenu\">\n");
      out.write("            <div>\n");
      out.write("                <button id=\"openNav\"><i class=\"fa-solid fa-bars fa-2xl\" style=\"color: white;\"></i></button>\n");
      out.write("                <a class=\"logo\">CAR</a>\n");
      out.write("            </div>\n");
      out.write("            <ul class=\"menu-items\">\n");
      out.write("                <li><a href=\"#\">Home</a></li>\n");
      out.write("                <li><a href=\"#\">About Me</a></li>\n");
      out.write("                <li><a href=\"#\">Articles on HTML5 & CSS3</a>\n");
      out.write("                    <ul id=\"submenu\">\n");
      out.write("                        <li><a href=\"http://www.jochaho.com/wordpress/difference-between-svg-vs-canvas/\">Difference between SVG vs. Canvas</a></li>\n");
      out.write("                        <li><a href=\"http://www.jochaho.com/wordpress/new-features-in-html5/\">New features in HTML5</a></li>\n");
      out.write("                        <li><a href=\"http://www.jochaho.com/wordpress/creating-links-to-sections-within-a-webpage/\">Creating links to sections within a webpage</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"#\">BLOGS</a></li>\n");
      out.write("                <li><a href=\"#\">CONTACT</a></li>\n");
      out.write("            </ul>\n");
      out.write("\n");
      out.write("            ");

                String userId = (String) request.getSession().getAttribute("customerId");

                if (userId == null || userId.isEmpty()) {
            
      out.write("\n");
      out.write("            <div class=\"register-login\">\n");
      out.write("                <a href=\"register.jsp\">Register</a>\n");
      out.write("                <a>/</a>\n");
      out.write("                <a href=\"login.jsp\">Login</a>\n");
      out.write("            </div>\n");
      out.write("            ");

            } else {
            
      out.write("\n");
      out.write("            <div class=\"customer-page\">\n");
      out.write("                <a class=\"customer-link\" href=\"customer/customerInfo.jsp\">Customer Page</a>\n");
      out.write("                <i class=\"customer-btn fa-solid fa-caret-down fa-rotate-90 fa-lg\"></i>\n");
      out.write("                <div id=\"customer-dropdown\" class=\"dropdown-content\">\n");
      out.write("                    <a href=\"#home\">Home</a>\n");
      out.write("                    <a href=\"#about\">About</a>\n");
      out.write("                    <a href=\"#contact\">Contact</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"content\">\n");
      out.write("            <button id=\"closeNav\">&#10006;</button>\n");
      out.write("            <h2>FIND YOUR CAR</h2>\n");
      out.write("            <form id=\"car-search-form\">\n");
      out.write("                <label for=\"brand\">Brand:</label>\n");
      out.write("                <select id=\"brand\" name=\"brand\">\n");
      out.write("                    <!-- Options for brands -->\n");
      out.write("                    ");

                        DAO dao = new DAO();
                        List<String> carModels = dao.getAllCarModels();
                        for (String model : carModels) {
                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print( model);
      out.write('"');
      out.write('>');
      out.print( model);
      out.write("</option>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                </select>\n");
      out.write("                <br><br>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <label for=\"location\">Location:</label>\n");
      out.write("                <select id=\"location\" name=\"location\">\n");
      out.write("                    <!-- Options for locations -->\n");
      out.write("                    <option value=\"location1\">Location 1</option>\n");
      out.write("                    <option value=\"location2\">Location 2</option>\n");
      out.write("                    <!-- Add more options as needed -->\n");
      out.write("                </select><br><br>\n");
      out.write("\n");
      out.write("                <label for=\"date\">Date:</label>\n");
      out.write("                <input type=\"date\" id=\"date\" name=\"date\"><br><br>\n");
      out.write("\n");
      out.write("                <div class=\"custom-wrapper\"> \n");
      out.write("\n");
      out.write("                    <div class=\"header\"> \n");
      out.write("                        <h2 class=\"projtitle\"> \n");
      out.write("                            Price Range Slider \n");
      out.write("                        </h2> \n");
      out.write("                    </div> \n");
      out.write("\n");
      out.write("                    <div class=\"price-input-container\"> \n");
      out.write("                        <div class=\"price-input\"> \n");
      out.write("                            <div class=\"price-field\"> \n");
      out.write("                                <span>Minimum Price</span> \n");
      out.write("                                <input type=\"number\" \n");
      out.write("                                       class=\"min-input\" \n");
      out.write("                                       value=\"2500\"> \n");
      out.write("                            </div> \n");
      out.write("                            <div class=\"price-field\"> \n");
      out.write("                                <span>Maximum Price</span> \n");
      out.write("                                <input type=\"number\" \n");
      out.write("                                       class=\"max-input\" \n");
      out.write("                                       value=\"8500\"> \n");
      out.write("                            </div> \n");
      out.write("                        </div> \n");
      out.write("                        <div class=\"slider-container\"> \n");
      out.write("                            <div class=\"price-slider\"> \n");
      out.write("                            </div> \n");
      out.write("                        </div> \n");
      out.write("                    </div> \n");
      out.write("\n");
      out.write("                    <!-- Slider -->\n");
      out.write("                    <div class=\"range-input\"> \n");
      out.write("                        <input type=\"range\" \n");
      out.write("                               class=\"min-range\" \n");
      out.write("                               min=\"0\" \n");
      out.write("                               max=\"10000\" \n");
      out.write("                               value=\"2500\" \n");
      out.write("                               step=\"1\"> \n");
      out.write("                        <input type=\"range\" \n");
      out.write("                               class=\"max-range\" \n");
      out.write("                               min=\"0\" \n");
      out.write("                               max=\"10000\" \n");
      out.write("                               value=\"8500\" \n");
      out.write("                               step=\"1\"> \n");
      out.write("                    </div> \n");
      out.write("                </div> \n");
      out.write("\n");
      out.write("                <button type=\"submit\">Search</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");

            String selectedBrand = request.getParameter("brand");
            List<Car> cars = dao.getCarByModel(selectedBrand);
        
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"car-table\">\n");
      out.write("            <table>\n");
      out.write("                ");

                    int count = 0;
                    for (Car car : cars) {
                        if (count % 3 == 0) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                    <td>\n");
      out.write("                        <div class=\"car-cell\">\n");
      out.write("                            <img src=\"");
      out.print( car.getImageUrl());
      out.write("\" alt=\"");
      out.print( car.getModel());
      out.write("\">\n");
      out.write("                            <span>");
      out.print( car.getModel());
      out.write(" Info</span>\n");
      out.write("                        </div>\n");
      out.write("                    </td>\n");
      out.write("                    ");

                        count++;
                        if (count % 3 == 0) {
                    
      out.write("\n");
      out.write("                </tr>\n");
      out.write("                ");

                        }
                    }
                    if (count % 3 != 0) {
                
      out.write("\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <footer>\n");
      out.write("            <p>&copy; 2024 Nonobeam page. All rights reserved.</p>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("        <script src=\"script.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
