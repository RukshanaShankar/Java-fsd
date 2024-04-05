package phase1_project;

import java.util.Scanner;

public class FrontDesk {
	 private static String USERNAME;
	    private static String PASSWORD;
	    private static final int TICKET_PRICE = 100; 
	    private String currentPassword;
	    private Theatre theatre;

	    public FrontDesk(Theatre theatre) {
	        this.theatre = theatre;
	        this.currentPassword = PASSWORD;
	    }
	    
	    public boolean login(String username, String password) {
	        this.USERNAME=username;
	    	this.PASSWORD=password;
	    	return true;
	    }

	    public void updatePassword(String newPassword) {
	    	if(PASSWORD.equals(newPassword))
	    	{
	    		Scanner sc = new Scanner(System.in);
	    		System.out.println("New password cannot be same as old password");
	    		System.out.println("Enter a different password to update");
	    		String changePassword = sc.next();
	    	
	        currentPassword = changePassword;
	    	}
	    }


	    public void viewSeating(String date, String showtime) {
	        Movie[] movies = theatre.getMovies();
	        Seat[] seats = theatre.getSeats();

	        Movie movie = null;
	        for (Movie m : movies) {
	            if (m.getShowtime().equals(showtime)) {
	                movie = m;
	                break;
	            }
	        }

	        if (movie == null) {
	            System.out.println("No movie found for the given showtime.");
	            return;
	        }

	        System.out.println("Movie: " + movie.getTitle() + " (" + movie.getShowtime() + ")");
	        System.out.println("Seating Arrangement:");

	        for (int i = 0; i < seats.length; i++) {
	            Seat seat = seats[i];
	            System.out.print(seat.getSeatNumber() + " " + (seat.isBooked() ? "[X]" : "[ ]") + " ");

	            if ((i + 1) % 10 == 0) {
	                System.out.println();
	            }
	        }
	    }

	    public void bookTicket(String date, String showtime, String seatSelection) {
	        Scanner scanner = new Scanner(System.in);
	        Movie[] movies = theatre.getMovies();
	        Seat[] seats = theatre.getSeats();

	        Movie movie = null;
	        for (Movie m : movies) {
	            if (m.getShowtime().equals(showtime)) {
	                movie = m;
	                break;
	            }
	        }

	        if (movie == null) {
	            System.out.println("No movie found for the given showtime.");
	            return;
	        }

	        if (seatSelection.contains("-")) {
	            String[] range = seatSelection.split("-");
	            int startIndex = Integer.parseInt(range[0]) - 1;
	            int endIndex = Integer.parseInt(range[1]) - 1;

	            if (theatre.bookSeats(startIndex, endIndex)) {
	                int numSeats = endIndex - startIndex + 1;
	                int totalAmount = numSeats * TICKET_PRICE;
	                System.out.println("Total amount: $" + totalAmount);
	                System.out.print("Confirm booking? (yes/no): ");
	                String confirmation = scanner.nextLine();

	                if (confirmation.equalsIgnoreCase("yes")) {
	                    System.out.println("Seats booked successfully!");
	                } else {
	                    System.out.println("Booking canceled.");
	                }
	            } else {
	                System.out.println("Invalid seat selection or seats already booked.");
	            }
	        } else {
	            int seatIndex = Integer.parseInt(seatSelection) - 1;

	            if (theatre.bookSeat(seatIndex)) {
	                int totalAmount = TICKET_PRICE;
	                System.out.println("Total amount: Rs" + totalAmount);
	                System.out.print("Confirm your booking? (yes/no): ");
	                String confirmation = scanner.nextLine();

	                if (confirmation.equalsIgnoreCase("yes")) {
	                    System.out.println("Seat booked successfully!");
	                } else {
	                    System.out.println("Booking canceled.");
	                }
	            } else {
	                System.out.println("Invalid seat number or seat already booked.");
	            }
	        }
	    }

	    public void checkStatus(String date, String showtime) {
	        viewSeating(date, showtime);
	    }

}
