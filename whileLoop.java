public class whileLoop {
    public static void main(String[] args) {
        // int i = 1;
        // while (i <= 20) {
        //     if (i % 2 == 0) {
        //         System.out.println(i);
        //     }
        //     i++;
        // }
        // int fact = 1;
        // int number = 5;
        // int i = 1;
        // while (i <= number) {
        //     fact = fact * i;
        //     i++;
        // }
        // System.out.println(fact);

        int n=5;
        int fact=1;

       do{
             fact=fact*n;
            n--;
        }while(n>=10);
       System.out.println("Factorial="+fact);
    
    }
}
