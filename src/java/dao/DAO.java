package dao;

import dto.car.Car;
import dto.car.Productor;
import dto.customer.Customer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import util.DBUtils;

/**
 *
 * @author Nonobeam <https://github.com/Nonobeam>
 */
//id, customerName, password, phone, int age, address
public class DAO {

    Connection connection;
    PreparedStatement pre;
    ResultSet rs;
    
    //-----------------USER-----------------
    //Check user LOGIN 
    public Customer checkCustomerLogin(String phone, String password) {
        Customer customer = null;
        String sql = "SELECT * FROM Customer WHERE phone = ? AND password = ?";
        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(sql);
            pre.setString(1, phone);
            pre.setString(2, password);
            rs = pre.executeQuery();
            while (rs.next()) {
                customer = new Customer(
                        rs.getString("customerId"),
                        rs.getString("customerName"),
                        rs.getString("password"),
                        rs.getString("phone"),
                        rs.getDate("birth").toLocalDate(),
                        rs.getString("address")
                );
                return customer;
            }
        } catch (ClassNotFoundException | SQLException ex) {
        }

        return customer;
    }

    //Add new Customer
    public boolean insert(Customer customer) {
        boolean checkInsert = false;
        //id, customerName, password, phone, int age, address
        String query = "insert into Customer(customerName, password, phone, address, birth) values(?, ?, ?, ?, ?)";
        try {
            connection = new DBUtils().getConnection();
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setString(1, customer.getCustomerName());
            pre.setString(2, customer.getPassword());
            pre.setString(3, customer.getPhone());
            pre.setString(4, customer.getAddress());
            pre.setDate(5, java.sql.Date.valueOf(customer.getBirth()));

            checkInsert = pre.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return checkInsert;
    }

    //Get Customer by Id
    public Customer getCustomerById(String customerId) {
        Customer customer = null;
        String sql = "SELECT * FROM Customer WHERE customerId = ?";

        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(sql);
            pre.setString(1, customerId);
            rs = pre.executeQuery();
            while (rs.next()) {
                customer = createCustomerFromResultSet(rs);
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
        return customer;
    }

    //id, customerName, password, phone, birth, address
    public Customer createCustomerFromResultSet(ResultSet rs) throws SQLException {
        String customerId = rs.getString("customerId");
        String customerName = rs.getString("customerName");
        String password = rs.getString("password");
        String phone = rs.getString("phone");
        LocalDate birth = rs.getDate("birth").toLocalDate();
        String address = rs.getString("address");

        return new Customer(customerId, customerName, password, phone, birth, address);
    }
    
}
