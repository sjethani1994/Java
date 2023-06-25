package clinic;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentManagementSystem {
    private List<Visitor> visitors;
    private List<Appointment> appointments;

    public AppointmentManagementSystem() {
        this.visitors = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    public void viewVisitorsList() {
        System.out.println("Visitors List:");
        for (Visitor visitor : visitors) {
            System.out.println(visitor);
        }
    }

    public void addNewVisitor(Scanner scanner) {
        System.out.print("Enter visitor name: ");
        String name = scanner.next();
        System.out.print("Enter visitor age: ");
        int age = scanner.nextInt();

        Visitor visitor = new Visitor(name, age);
        visitors.add(visitor);

        System.out.println("Visitor added successfully!");
    }

    public void editVisitorDetails(Scanner scanner) {
        System.out.print("Enter visitor name: ");
        String name = scanner.next();

        Visitor foundVisitor = null;
        for (Visitor visitor : visitors) {
            if (visitor.getName().equalsIgnoreCase(name)) {
                foundVisitor = visitor;
                break;
            }
        }

        if (foundVisitor != null) {
            System.out.print("Enter new age: ");
            int age = scanner.nextInt();
            foundVisitor.setAge(age);

            System.out.println("Visitor details updated!");
        } else {
            System.out.println("Visitor not found!");
        }
    }

    public void viewAppointmentSchedule(Scanner scanner) {
        System.out.print("Enter the date (yyyy-mm-dd): ");
        String dateString = scanner.next();
        LocalDate date = LocalDate.parse(dateString);

        System.out.println("Appointment Schedule for " + date + ":");
        for (Appointment appointment : appointments) {
            if (appointment.getDate().equals(date)) {
                System.out.println(appointment);
            }
        }
    }

    public void bookAppointment(Scanner scanner) {
        System.out.print("Enter visitor name: ");
        String visitorName = scanner.next();

        System.out.print("Enter appointment date (yyyy-mm-dd): ");
        String dateString = scanner.next();
        LocalDate date = LocalDate.parse(dateString);

        System.out.print("Enter appointment time (hh:mm): ");
        String timeString = scanner.next();
        LocalTime time = LocalTime.parse(timeString);

        Appointment appointment = new Appointment(visitorName, date, time);
        appointments.add(appointment);

        System.out.println("Appointment booked successfully!");
    }

    public void editCancelAppointment(Scanner scanner) {
        System.out.print("Enter visitor name: ");
        String visitorName = scanner.next();

        System.out.print("Enter appointment date (yyyy-mm-dd): ");
        String dateString = scanner.next();
        LocalDate date = LocalDate.parse(dateString);

        System.out.print("Enter appointment time (hh:mm): ");
        String timeString = scanner.next();
        LocalTime time = LocalTime.parse(timeString);

        Appointment foundAppointment = null;
        for (Appointment appointment : appointments) {
            if (appointment.getVisitorName().equalsIgnoreCase(visitorName) &&
                    appointment.getDate().equals(date) &&
                    appointment.getTime().equals(time)) {
                foundAppointment = appointment;
                break;
            }
        }

        if (foundAppointment != null) {
            System.out.println("Appointment found!");
            System.out.println(foundAppointment);

            System.out.println("\n1. Update Appointment");
            System.out.println("2. Cancel Appointment");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter new appointment date (yyyy-mm-dd): ");
                String newDateString = scanner.next();
                LocalDate newDate = LocalDate.parse(newDateString);

                System.out.print("Enter new appointment time (hh:mm): ");
                String newTimeString = scanner.next();
                LocalTime newTime = LocalTime.parse(newTimeString);

                foundAppointment.setDate(newDate);
                foundAppointment.setTime(newTime);

                System.out.println("Appointment updated successfully!");
            } else if (choice == 2) {
                appointments.remove(foundAppointment);
                System.out.println("Appointment canceled!");
            } else {
                System.out.println("Invalid choice!");
            }
        } else {
            System.out.println("Appointment not found!");
        }
    }
}

