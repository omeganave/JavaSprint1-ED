public class Book implements Borrowable {
    private String title;
    private String author;
    private String isbn;
    private String publisher;
    private int numberOfCopies;
    private Status status;

    public Book(String title, String author, String isbn, String publisher, int numberOfCopies, Status status) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
        this.status = status;
    }
    // Implement these constructors once Status is defined!

    // public Book(String title, String author, String isbn, String publisher, int
    // numberOfCopies) {
    // this.title = title;
    // this.author = author;
    // this.isbn = isbn;
    // this.publisher = publisher;
    // this.numberOfCopies = numberOfCopies;
    // this.status =
    // }

    public Book(String title, String author, String isbn, String publisher, Status status) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.status = status;
        this.numberOfCopies = 0;
    }

    // public Book(String title, String author, String isbn, String publisher) {
    // this.title = title;
    // this.author = author;
    // this.isbn = isbn;
    // this.publisher = publisher;
    // this.numberOfCopies = 0;
    // this.status =
    // }

    // GETTERS

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
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

    public void setAuthor(String author) {
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

    // @Override
    // public void borrowBook(Patron patron) {
    // if (status == Status.AVAILABLE)
    // }

    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", numberOfCopies=" + numberOfCopies +
                ", status=" + status +
                '}';
    }
}