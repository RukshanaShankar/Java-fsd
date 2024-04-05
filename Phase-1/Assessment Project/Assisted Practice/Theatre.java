package phase1_project;

public class Theatre {
	private Movie[] movies;
    private Seat[] seats;

    public Theatre(Movie[] movies, int numSeats) {
        this.movies = movies;
        this.seats = new Seat[numSeats];
        initializeSeats();
    }

    private void initializeSeats() {
        for (int i = 0; i < seats.length; i++) {
            seats[i] = new Seat(String.format("%02d", i + 1));
        }
    }

    public Movie[] getMovies() {
        return movies;
    }

    public Seat[] getSeats() {
        return seats;
    }

    public boolean bookSeat(int seatIndex) {
        if (seatIndex >= 0 && seatIndex < seats.length && !seats[seatIndex].isBooked()) {
            seats[seatIndex].book();
            return true;
        }
        return false;
    }

    public boolean bookSeats(int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex >= seats.length || startIndex >= endIndex) {
            return false;
        }

        for (int i = startIndex; i <= endIndex; i++) {
            if (seats[i].isBooked()) {
                return false;
            }
        }

        for (int i = startIndex; i <= endIndex; i++) {
            seats[i].book();
        }

        return true;
    }
   

}
