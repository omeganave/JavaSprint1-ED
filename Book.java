public class Book implements Borrowable {
    private String title;
    private Author author;
    private String isbn;
    private String publisher;
    private int numberOfCopies;
    private int copiesBorrowed;
    private Status status;

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
        this.copiesBorrowed = 0;
    }

    public Book(String title, Author author, String isbn, String publisher, Status status) {
        this.title = title;
        this.author = author;
        author.addWrittenBook(this);
        this.isbn = isbn;
        this.publisher = publisher;
        this.status = status;
        this.numberOfCopies = 0;
        this.copiesBorrowed = 0;
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

    public int getCopiesBorrowed() {
        return copiesBorrowed;
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

    @Override
    public void borrowBook(Patron patron) {
        if (status == Status.AVAILABLE && patron.hasBorrowedBook(this) == false) {
            patron.addBorrowedBook(this);
            copiesBorrowed += 1;
            if (copiesBorrowed == numberOfCopies) {
                status = Status.CHECKED_OUT;
            }
            System.out.println("Book borrowed successfully.");
        } else if (patron.hasBorrowedBook(this) == true) {
            System.out.println("Book is already borrowed.");
        } else {
            System.out.println("Book is not available.");
        }
    }

    @Override
    public void returnBook(Patron patron) {
        if (patron.hasBorrowedBook(this) == true) {
            patron.removeBorrowedBook(this);
            copiesBorrowed -= 1;
            if (status == Status.CHECKED_OUT) {
                status = Status.AVAILABLE;
            }
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book is not checked out by this patron.");
        }
    }

    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                // Author DOB and books written are irrelevant to the book itself.
                ", author='" + author.getName() + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", numberOfCopies=" + numberOfCopies + '\'' +
                ", copiesBorrowed=" + copiesBorrowed + '\'' +
                ", status=" + status +
                '}';
    }
}