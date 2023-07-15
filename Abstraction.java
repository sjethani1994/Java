public class Abstraction implements AbInter1 {
    @Override
    public String getStart() {
        return "starting";
    }

    @Override
    public int getCount() {
        return 1;
    }

    public static void main(String[] args) {

        Abstraction intOneDemo = new Abstraction();

        System.out.println(intOneDemo.getStart());
        System.out.println(intOneDemo.getCount());


    }
}
