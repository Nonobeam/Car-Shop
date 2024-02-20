/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.customer;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Nonobeam <https://github.com/Nonobeam>
 */

//id, customerName, password, phone, int age, address
public class Customer {
    private String customerId;
    private String customerName;
    private String password;
    private String phone;
    private LocalDate birth;
    private String address;
    private List<Inventory> inventoryList;
   
    
    // Constructor with customerId
    public Customer(String customerId, String customerName, String password, String phone, LocalDate birth, String address) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.password = password;
        this.phone = phone;
        this.birth = birth;
        this.address = address;
    }
    
    // Constructor
    public Customer(String customerName, String password, String phone, LocalDate birth, String address) {
        this.customerName = customerName;
        this.password = password;
        this.phone = phone;
        this.birth = birth;
        this.address = address;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }
}
