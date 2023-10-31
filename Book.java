import java.util.ArrayList;
import java.util.List;

public class Book implements Borrowable {
    // Instance variables for the book.
    private String title;
    private Author author;
    private String isbn;
    private String publisher;
    private int numberOfCopies;
    private List<Status> copyStatuses;

    // Both constructors call the Author's addWrittenBook method to add the book to
    // the author's list of books written automatically.

    // Constructor for the book.
    public Book(String title, Author author, String isbn, String publisher, int numberOfCopies) {
        this.title = title;
        this.author = author;
        author.addWrittenBook(this);
        this.isbn = isbn;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
        this.copyStatuses = new ArrayList<>();
        initializeCopyStatuses();
    }

    // Constructor for the book. Sets the number of
    // copies to 0 if the number is not specified.
    public Book(String title, Author author, String isbn, String publisher) {
        this.title = title;
        this.author = author;
        author.addWrittenBook(this);
        this.isbn = isbn;
        this.publisher = publisher;
        this.numberOfCopies = 0;
        this.copyStatuses = new ArrayList<>();
        initializeCopyStatuses();
    }

    private void initializeCopyStatuses() {
        for (int i = 0; i < numberOfCopies; i++) {
            copyStatuses.add(Status.AVAILABLE);
        }
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

    public List<Status> getCopyStatuses() {
        return copyStatuses;
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
    public void borrowBook(int numberOfCopiesToBorrow) {
        List<Integer> availableCopyIndices = findAvailableCopyIndices(numberOfCopiesToBorrow);
        if (availableCopyIndices.size() == numberOfCopiesToBorrow) {
            for (int copyIndex : availableCopyIndices) {
                copyStatuses.set(copyIndex, Status.CHECKED_OUT);
            }
        }
    }

    // Returns the book from a given patron.
    @Override
    public void returnBook(int numberOfCopiesToReturn) {
        List<Integer> checkedOutCopyIndices = findCheckedOutCopyIndices(numberOfCopiesToReturn);
        for (int copyIndex : checkedOutCopyIndices) {
            copyStatuses.set(copyIndex, Status.AVAILABLE);
        }
    }

    public List<Integer> findAvailableCopyIndices(int numCopiesToFind) {
        List<Integer> availableCopyIndices = new ArrayList<>();
        for (int i = 0; i < copyStatuses.size(); i++) {
            if (copyStatuses.get(i) == Status.AVAILABLE) {
                availableCopyIndices.add(i);
                if (availableCopyIndices.size() == numCopiesToFind) {
                    break;
                }
            }
        }
        return availableCopyIndices;
    }

    public List<Integer> findCheckedOutCopyIndices(int numCopiesToFind) {
        List<Integer> checkedOutCopyIndices = new ArrayList<>();
        for (int i = 0; i < copyStatuses.size(); i++) {
            if (copyStatuses.get(i) == Status.CHECKED_OUT) {
                checkedOutCopyIndices.add(i);
                if (checkedOutCopyIndices.size() == numCopiesToFind) {
                    break;
                }
            }
        }
        return checkedOutCopyIndices;
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
                '}';
    }
}