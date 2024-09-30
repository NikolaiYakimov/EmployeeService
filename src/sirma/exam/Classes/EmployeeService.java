package sirma.exam.Classes;

import sirma.exam.Interfaces.EmployeeServiceable;

import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements EmployeeServiceable {
    private final List<Employee> employees ;
    private final CSVReader fileReader;
    private final CSVWriter fileWriter;
    private  int nextId;
    public EmployeeService(String filePath){
        this.fileReader=new CSVReader(filePath);
        this.fileWriter=new CSVWriter(filePath);
        this.employees=loadData();
        this.nextId=employees.getLast().getId();
    }


    @Override
    public void addEmployee(Employee employee) {
        employee.setId(nextId++);
        employees.add(employee);
    }

    @Override
    public void editEmployee(int id, String name, String department, String role, double salary) {
        Employee employeeToEdit=searchById(id);

            if(employeeToEdit!=null){
            employeeToEdit.setName(name);
            employeeToEdit.setDepartment(department);
            employeeToEdit.setRole(role);
            employeeToEdit.setSalary(salary);
            }

    }

    @Override
    public void fireEmployee(int id) {
        Employee employee=searchById(id);

            if(employee!=null){
                employee.setEndDate(LocalDate.now());
                employee.setWorking(false);
                System.out.println(employee.getId()+". "+employee.getName()+" is fired");
            }


    }

    @Override
    public List<Employee> getActiveEmployees() {
        List<Employee> activeEmployees=new ArrayList<>();
        for (var emp:employees){
            if (emp.isWorking())
                activeEmployees.add(emp);
        }
        return activeEmployees;
    }

    @Override
    public Employee searchById(int id) {
        for (var emp: employees){
            if(emp.getId()==id){
                return emp;
            }
        }
        return null;
    }

    @Override
    public List<Employee> searchByName(String name) {
        List<Employee> nameGroup=new ArrayList<>();
        for(var emp:employees){
            if(emp.getName().equalsIgnoreCase(name)){
                nameGroup.add(emp);
            }
        }
        return nameGroup;
    }

    @Override
    public List<Employee> searchByDepartment(String department) {
        List<Employee> employeesByDepartment=new ArrayList<>();
        for (var emp:employees){
            if(emp.getDepartment().equalsIgnoreCase(department)){
                employeesByDepartment.add(emp);
            }
        }
        return  employeesByDepartment;
    }

    @Override
    public List<Employee> loadData() {
        assert employees != null;
        employees.clear();
//        List<Employee> loadEmployees=fileReader.readFromCSV();
//        return loadEmployees;
        return fileReader.readFromCSV();
    }

    @Override
    public void saveData() {
        fileWriter.writeToCSV(employees);
    }
}
