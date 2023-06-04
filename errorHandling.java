public class errorHandling extends Exception {
    public static void main(String[] args) {
    // try {
    // int i = 10 / 0;
    // System.out.println(i);
    // int j = null;
    // System.out.println(j);
    // } catch (ArithmeticException e) {
    // System.out.println(e);
    // } finally {
    // System.out.println("This piece will be excuted everytime. wheather there
    //is
    // an expection or not.");
    // }
    try {
    int age = 18;
    if (age < 0) {
    throw new Exception("Age cannot be negative.");
    }
    } catch (Exception e) {
    System.out.println(e);
    } finally {
    System.out.println("This piece will be excuted everytime. wheather there is an expection or not.");
    }
    }

}
