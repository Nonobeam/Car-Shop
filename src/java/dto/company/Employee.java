/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.company;

import java.time.LocalDate;

/**
 *
 * @author Nonobeam <https://github.com/Nonobeam>
 */

//employeeId, employeeName password, phone, birth, role
public class Employee {
    private String employeeId;
    private String employeeName;
    private String password;
    private String phone;
    private LocalDate birth;
    private String role;
    

    public Employee(String employeeId, String name, String password, String phone, LocalDate birth, String role) {
        this.employeeId = employeeId;
        this.employeeName = name;
        this.password = password;
        this.phone = phone;
        this.birth = birth;
        this.role = role;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
