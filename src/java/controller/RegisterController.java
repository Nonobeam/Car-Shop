/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAO;
import dto.customer.Customer;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nonobeam <https://github.com/Nonobeam>
 */
public class RegisterController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            //id, customerName, password, phone, int age, address
            String name = request.getParameter("name");
            String password = request.getParameter("pwd");
            String phone = request.getParameter("phone");
            
            String birthString = request.getParameter("birth");
            LocalDate birth = LocalDate.parse(birthString, DateTimeFormatter.ISO_DATE);


            String address = request.getParameter("address");
            Customer customer = new Customer(name, password, phone, birth, address);
            DAO dao = new DAO();
            boolean checkInsert = dao.insert(customer);
            if (checkInsert) {
                request.setAttribute("noti", "Save successfully");
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("noti", "Save failed");
            }
        } catch (NumberFormatException e) {
            request.setAttribute("noti", e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
