import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Patron> patrons;
    private ArrayList<Author> authors;

    public Library() {
        books = new ArrayList<>();
        patrons = new ArrayList<>();
        authors = new ArrayList<>();
    }

    public void searchBooksByTitle(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book titled '" + title + "' not found.");
        }
    }

    public void searchBooksByAuthorName(String author) {
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().getName().equals(author)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book written by '" + author + "' not found.");
        }
    }

    public void searchBooksByAuthorObject(Author author) {
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book written by '" + author.getName() + "' not found.");
        }
    }

    public void searchBooksByISBN(String isbn) {
        boolean found = false;
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book with ISBN '" + isbn + "' not found.");
        }
    }

    public void searchBooksByPublisher(String publisher) {
        boolean found = false;
        for (Book book : books) {
            if (book.getPublisher().equals(publisher)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book published by '" + publisher + "' not found.");
        }
    }

    public void addBooks(Book... books) {
        for (Book book : books) {
            this.books.add(book);
        }
        if (books.length == 1) {
            System.out.println("Book added successfully.");
        } else {
            System.out.println(books.length + " books added successfully.");
        }
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public void unregisterPatron(Patron patron) {
        patrons.remove(patron);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void removeAuthor(Author author) {
        authors.remove(author);
    }

    public void borrowBook(Book book, Patron patron) {
        book.borrowBook(patron);
    }

    public void returnBook(Book book) {
        book.returnBook();
    }

    public String toString() {
        return "Library{" +
                "Number of books=" + books.size() +
                ", Number of patrons=" + patrons.size() +
                ", Number of authors=" + authors.size() +
                "}";
    }
}