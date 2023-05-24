import java.util.Scanner;

public class UserInputQuiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Which planet is known as the \"Red Planet\"? ");
        String planetInput = sc.nextLine();
        String Planet = "Mars";

        if (planetInput.toLowerCase().equals(Planet.toLowerCase())) {
            System.out.println("Your answer is correct.");
        } else {
            System.out.println("Your answer is not correct. The correct answer is " + Planet);
        }

        System.out.println("2. What is the tallest mountain in the world?");
        String mountainInput = sc.nextLine();
        String moutain = "Mount Everest";

        if (mountainInput.toLowerCase().equals(moutain.toLowerCase())) {
            System.out.println("Your answer is correct.");
        } else {
            System.out.println("Your answer is not correct. The correct answer is " + moutain);
        }

        System.out.println("3. What is the capital city of Australia?");
        String captialInput = sc.nextLine();
        String captial = "Canberra";

        if (captialInput.toLowerCase().equals(captial.toLowerCase())) {
            System.out.println("Your answer is correct.");
        } else {
            System.out.println("Your answer is not correct. The correct answer is " + captial);
        }

        System.out.println("4. What is the chemical symbol for the element gold?");
        String elemetInput = sc.nextLine();
        String element = "Au";

        if (elemetInput.toLowerCase().equals(element.toLowerCase())) {
            System.out.println("Your answer is correct.");
        } else {
            System.out.println("Your answer is not correct. The correct answer is " + element);
        }

        System.out.println("5. In which year did World War II end?");
        int yearInput = sc.nextInt();
        int year = 1945;

        if (yearInput == year) {
            System.out.println("Your answer is correct.");
        } else {
            System.out.println("Your answer is not correct. The correct answer is " + year);
        }

        sc.close();
    }
}
