// NEED TO ADD OVERDUE SYSTEM.

import java.util.Map;
import java.util.Set;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Patron {
    // Instance variables for the patron's name, address, phone number and list of
    // borrowed books.
    private String name;
    private String address;
    private String phoneNumber;
    private Map<BorrowedCopy, Calendar> borrowedBooks;

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
        List<BookCopy> availableCopies = book.getCopies();
        Calendar dueDate = calculateDueDate();

        for (int i = 0; i < numCopies; i++) {
            if (i < availableCopies.size()) {
                BookCopy copyToBorrow = availableCopies.get(i);
                BorrowedCopy borrowedCopy = new BorrowedCopy(book, copyToBorrow);
                borrowedBooks.put(borrowedCopy, dueDate);
                copyToBorrow.setStatus(Status.CHECKED_OUT);
            }
        }
        System.out.println("Books borrowed successfully.");
    }

    // Removes a book from the patron's list of borrowed books.
    public void returnBook(Book book, int numCopies) {
        Set<BorrowedCopy> copiesToReturn = new HashSet<>();

        for (Map.Entry<BorrowedCopy, Calendar> entry : borrowedBooks.entrySet()) {
            BorrowedCopy borrowedCopy = entry.getKey();
            if (borrowedCopy.getBook() == book && numCopies > 0) {
                copiesToReturn.add(borrowedCopy);
                numCopies--;
            }
        }

        for (BorrowedCopy copy : copiesToReturn) {
            borrowedBooks.remove(copy);
            copy.getBookCopy().setStatus(Status.AVAILABLE);
        }
    }

    private Calendar calculateDueDate() {
        Calendar dueDate = Calendar.getInstance();
        dueDate.add(Calendar.DAY_OF_MONTH, 14);
        return dueDate;
    }

    public void displayBorrowedBooks() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        for (Map.Entry<BorrowedCopy, Calendar> entry : borrowedBooks.entrySet()) {
            BorrowedCopy borrowedCopy = entry.getKey();
            Calendar dueDate = entry.getValue();
            System.out.println(borrowedCopy.getBook().getTitle() + " due " + dateFormat.format(dueDate.getTime()));
            System.out.println();
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
