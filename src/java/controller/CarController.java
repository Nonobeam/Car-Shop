package controller;

import dao.DAO;
import dto.car.Car;
import java.io.IOException;
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

public class CarController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Car> cars = getCarDataFromDatabase();

        // Sort the car data based on the sort parameter
        String sortParam = request.getParameter("sort");
        if (sortParam != null) {
            switch (sortParam) {
                case "model":
                    Collections.sort(cars, Comparator.comparing(Car::getModel));
                    break;
                case "price":
                    Collections.sort(cars, Comparator.comparingDouble(Car::getPrice));
                    break;
                case "location":
                    Collections.sort(cars, Comparator.comparing(Car::getLocation));
                    break;
                case "make":
                    Collections.sort(cars, Comparator.comparing(Car::getMake));
                    break;
                case "date":
                    Collections.sort(cars, Comparator.comparing(Car::getDate));
                    break;
                default:
                    // Do nothing or handle the default case as needed
                    break;
            }
        }

        // Forward the sorted car data to main.jsp
        request.setAttribute("cars", cars);
        RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
        dispatcher.forward(request, response);
    }

    // Method to retrieve car data from the database (replace with actual implementation)
    private List<Car> getCarDataFromDatabase() {
        DAO dao = new DAO();
        return dao.getAllCars();
    }
}

