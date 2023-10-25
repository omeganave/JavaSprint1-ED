import java.util.ArrayList;

public class Patron {
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Book> borrowedBooks;

    public Patron(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBorrowedBooks() {
        ArrayList<String> bookTitles = new ArrayList<>();
        for (Book book : borrowedBooks) {
            bookTitles.add(book.getTitle());
        }
        return this.name + ": " + bookTitles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    public boolean hasBorrowedBook(Book book) {
        for (Book b : borrowedBooks) {
            if (b.equals(book)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Patron{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
