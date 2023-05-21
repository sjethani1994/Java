public class cretingString {
    public static void main(String[] args) {
        // String s1 = "hello";
        // String s2 = "Hello";

        String s1 = new String("baaa");
        String s2 = new String("aaab");

        System.out.println(s1.length());
        System.out.println(s1 + " " + s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
        System.out.println(s2.compareTo(s1));
        // if (s1 == s2) {
        //     System.out.println("Same.");
        // } else {
        //     System.out.println("different");
        // }
    }
}
