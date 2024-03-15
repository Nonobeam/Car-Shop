/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAO;
import dao.CarDAO;
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
public class CustomerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "info":
                    String customer = request.getParameter("customerId");
                    info(request, response, customer);
                    break;
                default:
                    break;
            }
        }
    }

    private void info(HttpServletRequest req, HttpServletResponse resp, String customerId) throws ServletException, IOException {
        DAO dao = new DAO();
        CarDAO carDao = new CarDAO();
        Customer customer = dao.getCustomerById(customerId);
        customer.setInventoryList(carDao.getAllCarByCustomerId(customerId));

        HttpSession session = req.getSession();
        session.setAttribute("customer", customer);

        req.getRequestDispatcher("customer/customerInfo.jsp").forward(req, resp);
    }
}
