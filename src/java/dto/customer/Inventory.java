/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.customer;

import dto.car.Car;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Nonobeam <https://github.com/Nonobeam>
 */

//inventoryId, manuDate, factuDate
public class Inventory {
    private String inventoryId;
    private LocalDate manuDate;
    private LocalDate factuDate;
    private List<Car> carList;
    
    // Constructor
    public Inventory(String inventoryId, LocalDate manuDate, LocalDate factuDate, List<Car> carList) {
        this.inventoryId = inventoryId;
        this.manuDate = manuDate;
        this.factuDate = factuDate;
        this.carList = carList;
    }

    // Getters and Setters
    public String getInventoryId() {
        return inventoryId;
    }
    
    public void setInventoryId(String inventoryId) {    
        this.inventoryId = inventoryId;
    }

    public LocalDate getManuDate() {
        return manuDate;
    }

    public void setManuDate(LocalDate manuDate) {
        this.manuDate = manuDate;
    }

    public LocalDate getFactuDate() {
        return factuDate;
    }

    public void setFactuDate(LocalDate factuDate) {
        this.factuDate = factuDate;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
