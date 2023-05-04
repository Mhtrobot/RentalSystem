
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentalStore {
    private List<Movie> movies;
    private List<Customer> customers;

    public RentalStore() {
        this.movies = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    //---------------------------------------------------
    public void register(Customer customer){
        customers.add(customer);
    }

    public void AddMovie(Movie movie) {
        movies.add(movie);
    }

    public void removeMovie(Movie movie) {
        for (Movie m:movies) {
            if (m.getID() == movie.getID()){
                for (Customer i:customers) {
                    for (int j = 0; j < i.getRentals().size(); j++) {
                        if (i.getRentals().get(j).getMovie().equals(movie)){
                            i.getRentals().remove(j);
                        }
                    }
                }
                movies.remove(m);
            }
        }
    }

    public List<Movie> getAvailableMovies(){
        List<Movie> avamovies = new ArrayList<>();
        for (int i=0; i< movies.size(); i++) {
            if (movies.get(i).isAvailable() == true)
                avamovies.add(movies.get(i));
        }
        return avamovies;
    }

    public void rentMovie(Movie movie, Customer customer){
        if (movie.isAvailable() == true){
            String id1 = Integer.toString(movie.getID());
            String id2 = Integer.toString(customer.getID());
            String id0 = id1.concat(id2);
            int id = Integer.parseInt(id0);
            Rental rental = new Rental(id, movie, customer);
            customer.getRentals().add(rental);
        }
    }

    public void returnMovie(Rental rental){
        int count=0;
        for (Customer c:customers) {
            if (c.getRentals().get(count).getID() == rental.getID()){
                Date date = new Date();
                rental.setReturnDate(date);
                rental.getMovie().setAvailable(true);
                c.getRentals().remove(count);
            }
            count++;
        }
    }

    public Customer getCustomersById(int id) {
        for (Customer c:customers) {
            if (c.getID() == id){
                return c;
            }
        }
        return null;
    }

    public Movie getMovieById(int id){
        for (Movie m:movies) {
            if (m.getID() == id){
                return m;
            }
        }
        return null;
    }
}
