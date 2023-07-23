import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class employeeFileHandling {
    private static String fileName = "employee.csv";

    private static void writeDataToCsv() {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(fileName))) {
            wr.write("Name ,EmpId, Designation, Salary");
            wr.newLine();
            wr.write("Sumit, 101, Developer, 30000");
            wr.newLine();
            wr.write("Sandeep, 102, Developer, 40000");
            wr.newLine();
            wr.write("Gopal, 103, Engineer, 10000");
            wr.newLine();
            wr.write("Rahul, 104, Sales Manager, 50000");
            wr.newLine();
            wr.write("Kalpesh, 105, Team Lead, 60000");
            wr.newLine();
            wr.write("Satyajit, 106, Full Stack Developer, 20000");
            wr.newLine();
            wr.write("Umesh, 107, Developer, 70000");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readDataFromCsv() {
        try (BufferedReader re = new BufferedReader(new FileReader(fileName))) {
            String line;
            line = re.readLine();
            while ((line = re.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0].trim();
                int empId = Integer.parseInt(data[1].trim());
                System.out.println("Name of employee " + name + " Employee Id " + empId);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getEmployeeNameWithSalaryGreaterThanFiftyThousand() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.readLine();
            reader.lines()
                    .map(line -> line.split(","))
                    .filter(data -> Integer.parseInt(data[3].trim()) > 50000)
                    .forEach(data -> System.out
                            .println("Name of employee with salary greater than 50,0000 " + data[0].trim()
                                    + " Salary is " + data[3].trim()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        writeDataToCsv();
        readDataFromCsv();
        getEmployeeNameWithSalaryGreaterThanFiftyThousand();
    }
}
