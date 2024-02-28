package org.apache.jsp.testDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.car.Car;
import dao.carDAO;
import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

public final class firstPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Display Cars by Customer ID</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");

            // Assuming you have already retrieved the customerId
            String customerId = "1";

            // Create an instance of your DAO class
            carDAO dao = new carDAO();

            // Get all cars by customer ID
            List<Car> cars = dao.getAllCarByCustomerId(customerId);
        
      out.write("\n");
      out.write("\n");
      out.write("        <h1>Cars Owned by Customer</h1>\n");
      out.write("\n");
      out.write("        ");

            // Check if there are cars for the customer
            if (cars.isEmpty()) {
        
      out.write("\n");
      out.write("        <p>No cars found for this customer.</p>\n");
      out.write("        ");

        } else {
        
      out.write("\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Car ID</th>\n");
      out.write("                <th>Model</th>\n");
      out.write("                <th>Date</th>\n");
      out.write("                <th>VIN</th>\n");
      out.write("                <th>Colour</th>\n");
      out.write("                <th>License Plate</th>\n");
      out.write("                <th>Make</th>\n");
      out.write("                <th>Location</th>\n");
      out.write("                <th>Price</th>\n");
      out.write("                <!-- Add more columns if needed -->\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            ");

                // Iterate over the list of cars and display their details
                for (Car car : cars) {
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( car.getCarId());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( car.getModel());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( car.getDate());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( car.getVIN());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( car.getColour());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( car.getLicensePlate());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( car.getMake());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( car.getLocation());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( car.getPrice());
      out.write("</td>\n");
      out.write("                <!-- Add more columns if needed -->\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("\n");
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
