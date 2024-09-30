package sirma.exam.Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private String filePath;

    public CSVReader(String filePath){
        this.filePath=filePath;
    }
    public List<Employee> readFromCSV(){
        List<Employee> employees=new ArrayList<>();
        try (BufferedReader br=new BufferedReader(new FileReader(filePath))){
            String line;
            while((line= br.readLine())!=null){
                String[] data= line.split(",");
                int id=Integer.parseInt(data[0]);
                String name=data[1];
                LocalDate startDate= LocalDate.parse(data[2]);
                LocalDate endDate=data[3].equals("null")?null:LocalDate.parse(data[3]);
                String department=data[4];
                String role=data[5];
                double salary=Double.parseDouble(data[6]);

                Employee employee=new Employee(id,name,startDate,department,role,salary);
                employee.setEndDate(endDate);
                employee.setWorking(endDate==null);

                employees.add(employee);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return employees;
    }
}
