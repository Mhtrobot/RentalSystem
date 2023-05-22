
import java.util.ArrayList;
import java.util.List;

public class RentalStore {
    private List<Item> items;
    private List<Customer> customers;

    public RentalStore() {
        this.items = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    //---------------------------------------------------
    public void register(Customer customer){
        customers.add(customer);
    }

    public void AddItem(Movie movie) {
        items.add(movie);
    }

    public void removeMovie(Item item) {
        for (Item m:items) {
            if (m.getId() == item.getId()){
                if (item.isAvailable() == true){
                    items.remove(m);
                }
            }
        }
    }

//------------------------------------------------------------------------------
    public List<Item> getAvailableItems(){
        List<Item> avaItems = new ArrayList<>();
        for (int i=0; i< items.size(); i++) {
            if (items.get(i).isAvailable() == true)
                avaItems.add(items.get(i));
        }
        return avaItems;
    }

    public List<Customer> getCustomers(){
        List<Customer> availableCustomers = new ArrayList<>();
        for (int i=0; i< this.customers.size(); i++) {
            availableCustomers.add(customers.get(i));
        }
        return customers;
    }

    public Item getItemById(int id){
        for (Item m:items) {
            if (m.getId() == id){
                return m;
            }
        }
        return null;
    }

    public Customer getCustomersById(int id) {
        for (Customer c:customers) {
            if (c.getID() == id){
                return c;
            }
        }
        return null;
    }

    public void removeItem(Item item){
        for (Item i:items) {
            if (i.getId() == item.getId()){
                for (Customer c:customers) {
                    for (int j = 0; j < c.getRentals().size(); j++) {
                        if (c.getRentals().get(j).getItem().getId() == item.getId())
                            c.getRentals().remove(j);
                    }
                }
                items.remove(i);
            }
        }
    }
}
