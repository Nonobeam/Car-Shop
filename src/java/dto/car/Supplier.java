/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.car;

import dto.customer.Customer;
import java.util.List;

/**
 *
 * @author Nonobeam <https://github.com/Nonobeam>
 */


//Place sell car
public class Supplier {
    private String supplierName;
    private String address;
    private List<Car> carList;
    private List<Customer> customerList;
    
    // Constructor
    public Supplier(String supplierName, String address, List<Car> carList, List<Customer> customerList) {
        this.supplierName = supplierName;
        this.address = address;
        this.carList = carList;
        this.customerList = customerList;
    }

    // Getters and Setters
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
