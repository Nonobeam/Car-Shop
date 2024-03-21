/*
 * If this is an open-source, feel free to use it. If it a private source, please contact me first
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nonobeam <https://github.com/Nonobeam>
 */
public class StaffController extends HttpServlet {

    private static final String MAIN = "staff/manageCar.jsp";
    private static final String SEARCH = "Search";
    private static final String EDIT = "Edit";
    private static final String CAR_CONTROLLER = "CarController";

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String url = MAIN;
        resp.setContentType("text/html;charset=UTF-8");

        if (action == null) {
            // Do nothing
        } else if ("SEARCH".equalsIgnoreCase(action)) {
            url = CAR_CONTROLLER;
        } else if ("EDIT".equalsIgnoreCase(action)) {
            url = CAR_CONTROLLER;
        } else if ("MANAGE".equalsIgnoreCase(action)){
            url = MAIN;
        }

        req.getRequestDispatcher(url).forward(req, resp);
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
