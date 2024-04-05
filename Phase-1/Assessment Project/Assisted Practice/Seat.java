package phase1_project;

public class Seat {

	 private String seatNumber;
	    private boolean isBooked;

	    public Seat(String seatNumber) {
	        this.seatNumber = seatNumber;
	        this.isBooked = false;
	    }

	    public String getSeatNumber() {
	        return seatNumber;
	    }

	    public boolean isBooked() {
	        return isBooked;
	    }

	    public void book() {
	        isBooked = true;
	    }
}
