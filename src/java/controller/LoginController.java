/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAO;
import dto.customer.Customer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nonobeam <https://github.com/Nonobeam>
 */
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        resp.setContentType("text/html;charset=UTF-8");

        if (action == null) {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        
        if ("login".equalsIgnoreCase(action)) {
            String phone = req.getParameter("phone");
            String password = req.getParameter("pwd");

            DAO dao = new DAO();
            Customer customer = dao.checkCustomerLogin(phone, password);

            if (customer == null) {
                req.setAttribute("message", "Failed to login due to incorrect credentials.");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            } else {
                HttpSession session = req.getSession();
                session.setAttribute("customer", customer);
                session.setAttribute("customerId", customer.getCustomerId());
                session.setAttribute("customerName", customer.getCustomerName());
                
                
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            }  
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

}
