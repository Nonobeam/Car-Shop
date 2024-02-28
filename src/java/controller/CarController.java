package controller;

import dao.DAO;
import dao.carDAO;
import dto.car.Car;
import dto.customer.Customer;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nonobeam <https://github.com/Nonobeam>
 */
public class CarController extends HttpServlet {

    public carDAO carDao = new carDAO();
    public DAO dao = new DAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        String customerId = request.getParameter("customerId");
        String carId = request.getParameter("carId");

        if (action != null) {
            switch (action) {
                case "search":
                    String query = request.getParameter("query");
                    List<Car> searchResults = search(query);

                    request.setAttribute("search", searchResults);
                    request.getRequestDispatcher("main.jsp").forward(request, response);
                    break;
                case "info":
                    info(request, response, carId, customerId);
                    break;
                case "validateInfo":
                    validateInfo(request, response, carId, customerId);
                    break;
                case "buy":
                    buy(request, response, carId, customerId);
                    break;
                default:
                    // Do nothing or handle the default case as needed
                    break;
            }
        }
    }

    private void info(HttpServletRequest req, HttpServletResponse resp, String carId, String customerId) throws ServletException, IOException {
        Car car = carDao.getCarById(carId);
        Customer customer = dao.getCustomerById(customerId);

        resp.setContentType("text/html;charset=UTF-8");

        HttpSession session = req.getSession();
        session.setAttribute("car", car);
        session.setAttribute("customer", customer);

        req.getRequestDispatcher("car/carPage.jsp").forward(req, resp);
    }

    private void validateInfo(HttpServletRequest req, HttpServletResponse resp, String carId, String customerId) throws ServletException, IOException {
        Car car = carDao.getCarById(carId);
        Customer customer = dao.getCustomerById(customerId);

        resp.setContentType("text/html;charset=UTF-8");

        HttpSession session = req.getSession();
        session.setAttribute("car", car);
        session.setAttribute("customer", customer);

        req.getRequestDispatcher("car/buyPage.jsp").forward(req, resp);
    }

    private void buy(HttpServletRequest req, HttpServletResponse resp, String carId, String customerId) throws ServletException, IOException {
        Car car = carDao.getCarById(carId);
        Customer customer = dao.getCustomerById(customerId);

        resp.setContentType("text/html;charset=UTF-8");

        HttpSession session = req.getSession();
        session.setAttribute("car", car);
        session.setAttribute("customer", customer);
        
        carDao.buyCar(carId, customerId);

        req.getRequestDispatcher("customer/thankPage.jsp").forward(req, resp);
    }

    private List<Car> search(String query) {
        List<Car> searchResults = null;

        searchResults = carDao.getCarByModel(query);

        return searchResults;
    }
}
