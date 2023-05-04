import java.util.Date;

public class Book extends Item{
    //attributes such as author and publisher . Contains methods such as rentBook and returnBook
    private String author, publisher;

    public Book(String title, String genre, Date releaseDate, int id, RentalStore rentalStore, String author, String publisher){
        super(title, genre, releaseDate, id, rentalStore);

        this.author = author;
        this.publisher = publisher;
    }

//-----------------------------------------------------------getters and setters
    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }
}
