/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CarDAO;
import dao.DAO;
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
public class EmployeeController extends HttpServlet {

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
                default:
                    // Do nothing or handle the default case as needed
                    break;
            }
        }
    }

    private void info(HttpServletRequest req, HttpServletResponse resp, String carId, String customerId) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        Car car = carDao.getCarById(carId);

        if (customerId == null || customerId.equals("null")) {
            HttpSession session = req.getSession();
            session.setAttribute("car", car);
//            session.setAttribute("customer", null);
            req.getRequestDispatcher("car/carPage.jsp").forward(req, resp);
        } else {
            int id = Integer.parseInt(customerId);
            Customer customer = dao.getCustomerById(id);

            HttpSession session = req.getSession();
            session.setAttribute("car", car);
            session.setAttribute("customer", customer);
        }
    }
    
}
