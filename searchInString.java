public class searchInString {
    public static void main(String[] args) {
        String s1 = "Encyclopaedia ";
        System.out.println(s1.contains("el"));
        System.out.println(s1.indexOf("l"));
        System.out.println(s1.lastIndexOf("l"));
        String s2 = s1.substring(2, 7);
        System.out.println(s2);

        String s3 = s1.replace("e", "o");
        System.out.println(s3);

        String s4 = s1.replaceAll("a", "o");
        System.out.println(s4);

        System.out.println(s1.toLowerCase());
        System.out.println(s1.toUpperCase());
        System.out.println(s1.trim());

        int number = 42;
        System.out.println(Integer.toString(number));
        System.out.println(s1 + Integer.toString(number));
        String j = "10";
        System.out.println(Integer.parseInt(j));
        int k = 10;
        System.out.println(k + Integer.parseInt(j));

        // String s5 = "Sumit, Jethani, HeroVired";
        // String[] s6 = s5.split(",");
        // System.out.println(s6);
        System.out.println(j.getClass().getSimpleName());
    }
}
