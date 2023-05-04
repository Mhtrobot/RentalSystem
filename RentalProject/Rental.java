import java.util.Date;

public class Rental{
    private int ID;
    private Customer customer;
    private Date rentalDate;
    private Date returnDate;
    private Item item;

    public Rental(int ID, Item item, Customer customer) {
        this.ID = ID;
        this.item = item;
        this.customer = customer;
        item.setAvailable(false);
        this.rentalDate = new Date();
    }

//-----------------------------------------------------------getters and setters

    public int getID() {
        return ID;
    }

    public Item getItem() {
        return item;
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
