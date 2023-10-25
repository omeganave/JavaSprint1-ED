public class Book implements Borrowable {
    // Instance variables for the book.
    private String title;
    private Author author;
    private String isbn;
    private String publisher;
    // The number of total copies of the book, and the number of copies currently
    // borrowed.
    private int numberOfCopies;
    private int copiesBorrowed;
    private Status status;

    // Both constructors call the Author's addWrittenBook method to add the book to
    // the author's list of books written automatically.

    // Constructor for the book. Sets copies borrowed to 0.
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

    // Constructor for the book. Sets copies borrowed to 0, and sets the number of
    // copies to 0 if the number is not specified.
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

    // Borrows the book to a given patron.
    @Override
    public void borrowBook(Patron patron) {
        // Checks to see if the book is both available, and the patron does not already
        // have the book borrowed.
        if (status == Status.AVAILABLE && patron.hasBorrowedBook(this) == false) {
            // If the conditions are met...
            // Adds the book to the patron's list of borrowed books, adds 1 to the book's
            // copiesBorrowed, and sets the status to CHECKED_OUT if the copy being borrowed
            // is the last one.
            patron.addBorrowedBook(this);
            copiesBorrowed += 1;
            if (copiesBorrowed == numberOfCopies) {
                status = Status.CHECKED_OUT;
            }
            // Prints a message to the console based on whether the book was successfully
            // borrowed.
            System.out.println("Book borrowed successfully.");
        } else if (patron.hasBorrowedBook(this) == true) {
            System.out.println("Book is already borrowed.");
        } else {
            System.out.println("Book is not available.");
        }
    }

    // Returns the book from a given patron.
    @Override
    public void returnBook(Patron patron) {
        // Checks to see if the patron has the book checked out.
        if (patron.hasBorrowedBook(this) == true) {
            // If the conditions are met...
            // Removes the book from the patron's list of borrowed books, subtracts 1 from
            // the book's copiesBorrowed, and sets the status to AVAILABLE if the status was
            // CHECKED_OUT, since the book now has at least one copy available.
            patron.removeBorrowedBook(this);
            copiesBorrowed -= 1;
            if (status == Status.CHECKED_OUT) {
                status = Status.AVAILABLE;
            }
            // Prints a message to the console based on whether the book was successfully
            // returned.
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book is not checked out by this patron.");
        }
    }

    // Returns a string representation of the book.
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