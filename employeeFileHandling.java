import java.io.BufferedWriter;
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        writeDataToCsv();
    }
}
