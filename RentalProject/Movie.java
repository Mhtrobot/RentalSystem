import java.util.Date;

public class Movie {
    private String title;
    private String genre;
    private String director;
    private String cast;
    private Date releaseDate;
    private int ID;
    private boolean isAvailable;

    public Movie(String title, String genre, String director, String cast, Date releaseDate, int ID) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.cast = cast;
        this.releaseDate = releaseDate;
        this.ID = ID;
        this.isAvailable = true;
    }

//-----------------------------------------------------------getters and setters
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getCast() {
        return cast;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public int getID() {
        return ID;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
