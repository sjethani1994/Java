public class TestOne {
    public static void main(String[] args) {

        EncapTest1 encapTest1 = new EncapTest1();

        EncapTest1 encapTest2 = new EncapTest1("Jay", "IT");

        encapTest1.setName("Sumit");

        System.out.println(encapTest1.getName());

        System.out.println(encapTest2.getName());
        System.out.println(encapTest2.getDepartment());
        System.out.println(encapTest2.getSubject());
        System.out.println(encapTest2.getClass());

    }
}
