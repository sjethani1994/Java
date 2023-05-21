import java.util.Scanner;

public class EMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Loan amount
        System.out.println("Enter the loan amount:");
        double loanAmount = scanner.nextDouble();

        // Loan duration in years
        System.out.println("Enter the loan duration in years:");
        double loanDurationYears = scanner.nextDouble();

        // Convert years to months
        double loanDurationMonths = loanDurationYears * 12;

        // Monthly interest rate is 6%
        double monthlyInterestRate = 0.06 / 12;

        double interestFactor = Math.pow((1 + monthlyInterestRate), loanDurationMonths);

        double monthlyPayment = loanAmount * (monthlyInterestRate * interestFactor) / (interestFactor - 1);
        System.out.printf("Monthly payment amount: %.2f%n", monthlyPayment);

        double totalInterest = Math.abs(monthlyPayment * loanDurationMonths - loanAmount);
        System.out.printf("Total interest: %.2f%n", totalInterest);

        scanner.close();
    }
}

