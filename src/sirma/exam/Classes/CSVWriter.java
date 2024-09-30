package sirma.exam.Classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    private String filePath;

    public CSVWriter(String filePath){
        this.filePath=filePath;
    }

    public void writeToCSV( List<Employee> employees){
        try (BufferedWriter bw=new BufferedWriter(new FileWriter(filePath))){
            for(Employee employee:employees){
                bw.write(employee.getId() + "," + employee.getName() + "," + employee.getStartDate() + "," +
                        (employee.getEndDate() == null ? "null" : employee.getEndDate()) + "," +
                        employee.getDepartment() + "," + employee.getRole() + "," + employee.getSalary());
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
