import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String email;
    private String phone;
    private String address;
    private List<Rental> rentals;
    private int ID;

    public Customer(String name, String email, String phone, String address, int ID) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.ID = ID;
        this.rentals = new ArrayList<>();
    }

//-----------------------------------------------------getters and setters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getID() {
        return ID;
    }

    public List<Rental> getRentals() {
        return rentals;
    }
}
