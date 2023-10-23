// TODO: Do I need setters and getters for Status?

public class Book implements Borrowable {
    private String title;
    private Author author;
    private String isbn;
    private String publisher;
    private int numberOfCopies;
    private Status status;
    private Patron currentPatron;

    // Constructors. I've added an extra constructor for the case where the number
    // of available books is currently unknown.

    public Book(String title, Author author, String isbn, String publisher, int numberOfCopies, Status status) {
        this.title = title;
        this.author = author;
        author.addWrittenBook(this);
        this.isbn = isbn;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
        this.status = status;
        this.currentPatron = null;
    }

    public Book(String title, Author author, String isbn, String publisher, Status status) {
        this.title = title;
        this.author = author;
        author.addWrittenBook(this);
        this.isbn = isbn;
        this.publisher = publisher;
        this.status = status;
        this.numberOfCopies = 0;
        this.currentPatron = null;
    }

    // GETTERS

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public Status getStatus() {
        return status;
    }

    // SETTERS

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // Add these Override methods once Status and Patron are defined!

    @Override
    public void borrowBook(Patron patron) {
        if (status == Status.AVAILABLE) {
            status = Status.CHECKED_OUT;
            patron.addBorrowedBook(this);
            currentPatron = patron;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }

    @Override
    public void returnBook() {
        if (status == Status.CHECKED_OUT) {
            status = Status.AVAILABLE;
            currentPatron.removeBorrowedBook(this);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book is not checked out.");
        }
    }

    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                // Author DOB and books written are irrelevant to the book itself.
                ", author='" + author.getName() + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", numberOfCopies=" + numberOfCopies +
                ", status=" + status +
                '}';
    }
}