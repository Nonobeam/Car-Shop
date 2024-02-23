package controller;

import dao.DAO;
import dto.car.Car;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nonobeam <https://github.com/Nonobeam>
 */
public class CarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "search":
                    String query = request.getParameter("query");
                    List<Car> searchResults = search(query); // Replace searchCars(query) with your actual search method

                    request.setAttribute("search", searchResults);
                    request.getRequestDispatcher("main.jsp").forward(request, response);
                    break;
                default:
                    // Do nothing or handle the default case as needed
                    break;
            }
        }
    }

    private List<Car> search(String query) {
        DAO dao = new DAO();
        List<Car> searchResults = null;
        
        searchResults = dao.getCarByModel(query);
        
        return searchResults;
    }
}
