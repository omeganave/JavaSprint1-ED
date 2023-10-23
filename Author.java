import java.util.Date;
import java.util.ArrayList;

public class Author {
    private String name;
    private Date dateOfBirth;
    private ArrayList<Book> booksWritten;

    public Author(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.booksWritten = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public ArrayList<Book> getBooksWritten() {
        return booksWritten;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void addWrittenBook(Book book) {
        booksWritten.add(book);
    }

    public void removeWrittenBook(Book book) {
        booksWritten.remove(book);
    }

    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                // ", booksWritten=" + booksWritten +
                '}';
    }
}
