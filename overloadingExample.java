public class overloadingExample {
    public static void main(String[] args){
        overloadingExample polyExOne = new overloadingExample();

        System.out.println(polyExOne.getNum(10, 20));
        System.out.println(polyExOne.getNum(5.0, 7.0));
        System.out.println(polyExOne.getNum(3, 6, 9));

        System.out.println(getValue(3.0, 7.0));
        System.out.println(getValue(9.0, 7.0, 6.0));
        System.out.println(getValue(5, 8));
    }

    public int getNum(int x, int y){
        return x + y;
    }

    public int getNum(int x, int y, int z){
        return x + y + z;
    }

    public int getNum(double x, double y){
        int z = (int) (x + y);
        return z;
    }

    public static double getValue(double a, double b){
        return a + b;
    }

    public static double getValue(double a, double b, double c){
        return a + b + c;
    }

    public static double getValue(int a, int b){
        double y = a + b;
        return y;
    }
}
