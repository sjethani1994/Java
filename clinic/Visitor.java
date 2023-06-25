package clinic;

public class Visitor {
    private String name;
    private int age;

    public Visitor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

