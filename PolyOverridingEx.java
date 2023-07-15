public class PolyOverridingEx extends Demo {

    public static void main(String[] args) {
        Demo polyOverridingEx = new PolyOverridingEx();
        polyOverridingEx.run();
    }

    @Override
    public void run() {
        System.out.println("Hi! this is the java class");
        System.out.println("Hi! Python");

        int z = 10 + 20;

        System.out.println(z);
    }
}

class Demo {
    public void run() {
        System.out.println("Hello!");
    }
}
