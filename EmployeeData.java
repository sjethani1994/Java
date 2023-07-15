public class EmployeeData {
    public int EmployeeId;
    public String EmployeeName;
    public int salary;

    public EmployeeData(int EmployeeId, String EmployeeName, int salary) {
        this.EmployeeId = EmployeeId;
        this.EmployeeName = EmployeeName;
        this.salary = salary;
    }

    public String toString() {
        return "EmployeeData{" +
                "id=" + EmployeeId +
                ", name='" + EmployeeName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
