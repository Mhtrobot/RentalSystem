import java.util.Date;

public class Game extends Item{
    //attributes such as platform and publisher. Contains methods such as rentGame and returnGame
    private String platform, publisher;

    public Game(String title, String genre, Date releaseDate, int id,RentalStore rentalStore, String platform, String publisher){
        super(title, genre, releaseDate, id, rentalStore);

        this.platform = platform;
        this.publisher = publisher;
    }

//-----------------------------------------------------------getters and setters

    public String getPlatform() {
        return platform;
    }

    public String getPublisher() {
        return publisher;
    }
}
