package dao;

import dto.customer.Customer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
                        rs.getInt("customerId"),
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
        // auto increase id inside database
        String query = "INSERT INTO Customer(customerName, password, phone, address, birth) VALUES (?, ?, ?, ?, ?)";
        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(query);
            pre.setString(1, customer.getCustomerName());
            pre.setString(2, customer.getPassword());
            pre.setString(3, customer.getPhone());
            pre.setString(4, customer.getAddress());
            pre.setDate(5, java.sql.Date.valueOf(customer.getBirth()));

            checkInsert = pre.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException e) {
        }
        return checkInsert;
    }

    //Get Customer by Id
    public Customer getCustomerById(int customerId) {
        Customer customer = null;
        String sql = "SELECT * FROM Customer WHERE customerId = ?";

        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(sql);
            pre.setInt(1, customerId);
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

    public String getFactuDate(String carId) {
        String result = "";
        String sql = "SELECT i.factuDate FROM Inventory i\n"
                + "INNER JOIN InventoryCar ic ON i.inventoryId = ic.inventoryId\n"
                + "INNER JOIN Car c ON ic.carId = c.carId\n"
                + "WHERE c.carId = ?";
        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(sql);
            pre.setString(1, carId);
            rs = pre.executeQuery();
            while (rs.next()) {
                result = rs.getString("factuDate");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            result = ex.getMessage();
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
                result += e.getMessage();
            }
        }
        return result;
    }
    
    public String getManuDate(String carId) {
        String result = "";
        String sql = "SELECT i.manuDate FROM Inventory i\n"
                + "INNER JOIN InventoryCar ic ON i.inventoryId = ic.inventoryId\n"
                + "INNER JOIN Car c ON ic.carId = c.carId\n"
                + "WHERE c.carId = ?";
        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(sql);
            pre.setString(1, carId);
            rs = pre.executeQuery();
            while (rs.next()) {
                result = rs.getString("manuDate");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            result = ex.getMessage();
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
                result += e.getMessage();
            }
        }
        return result;
    }
    
    public boolean editCustomer(int customerId, String customerName, String phone, String birth, String address) {
        boolean checkUpdate = false;
        String sql = "UPDATE Customer\n"
                + "SET customerName = ?, phone = ?, address = ?, birth = ?\n"
                + "WHERE customerId = ?";

        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(sql);
            pre.setString(1, customerName);
            pre.setString(2, phone);
            pre.setString(3, address);
            pre.setDate(4, java.sql.Date.valueOf(LocalDate.parse(birth)));
            pre.setInt(5, customerId);

            checkUpdate = pre.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException | IllegalArgumentException ex) {
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
        return checkUpdate;
    }

    //id, customerName, password, phone, birth, address
    public Customer createCustomerFromResultSet(ResultSet rs) throws SQLException {
        int customerId = rs.getInt("customerId");
        String customerName = rs.getString("customerName");
        String password = rs.getString("password");
        String phone = rs.getString("phone");
        LocalDate birth = rs.getDate("birth").toLocalDate();
        String address = rs.getString("address");

        return new Customer(customerId, customerName, password, phone, birth, address);
    }
}
