public class methodOverloading {
    public static void main(String[] args) {
        System.out.println(convertToCentimeters(5, 8));
    }

    public static double convertToCentimeters(int heightInInches) {
        return heightInInches * 2.54;
    }
    public static double convertToCentimeters(int heightInFeet, int heightInInches) {
        // return ((heightInFeet * 12) + heightInInches) * 2.54;
       // return convertToCentimeters((heightInFeet * 12) + heightInInches);
        int feetToInches = heightInFeet * 12;
        int totalInches = feetToInches + heightInInches;
        double result = convertToCentimeters(totalInches);
        return  result;
    }

}
