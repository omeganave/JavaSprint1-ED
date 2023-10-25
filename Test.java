import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Library library = new Library();

        Book book = new Book("Book 1", new Author("Author 1", new Date()), "ISBN 1", "Publisher 1", 5,
                Status.AVAILABLE);
        library.addBooks(book);

        Patron patron1 = new Patron("Patron 1", "Address 1", "Phone 1");
        Patron patron2 = new Patron("Patron 2", "Address 2", "Phone 2");
        library.registerPatron(patron1);
        library.registerPatron(patron2);

        library.borrowBook(book, patron1);
        library.borrowBook(book, patron2);
        library.borrowBook(book, patron2);
        library.returnBook(book, patron2);
        library.borrowBook(book, patron1);
        library.borrowBook(book, patron2);
        System.out.println(book);
    }
}
