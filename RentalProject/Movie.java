
import java.util.Date;

public class Movie extends Item{
    //attributes such as director and cast. Contains methods such as rentMovie and returnMovie
    private String director;
    private String cast;

    public Movie(String title, String genre, Date releaseDate, int id, RentalStore rentalStore, String director, String cast) {
        super(title, genre, releaseDate, id, rentalStore);

        this.director = director;
        this.cast = cast;
    }

//-----------------------------------------------------------getters and setters
    public String getDirector() {
        return director;
    }

    public String getCast() {
        return cast;
    }
}
