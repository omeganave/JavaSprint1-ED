import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book("Title1", new Author("Author1", new Date()), "ISBN1", "Publisher1", 5, Status.AVAILABLE);
        Book book2 = new Book("Title2", new Author("Author2", new Date()), "ISBN2", "Publisher2", Status.AVAILABLE);
        Book book3 = new Book("Title3", new Author("Author3", new Date()), "ISBN3", "Publisher3", 5, Status.AVAILABLE);
        library.addBooks(book1, book2, book3);

        library.searchBooksByISBN("ISBN3");

    }
}
