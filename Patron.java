import java.util.ArrayList;

public class Patron {
    // Instance variables for the patron's name, address, phone number and list of
    // borrowed books.
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Book> borrowedBooks;

    // Constructor for the patron. Assumes that the list of borrowed books is empty,
    // and sets it to an empty list.
    public Patron(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters.

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Gets the list of borrowed books. Returns a string of the titles of the books
    // the patron has borrowed.
    public String getBorrowedBooks() {
        ArrayList<String> bookTitles = new ArrayList<>();
        for (Book book : borrowedBooks) {
            bookTitles.add(book.getTitle());
        }
        return this.name + ": " + bookTitles;
    }

    // Setters.

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Adds a book to the patron's list of borrowed books.
    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    // Removes a book from the patron's list of borrowed books.
    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    // Returns true if the given book is in the patron's list of borrowed books.
    // Returns false otherwise.
    public boolean hasBorrowedBook(Book book) {
        for (Book b : borrowedBooks) {
            if (b.equals(book)) {
                return true;
            }
        }
        return false;
    }

    // Returns a string representation of the patron.
    public String toString() {
        return "Patron{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
