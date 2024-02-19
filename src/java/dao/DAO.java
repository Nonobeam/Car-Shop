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

    public List<Car> getFilteredCars(String selectedBrand, String selectedLocation, String selectedDate, String minPrice, String maxPrice) {
        List<Car> cars = new ArrayList<>();
        //some suck things that I have to learn more to fix this
        //this dump will let other below code work fine without caring about the "AND" in sql statement 
        String sql = "SELECT * FROM Car WHERE 1 = 1";

        if (selectedBrand != null && !selectedBrand.isEmpty()) {
            sql += " AND model = ?";
        }

        if (selectedLocation != null && !selectedLocation.isEmpty()) {
            sql += " AND location = ?";
        }

        if (selectedDate != null && !selectedDate.isEmpty()) {
            sql += " AND date >= ?";
        }

        if ((minPrice != null && !minPrice.isEmpty()) && (maxPrice != null && !maxPrice.isEmpty())) {
            sql += " AND price BETWEEN ? AND ?";
        }

        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(sql);

            //tired of texting 1 2 3 4 5 in here so I use this
            int parameterIndex = 1;

            if (selectedBrand != null && !selectedBrand.isEmpty()) {
                pre.setString(parameterIndex++, selectedBrand);
            }

            if (selectedLocation != null && !selectedLocation.isEmpty()) {
                pre.setString(parameterIndex++, selectedLocation);
            }

            if (selectedDate != null && !selectedDate.isEmpty()) {
                pre.setString(parameterIndex++, selectedDate);
            }

            if (minPrice != null && !minPrice.isEmpty() && maxPrice != null && !maxPrice.isEmpty()) {
                pre.setDouble(parameterIndex++, Double.parseDouble(minPrice));
                pre.setDouble(parameterIndex++, Double.parseDouble(maxPrice));
            }

            rs = pre.executeQuery();
            while (rs.next()) {
                Car car = createCarFromResultSet(rs);
                cars.add(car);
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

        return cars;
    }

    public List<Car> getAllCars() {
        List<Car> list = new ArrayList<>();
        String sql = "SELECT * FROM Car";
        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Car car = createCarFromResultSet(rs);
                list.add(car);
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

        return list;
    }

    public List<String> getAllModels() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT DISTINCT model FROM Car";
        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("model"));
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

        return list;
    }

    public List<String> getAllLocations() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT DISTINCT location FROM Car";
        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("location"));
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

        return list;
    }
    
    public List<Productor> getAllProductors() {
        List<Productor> list = new ArrayList<>();
        String sql = "SELECT * FROM Productor";
        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                //productorId, productorName, address
                Productor productor = new Productor (
                        rs.getString("productorId"),
                        rs.getString("productorName"),
                        rs.getString("address")
                );
                
                list.add(productor);
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

        return list;
    }

    public Car getCarById(String carId) {
        Car car = null;
        String sql = "SELECT * FROM Car WHERE carId = ?";
        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(sql);
            pre.setString(1, carId);
            rs = pre.executeQuery();
            while (rs.next()) {
                car = createCarFromResultSet(rs);
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
        return car;
    }

    public List<Car> getCarByModel(String model) {
        List<Car> list = new ArrayList<>();
        String sql = "SELECT * FROM Car WHERE model = ?";
        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(sql);
            pre.setString(1, model);
            rs = pre.executeQuery();
            while (rs.next()) {
                Car car = createCarFromResultSet(rs);
                list.add(car);
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
        return list;
    }

    public List<Car> getAllCarsByLocation(String location) {
        List<Car> list = new ArrayList<>();
        String sql = "SELECT * FROM Car WHERE location = ?";
        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(sql);
            pre.setString(1, location);
            rs = pre.executeQuery();
            while (rs.next()) {
                Car car = createCarFromResultSet(rs);
                list.add(car);
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
        return list;
    }

    public List<Car> getCarsByDate(LocalDate date) {
        List<Car> list = new ArrayList<>();
        String sql = "SELECT * FROM Car WHERE date > ?";
        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(sql);
            pre.setDate(1, Date.valueOf(date));
            rs = pre.executeQuery();
            while (rs.next()) {
                Car car = createCarFromResultSet(rs);
                list.add(car);
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
        return list;
    }

    public List<Car> getCarByPriceRange(double minPrice, double maxPrice) {
        List<Car> list = new ArrayList<>();
        String sql = "SELECT * FROM Car WHERE price BETWEEN ? AND ?";
        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(sql);
            pre.setDouble(1, minPrice);
            pre.setDouble(2, maxPrice);
            rs = pre.executeQuery();
            while (rs.next()) {
                Car car = createCarFromResultSet(rs);
                list.add(car);
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
        return list;
    }

    private Car createCarFromResultSet(ResultSet rs) throws SQLException {
        return new Car(
                rs.getString("carId"),
                rs.getString("model"),
                rs.getDouble("price"),
                rs.getDate("date").toLocalDate(),
                rs.getString("VIN"),
                rs.getString("colour"),
                rs.getString("licensePlate"),
                rs.getString("make"),
                rs.getString("location"),
                rs.getString("image")
        );
    }

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
                        Integer.parseInt(rs.getString("age")),
                        rs.getString("address")
                );
                return customer;
            }
        } catch (ClassNotFoundException | SQLException ex) {
        }

        return customer;
    }

    public boolean insert(Customer customer) {
        boolean checkInsert = false;
        //id, customerName, password, phone, int age, address
        String query = "insert into Customer(customerName, password, phone, age, address) values(?, ?, ?, ?)";
        try {
            connection = new DBUtils().getConnection();
            pre = connection.prepareStatement(query);
            pre.setString(2, customer.getCustomerName());
            pre.setString(3, customer.getPassword());
            pre.setString(4, customer.getPhone());
            pre.setInt(5, customer.getAge());
            pre.setString(6, customer.getAddress());

            checkInsert = pre.executeUpdate() > 0 ? true : false;
        } catch (Exception e) {
        }
        return checkInsert;
    }
}
