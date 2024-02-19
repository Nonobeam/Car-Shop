/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.company;

/**
 *
 * @author Nonobeam <https://github.com/Nonobeam>
 */

//Able to interact with private information
public class Employee {
    private String employeeId;
    private String employeeName;
    private int age;
    private String role;
    private String password;

    public Employee(String employeeId, String name, int age, String role, String password) {
        this.employeeId = employeeId;
        this.employeeName = name;
        this.age = age;
        this.role = role;
        this.password = password;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return employeeName;
    }

    public void setName(String name) {
        this.employeeName = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
    
}
