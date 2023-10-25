import java.util.Date;
import java.util.ArrayList;

public class Author {
    // Instance variables for the author's name, date of birth, and list of books
    // written.
    private String name;
    private Date dateOfBirth;
    private ArrayList<Book> booksWritten;

    // Constructor for the author. Assumes that the list of books written is empty,
    // and sets it to an empty list.
    public Author(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.booksWritten = new ArrayList<>();
    }

    // Getters.

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public ArrayList<Book> getBooksWritten() {
        return booksWritten;
    }

    // Setters.

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Adds a book to the author's list of books written.
    public void addWrittenBook(Book book) {
        booksWritten.add(book);
    }

    // Removes a book from the author's list of books written.
    public void removeWrittenBook(Book book) {
        booksWritten.remove(book);
    }

    // Returns a string representation of the author.
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                // ", booksWritten=" + booksWritten +
                '}';
    }
}
