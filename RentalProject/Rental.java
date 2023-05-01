import java.util.Date;

public class Rental {
    private int ID;
    private Movie movie;
    private Customer customer;
    private Date rentalDate;
    private Date returnDate;

    public Rental(int ID, Movie movie, Customer customer) {
        this.ID = ID;
        this.movie = movie;
        this.customer = customer;
        movie.setAvailable(false);
        this.rentalDate = new Date();
    }

//-----------------------------------------------------------getters and setters

    public int getID() {
        return ID;
    }

    public Movie getMovie() {
        return movie;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

}
