/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.company.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import util.DBUtils;

/**
 *
 * @author Nonobeam <https://github.com/Nonobeam>
 */
//employeeId, employeeName password, phone, birth, role
public class EmployeeDAO {

    Connection connection;
    PreparedStatement pre;
    ResultSet rs;

    //-----------------USER-----------------
    //Check user LOGIN 
    public Employee checkEmployeeLogin(String employeeId, String password) {
        Employee employee = null;
        String sql = "SELECT * FROM Employee WHERE employeeId = ? AND password = ?";
        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(sql);
            pre.setString(1, employeeId);
            pre.setString(2, password);
            rs = pre.executeQuery();
            while (rs.next()) {
                employee = createEmployeeFromResultSet(rs);
                return employee;
            }
        } catch (ClassNotFoundException | SQLException ex) {
        }

        return employee;
    }

    //Add new Employee
    public boolean insert(Employee employee) {
        boolean checkInsert = false;
        //id, EmployeeName, password, phone, int age, address
        String query = "insert into Employee(employeeId, employeeName, password, phone, birth, role) values(?, ?, ?, ?, ?)";
        try {
            connection = new DBUtils().getConnection();
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setString(1, employee.getEmployeeId());
            pre.setString(2, employee.getEmployeeName());
            pre.setString(3, employee.getPassword());
            pre.setString(4, employee.getPhone());
            pre.setDate(5, java.sql.Date.valueOf(employee.getBirth()));
            pre.setString(6, employee.getRole());

            checkInsert = pre.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException e) {
        }
        return checkInsert;
    }

    //Get Employee by Id
    public Employee getEmployeeById(String employeeId) {
        Employee employee = null;
        String sql = "SELECT * FROM Employee WHERE employeeId = ?";

        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(sql);
            pre.setString(1, employeeId);
            rs = pre.executeQuery();
            while (rs.next()) {
                employee = createEmployeeFromResultSet(rs);
            }
        } catch (ClassNotFoundException | SQLException ex) {
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pre != null) {
                    pre.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
        return employee;
    }

    //id, EmployeeName, password, phone, birth, address
    public Employee createEmployeeFromResultSet(ResultSet rs) throws SQLException {
        String employeeId = rs.getString("EmployeeId");
        String employeeName = rs.getString("EmployeeName");
        String password = rs.getString("password");
        String phone = rs.getString("phone");
        LocalDate birth = rs.getDate("birth").toLocalDate();
        String role = rs.getString("role");

        return new Employee(employeeId, employeeName, password, phone, birth, role);
    }
}
