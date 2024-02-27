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
import javax.servlet.http.HttpSession;

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
                    List<Car> searchResults = search(query);

                    request.setAttribute("search", searchResults);
                    request.getRequestDispatcher("main.jsp").forward(request, response);
                    break;
                case "info":
                    String carId = request.getParameter("carId");
                    info(request, response, carId);
                    break;
                default:
                    // Do nothing or handle the default case as needed
                    break;
            }
        }
    }
    
    private void info(HttpServletRequest req, HttpServletResponse resp, String carId)  throws ServletException, IOException {
        DAO dao = new DAO();
        Car car = dao.getCarById(carId);
        
        String action = req.getParameter("action");
        resp.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = req.getSession();
        session.setAttribute("car", car);

        req.getRequestDispatcher("car/carPage.jsp").forward(req, resp);
    }

    private List<Car> search(String query) {
        DAO dao = new DAO();
        List<Car> searchResults = null;
        
        searchResults = dao.getCarByModel(query);
        
        return searchResults;
    }
}
