import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Library library = new Library();

        Book book = new Book("Book 1", new Author("Author 1", new Date()), "ISBN 1", "Publisher 1", 2,
                Status.AVAILABLE);
        Book book2 = new Book("Book 2", new Author("Author 2", new Date()), "ISBN 2", "Publisher 2", 2,
                Status.AVAILABLE);

        Patron patron1 = new Patron("Patron 1", "Address 1", "Phone 1");
        Patron patron2 = new Patron("Patron 2", "Address 2", "Phone 2");
        library.registerPatrons(patron1, patron2);

        library.addBooks(book);
        library.removeBooks(book, book2);

    }
}
