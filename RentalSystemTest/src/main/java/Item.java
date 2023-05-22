
import java.util.Date;

public class Item {
    //Contains attributes such as title, genre, and release date. It also includes a unique ID attribute, which can be overridden by the subclasses.

    protected String title;
    protected String genre;
    protected Date releaseDate;
    protected int id;
    protected boolean Available;
    protected RentalStore rentalStore = new RentalStore();

    public Item() {
    }

    public Item(String title, String genre, Date releaseDate, int id) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.id = id;
        this.Available = true;
    }

//-------------------------------------------------------getters and setter

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return Available;
    }

    public void setAvailable(boolean available) {
        Available = available;
    }

    public RentalStore getRentalStore() {
        return rentalStore;
    }

//-------------------------------------------------------methods
    public void rentItem(Item item, Customer customer){
        int id = Integer.parseInt(Integer.toString(item.getId()).concat(Integer.toString(customer.getID())));
        Rental rental = new Rental(id, item, customer);
        customer.getRentals().add(rental);
    }

    public void returnItem(Rental rental){
        for (int i=0; i<rental.getCustomer().getRentals().size(); i++) {
            if (rental.getCustomer().getRentals().get(i).getID() == rental.getID()){
                rental.setReturnDate(new Date());
                rental.getItem().setAvailable(true);
                rental.getCustomer().getRentals().remove(i);
            }
        }
    }
}