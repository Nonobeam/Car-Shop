/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.customer;

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
    private int age;
    private String address;
    private List<Inventory> inventoryList;
   
    
    // Constructor with customerId
    public Customer(String customerId, String customerName, String password, String phone, int age, String address) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.password = password;
        this.phone = phone;
        this.age = age;
        this.address = address;
    }
    
    // Constructor
    public Customer(String customerName, String password, String phone, int age, String address) {
        this.customerName = customerName;
        this.password = password;
        this.phone = phone;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
