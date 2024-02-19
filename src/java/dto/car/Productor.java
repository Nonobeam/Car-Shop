/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.car;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Nonobeam <https://github.com/Nonobeam>
 */

//productorId, productorName, address, productoList
public class Productor {
    private String productorId;
    private String productorName;
    private String address;
    private List<Car> productList;
    
    // Constructor
    public Productor(String productorId, String productorName, String address) {
        this.productorId = productorId;
        this.productorName = productorName;
        this.address = address;
    }

    // Getters and Setters
    public String getProductorId() {
        return productorId;
    }

    public void setProductorId(String productorId) {
        this.productorId = productorId;
    }
    
    public String getProductorName() {
        return productorName;
    }

    public void setProductorName(String productorName) {
        this.productorName = productorName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Car> getProductList() {
        return productList;
    }

    public void setProductList(List<Car> productList) {
        this.productList = productList;
    }
}
