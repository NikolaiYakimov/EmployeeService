package sirma.exam.Interfaces;

import sirma.exam.Classes.Employee;

import java.util.List;

public interface EmployeeServiceable  {
    void addEmployee(Employee employee);
    void editEmployee(int id,String name, String department, String role, double salary);
    void fireEmployee(int id);
    List<Employee> getActiveEmployees();
    Employee searchById(int id);
    List<Employee> searchByName(String name);
    List<Employee> searchByDepartment(String department);
    List<Employee> loadData();
    void saveData();
}
