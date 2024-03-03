/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.car;

/**
 *
 * @author Nonobeam <https://github.com/Nonobeam>
 */

import java.time.LocalDate;


//carId, model, price, date, VIN, colour, licensePlate, make, Location, quantity
public class Car {
    private String carId;
    private String model;
    private double price;
    //Manufacturing date
    private LocalDate date;
    private String VIN;
    private String colour;
    private String licensePlate;
    //The company Productor id
    private String make;
    private String location;
    private String imageUrl;
    private int quantity;

    // Constructor
    public Car(String carId, String model, double price, LocalDate date, String VIN, String colour, String licensePlate, String make, String location, String imageUrl, int quantity) {
        this.carId = carId;
        this.model = model;
        this.price = price;
        this.date = date;
        this.VIN = VIN;
        this.colour = colour;
        this.licensePlate = licensePlate;
        this.make = make;
        this.location = location;
        this.imageUrl = imageUrl;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getCarId() {
        return carId;
    }

    public void setId(String carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

