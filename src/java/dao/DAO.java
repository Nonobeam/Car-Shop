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

    //Buy A Car with A Customer ID
    public boolean buyCar(String carId, String customerId) {
        boolean checkInsert = false;
        String sql = "INSERT INTO Customer_Car (customerId, carId) VALUES (?, ?)";

        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(sql);

            pre.setString(1, customerId);
            pre.setString(2, carId);

            checkInsert = pre.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            // Handle exceptions
        } finally {
            try {
                if (pre != null) {
                    pre.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Handle exceptions
            }
        }

        return checkInsert;
    }

    //Make new Car
    public boolean createCar(Car newCar) {
        boolean checkInsert = false;
        String sql = "INSERT INTO Car (carId, model, date, VIN, colour, licensePlate, make, location, price, image, quantity) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(sql);

            pre.setString(1, newCar.getCarId());
            pre.setString(2, newCar.getModel());
            java.sql.Date sqlDate = java.sql.Date.valueOf(newCar.getDate());
            pre.setDate(3, sqlDate);
            pre.setString(4, newCar.getVIN());
            pre.setString(5, newCar.getColour());
            pre.setString(6, newCar.getLicensePlate());
            pre.setString(7, newCar.getMake());
            pre.setString(8, newCar.getLocation());
            pre.setDouble(9, newCar.getPrice());
            pre.setInt(10, newCar.getQuantity());

            pre.executeUpdate();

            checkInsert = pre.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException ex) {
        } finally {
            try {
                if (pre != null) {
                    pre.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }

        return checkInsert;
    }

    //Fileter Car with Brand, Location, Date, Price, Price
    public List<Car> getFilteredCars(String selectedBrand, String selectedLocation, String selectedDate, String minPrice, String maxPrice) {
        List<Car> cars = new ArrayList<>();
        //some suck things that I have to learn more to fix this
        //this dump will let other below code work fine without caring about the "AND" in sql statement 
        String sql = "SELECT * FROM Car WHERE quantity > 0";

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

    //Get all Cars that had sold in the store even when nothing left
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

    //Get all Model that we sell
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

    //Get all Location that we sell
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

    //Get all Productor that we collaborate
    public List<Productor> getAllProductors() {
        List<Productor> list = new ArrayList<>();
        String sql = "SELECT * FROM Productor";
        try {
            connection = DBUtils.getConnection();
            pre = connection.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                //productorId, productorName, address
                Productor productor = new Productor(
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

    //Get Car by Id even when nothing left
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

    //Get Car by Model even when nothing left
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

    //Get Car by Location even when nothing left
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

    //Get Car by Date even when nothing left
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

    //Get Car by Price even when nothing left
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

    //Create Car entity
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
                rs.getString("image"),
                rs.getInt("quantity")
        );
    }

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
