package sirma.exam.Classes;

import java.time.LocalDate;
import java.util.Scanner;

public class EmployeeManager {
    private EmployeeService service;
    private Scanner scanner;

    public EmployeeManager(EmployeeService employeeService) {
        this.service = employeeService;
        this.scanner = new Scanner(System.in);
    }

    public void executeMenuCommands(String command) {
        switch (command.toLowerCase()) {
            case "add": {
                addEmployee();
                break;
            }
            case "edit":
                editEmployee();
                break;
            case "fire":
                fireEmployee();
                break;
            case "list":
                listEmployee();
                break;
            case "search":
                searchEmployee();
                break;
            case "save & exit":
                saveAndExit();
                break;
            default:
                System.out.println("Invalid command");
        }

    }

    private void addEmployee() {
        System.out.println("Enter name ");
        String name = scanner.nextLine();
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        System.out.print("Enter role: ");
        String role = scanner.nextLine();
        System.out.print("Enter salary: ");
        double salary = Double.parseDouble(scanner.nextLine());
        Employee employee = new Employee(0, name, LocalDate.now(), department, role, salary); // ID will be set by service
        service.addEmployee(employee);
        System.out.println("Employee added!");
    }

    private void editEmployee() {
        System.out.print("Enter ID of the employee to edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new department: ");
        String department = scanner.nextLine();
        System.out.print("Enter new role: ");
        String role = scanner.nextLine();
        System.out.print("Enter new salary: ");
        double salary = Double.parseDouble(scanner.nextLine());
        service.editEmployee(id, name, department, role, salary);

    }

    private void fireEmployee() {
        System.out.println("Enter Id of the employee to fire: ");
        int id = Integer.parseInt(scanner.nextLine());
        service.fireEmployee(id);
    }

    private void listEmployee() {
        System.out.println("List of the active employees:");
        for (var emp : service.getActiveEmployees()) {
            System.out.println(emp);
        }
    }

    private void searchEmployee() {
        System.out.print("Search by (id/name/department): ");
        String criteria = scanner.nextLine();
        switch (criteria.toLowerCase()) {
            case "id":
                System.out.print("Enter ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                Employee emp = service.searchById(id);
                System.out.println(emp);
                break;
            case "name":
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                for (Employee e : service.searchByName(name)) {
                    System.out.println(e);
                }
                break;
            case "department":
                System.out.print("Enter department: ");
                String department = scanner.nextLine();
                for (Employee e : service.searchByDepartment(department)) {
                    System.out.println(e);
                }
                break;
            default:
                System.out.println("Invalid search criteria");
        }
    }

    private void saveAndExit() {
        service.saveData();
        System.out.println("Data saved.");
        System.exit(0);
    }


}
