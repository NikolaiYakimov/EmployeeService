package sirma.exam.Classes;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String department;
    private String role;
    private double salary;
    private boolean isWorking;


    public Employee(int id,String name,LocalDate startDate,String department,String role,double salary){
        this.id=id;
        this.name=name;
        this.startDate=startDate;
        this.department=department;
        this.role=role;
        this.salary=salary;
        this.isWorking=true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getDepartment() {
        return department;
    }

    public String getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    @Override
    public String toString(){
        return id + "," + name + "," + startDate + "," + endDate + "," + department + "," + role + "," + salary;
    }

}
