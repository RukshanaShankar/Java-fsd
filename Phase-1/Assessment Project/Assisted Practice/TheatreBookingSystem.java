package phase1_project;

import java.util.Arrays;
import java.util.Scanner;

public class TheatreBookingSystem {
    public static void main(String[] args) {
        Movie movie1 = new Movie("Venom: The Last Dance", "7:00PM");
        Movie movie2 = new Movie("Elemental", "9:00PM");
        Movie movie3 = new Movie("Inside Out 2", "5:00PM");
        Movie movie4 = new Movie("Dune 2", "10:00AM");
        Movie movie5 = new Movie("Deadpool & Wolverine", "3:00PM");
        Movie movie6 = new Movie("Wicked", "9:00AM");
        Movie movie7 = new Movie("Abigail", "10:00PM");
        
        
        Movie[] movies = { movie1, movie2, movie3, movie4, movie5, movie6, movie7 };
        Theatre theatre = new Theatre(movies, 100);
        FrontDesk frontDesk = new FrontDesk(theatre);

        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;

        while (true) {
            System.out.println("\nWelcome to Movie Ticket Booking System");
            System.out.println("1. Login");
            System.out.println("2. Update Password");
            System.out.println("3. View Seating");
            System.out.println("4. Book Ticket");
            System.out.println("5. Check Status");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    if (frontDesk.login(username, password)) {
                        isLoggedIn = true;
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;
                case 2:
                    if (isLoggedIn) {
                        System.out.print("Enter new password: ");
                        String newPassword = scanner.nextLine();
                        frontDesk.updatePassword(newPassword);
                        System.out.println("Password updated successfully!");
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 3:
                    System.out.print("Enter date (MM/DD/YYYY): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter showtime: ");
                    String showtime = scanner.nextLine();
                    frontDesk.viewSeating(date, showtime);
                    break;
                case 4:
                    if (isLoggedIn) {
                        System.out.print("Enter date (MM/DD/YYYY): ");
                        String date1 = scanner.nextLine();
                        System.out.print("Enter showtime: ");
                        String showtime1 = scanner.nextLine();
                        System.out.print("Enter seat number(s) (e.g., 1, 2-5): ");
                        String seatSelection = scanner.nextLine();
                        frontDesk.bookTicket(date1, showtime1, seatSelection);
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 5:
                    System.out.print("Enter date (MM/DD/YYYY): ");
                    String date1 = scanner.nextLine();
                    System.out.print("Enter showtime: ");
                    String showtime1 = scanner.nextLine();
                    frontDesk.checkStatus(date1, showtime1);
                    break;
                case 6:
                    System.out.println("Exited...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

