/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAO;
import dao.CarDAO;
import dto.customer.Customer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import dto.customer.Customer;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Nonobeam <https://github.com/Nonobeam>
 */
public class CustomerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "info":
                    String customer = request.getParameter("customerId");
                    info(request, response, customer);
                    break;
                case "edit":
                    edit(request, response);
                    break;
                default:
                    break;
            }
        }
    }

    private void info(HttpServletRequest req, HttpServletResponse resp, String customerId) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        CarDAO carDao = new CarDAO();

        int id = Integer.parseInt(customerId);
        Customer customer = dao.getCustomerById(id);
        customer.setInventoryList(carDao.getAllCarByCustomerId(id));

        HttpSession session = req.getSession();
        session.setAttribute("customer", customer);

        req.getRequestDispatcher("customer/customerInfo.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();

        String customerId = req.getParameter("customerId");
        int id = Integer.parseInt(customerId);
        String customerName = req.getParameter("customerName");
        String phone = req.getParameter("phone");
        String birth = req.getParameter("birth");
        String address = req.getParameter("address");

        boolean checkEdit = dao.editCustomer(id, customerName, phone, birth, address);
        Customer customer = dao.getCustomerById(id);

        HttpSession session = req.getSession();
        session.setAttribute("editMessage", null);
        if (checkEdit == false) {
            session.setAttribute("editMessage", "Something went wrong.");
        } else {
            session.setAttribute("editMessage", "Update Successfully");
        }
        session.setAttribute("customer", customer);

        resp.sendRedirect("customer/customerEdit.jsp");
    }
}
