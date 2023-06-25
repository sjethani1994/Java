public class EncapTest1 {

    private String name;
    private String department;
    private String subject;

    public EncapTest1() {
    }

    public EncapTest1(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "EncapTest1{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
