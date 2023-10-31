// NEED TO ADD OVERDUE SYSTEM.

import java.util.Map;
import java.util.HashMap;

public class Patron {
    // Instance variables for the patron's name, address, phone number and list of
    // borrowed books.
    private String name;
    private String address;
    private String phoneNumber;
    private Map<Book, Integer> borrowedBooks;

    // Constructor for the patron. Assumes that the list of borrowed books is empty,
    // and sets it to an empty list.
    public Patron(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new HashMap<>();
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
    // public String getBorrowedBooks() {
    // ArrayList<String> bookTitles = new ArrayList<>();
    // for (Book book : borrowedBooks) {
    // bookTitles.add(book.getTitle());
    // }
    // return this.name + ": " + bookTitles;
    // }

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
    public void borrowBook(Book book, int numCopies) {
        if (book.borrowBook(numCopies)) {
            int currentCopies = borrowedBooks.getOrDefault(book, 0);
            borrowedBooks.put(book, currentCopies + numCopies);
            System.out.println("Book(s) borrowed successfully.");
        } else {
            System.out.println("Not enough copies available. " + book.getNumberOfCopies() + " copies available.");
        }
    }

    // Removes a book from the patron's list of borrowed books.
    public void returnBook(Book book, int numCopies) {
        int currentCopies = borrowedBooks.getOrDefault(book, 0);
        if (currentCopies >= numCopies) {
            book.returnBook(numCopies);
            int updatedCopies = currentCopies - numCopies;
            if (updatedCopies > 0) {
                borrowedBooks.put(book, updatedCopies);
            } else {
                borrowedBooks.remove(book);
            }
            System.out.println("Book(s) returned successfully.");
        } else {
            System.out.println("Trying to return too many copies. Only " + currentCopies + " copies available.");
        }
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
