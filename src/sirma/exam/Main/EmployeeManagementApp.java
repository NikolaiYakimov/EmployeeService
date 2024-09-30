package sirma.exam.Main;

import sirma.exam.Classes.EmployeeManager;
import sirma.exam.Classes.EmployeeService;

import java.util.Scanner;

public class EmployeeManagementApp {
    public static void main(String[] args) {
        EmployeeService service=new EmployeeService("D:/Sirma izpit/employees.csv");
        EmployeeManager manager=new EmployeeManager(service);

        Scanner scanner=new Scanner(System.in);
        boolean isRunning=true;

        System.out.println("Welcome to Employee Management System");
        displayCommands();

        while(isRunning){
            System.out.println("Enter command:");
            String command=scanner.nextLine();
            if(command.equalsIgnoreCase("save & exit")){
                manager.executeMenuCommands("save & exit");
                isRunning=false;
            }
            else {
                manager.executeMenuCommands(command);
            }
        }
    }

    private static void displayCommands() {
        System.out.println("Commands:");
        System.out.println("  add - Add a new employee");
        System.out.println("  edit - Edit an existing employee");
        System.out.println("  fire - Fire an employee");
        System.out.println("  list - List all employees");
        System.out.println("  search- you can search by id,name,department");
        System.out.println("  save & exit-Save the data and exit the app");
    }
}