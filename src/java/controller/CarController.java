package controller;

import dao.DAO;
import dao.CarDAO;
import dto.car.Car;
import dto.customer.Customer;
import java.io.IOException;
import java.time.LocalDate;
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

    public CarDAO carDao = new CarDAO();
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
                case "edit":
                    edit(request, response);
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
    
    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        
        String carId = req.getParameter("carId");
        String model = req.getParameter("model");
        String reqPrice = req.getParameter("price");
        double price = Double.parseDouble(reqPrice);
        String reqDate = req.getParameter("date");
        LocalDate date = LocalDate.parse(reqDate);
        String VIN = req.getParameter("VIN");
        String colour = req.getParameter("colour");
        String licensePlate = req.getParameter("licensePlate");
        String make = req.getParameter("make");
        String location = req.getParameter("location");
        String imageUrl = req.getParameter("imageUrl");
        String reqQuantity = req.getParameter("quantity");
        int quantity = Integer.parseInt(reqQuantity);
        
        
        Car car = new Car(carId, model, price, date, VIN, colour, licensePlate, make, location, imageUrl, quantity);
        
        boolean checkUpdate = carDao.updateCar(car);
        
        HttpSession session = req.getSession();
        if (checkUpdate == false){
            session.setAttribute("message", "Update fail with data" + carId + " " + model + " " + price + " " + date + " " + VIN + " " + colour + " " + licensePlate + " " + make + " " + location + " " + imageUrl + " " + quantity);
        }else{
            session.setAttribute("message", "Update successful with data" + carId + " " + model + " " + price + " " + date + " " + VIN + " " + colour + " " + licensePlate + " " + make + " " + location + " " + imageUrl + " " + quantity);
        }
        

        req.getRequestDispatcher("manageCar.jsp").forward(req, resp);
    }
}
