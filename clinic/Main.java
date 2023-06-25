package clinic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppointmentManagementSystem ams = new AppointmentManagementSystem();

        int choice;

        do {
            System.out.println("\nAppointment Management System Menu:");
            System.out.println("1. Visitors List");
            System.out.println("2. Add New Visitor");
            System.out.println("3. Edit Visitor Details");
            System.out.println("4. View Appointment Schedule for a Day");
            System.out.println("5. Book an Appointment");
            System.out.println("6. Edit/Cancel Appointment");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ams.viewVisitorsList();
                    break;
                case 2:
                    ams.addNewVisitor(scanner);
                    break;
                case 3:
                    ams.editVisitorDetails(scanner);
                    break;
                case 4:
                    ams.viewAppointmentSchedule(scanner);
                    break;
                case 5:
                    ams.bookAppointment(scanner);
                    break;
                case 6:
                    ams.editCancelAppointment(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}

