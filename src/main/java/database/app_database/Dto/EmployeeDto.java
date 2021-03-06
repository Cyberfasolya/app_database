package database.app_database.Dto;

import java.time.Instant;

public class EmployeeDto {
    private Integer id;
    private String name;
    private String surname;
    private String gender;
    private String workStartDate;
    private int monthlySalary;
    private String role;
    private int roleAttribute;

    public int getRoleAttribute() {
        return roleAttribute;
    }

    public void setRoleAttribute(int roleAttribute) {
        this.roleAttribute = roleAttribute;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setWorkStartDate(String workStartDate) {
        this.workStartDate = workStartDate;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getSurname() {
        return surname;
    }

    public String getWorkStartDate() {
        return workStartDate;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }
}

