// NEED TO ADD OVERDUE SYSTEM.

import java.util.List;
import java.util.ArrayList;

public class Library {
    // Three lists. Books, Patrons, and Authors that are part of the library.
    private List<Book> books;
    private List<Patron> patrons;
    private List<Author> authors;

    // Basic constructor for the library. Assumes that there are no books, patrons,
    // or authors yet, so creates empty lists for all three.
    public Library() {
        books = new ArrayList<>();
        patrons = new ArrayList<>();
        authors = new ArrayList<>();
    }
    //
    //
    //
    //
    //
    // Search methods.

    // Search for a book by its title.
    public void searchBooksByTitle(String title) {
        boolean found = false;
        for (Book book : books) {
            // If the title matches the title of a book in the library, prints the book to
            // the console and sets found to true.
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                found = true;
            }
        }
        // If no matching books are found, prints a message to the console.
        if (!found) {
            System.out.println("Book titled '" + title + "' not found.");
        }
    }

    // Search for a book by its author's name (as a string).
    public void searchBooksByAuthorName(String author) {
        boolean found = false;
        for (Book book : books) {
            // If the author's name matches the author's name of a book in the library,
            // prints the book to the console and sets found to true.
            if (book.getAuthor().getName().equalsIgnoreCase(author)) {
                System.out.println(book);
                found = true;
            }
        }
        // If no matching books are found, prints a message to the console.
        if (!found) {
            System.out.println("Book written by '" + author + "' not found.");
        }
    }

    // Search for a book by its author (as an Author object).
    public void searchBooksByAuthorObject(Author author) {
        boolean found = false;
        for (Book book : books) {
            // If the author matches a book in the library's author, prints the book to the
            // console and sets found to true.
            if (book.getAuthor().equals(author)) {
                System.out.println(book);
                found = true;
            }
        }
        // If no matching books are found, prints a message to the console.
        if (!found) {
            System.out.println("Book written by '" + author.getName() + "' not found.");
        }
    }

    // Search for a book by its ISBN.
    public void searchBooksByISBN(String isbn) {
        boolean found = false;
        for (Book book : books) {
            // If the ISBN matches the ISBN of a book in the library, prints the book to the
            // console and sets found to true.
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                System.out.println(book);
                found = true;
            }
        }
        // If no matching books are found, prints a message to the console.
        if (!found) {
            System.out.println("Book with ISBN '" + isbn + "' not found.");
        }
    }

    // Search for a book by its publisher.
    public void searchBooksByPublisher(String publisher) {
        boolean found = false;
        for (Book book : books) {
            // If the publisher matches the publisher of a book in the library, prints the
            // book to the console and sets found to true.
            if (book.getPublisher().equals(publisher)) {
                System.out.println(book);
                found = true;
            }
        }
        // If no matching books are found, prints a message to the console.
        if (!found) {
            System.out.println("Book published by '" + publisher + "' not found.");
        }
    }

    //
    //
    //
    //
    //
    // Adders and removers.

    // Add as many existing books as desired to the library.
    public void addBooks(Book... books) {
        for (Book book : books) {
            // Adds each passed book to the library's books list.
            this.books.add(book);
        }
        // Prints a message to the console based on how many books were added.
        if (books.length == 1) {
            System.out.println("Book added successfully.");
        } else if (books.length == 0) {
            System.out.println("No books added.");
        } else {
            System.out.println(books.length + " books added successfully.");
        }
    }

    // Remove as many existing books as desired from the library.
    public void removeBooks(Book... books) {
        for (Book book : books) {
            // Removes each passed book from the library's books list.
            this.books.remove(book);
        }
        // Prints a message to the console based on how many books were removed.
        if (books.length == 1) {
            System.out.println("Book removed successfully.");
        } else if (books.length == 0) {
            System.out.println("No books removed.");
        } else {
            System.out.println(books.length + " books removed successfully.");
        }
    }

    // Add as many existing patrons as desired to the library.
    public void registerPatrons(Patron... patrons) {
        for (Patron patron : patrons) {
            // Adds each passed patron to the library's patrons list.
            this.patrons.add(patron);
        }
        // Prints a message to the console based on how many patrons were registered.
        if (patrons.length == 1) {
            System.out.println("Patron registered successfully.");
        } else if (patrons.length == 0) {
            System.out.println("No patrons registered.");
        } else {
            System.out.println(patrons.length + " patrons registered successfully.");
        }
    }

    // Remove as many existing patrons as desired from the library.
    public void unregisterPatrons(Patron... patrons) {
        for (Patron patron : patrons) {
            // Removes each passed patron from the library's patrons list.
            this.patrons.remove(patron);
        }
        // Prints a message to the console based on how many patrons were unregistered.
        if (patrons.length == 1) {
            System.out.println("Patron unregistered successfully.");
        } else if (patrons.length == 0) {
            System.out.println("No patrons unregistered.");
        } else {
            System.out.println(patrons.length + " patrons unregistered successfully.");
        }
    }

    // Add as many existing authors as desired to the library.
    public void addAuthors(Author... authors) {
        for (Author author : authors) {
            // Adds each passed author to the library's authors list.
            this.authors.add(author);
        }
        // Prints a message to the console based on how many authors were added.
        if (authors.length == 1) {
            System.out.println("Author added successfully.");
        } else if (authors.length == 0) {
            System.out.println("No authors added.");
        } else {
            System.out.println(authors.length + " authors added successfully.");
        }
    }

    // Remove as many existing authors as desired from the library.
    public void removeAuthors(Author... authors) {
        for (Author author : authors) {
            // Removes each passed author from the library's authors list.
            this.authors.remove(author);
        }
        // Prints a message to the console based on how many authors were removed.
        if (authors.length == 1) {
            System.out.println("Author removed successfully.");
        } else if (authors.length == 0) {
            System.out.println("No authors removed.");
        } else {
            System.out.println(authors.length + " authors removed successfully.");
        }
    }

    //
    //
    //
    //
    //
    // Borrow a book to a patron. Simply calls the book's borrowBook() method.
    public void borrowBook(Book book, Patron patron, int numberOfCopies) {
        patron.borrowBook(book, numberOfCopies);
    }

    // Return a book to a patron. Simply calls the book's returnBook() method.
    public void returnBook(Book book, Patron patron, int numberOfCopies) {
        patron.returnBook(book, numberOfCopies);
    }

    // Checks to see if a specified book is available to be borrowed.
    public void isBookAvailable(Book book) {
        if (book.getNumberOfCopies() > 0) {
            System.out.println(book.getTitle() + " is available. " + book.getNumberOfCopies() + " copies available.");
        } else {
            System.out.println(book.getTitle() + " is not available.");
        }
    }

    // Returns the number of books, patrons, and authors in the library.
    public String toString() {
        return "Library{" +
                "Number of books=" + books.size() +
                ", Number of patrons=" + patrons.size() +
                ", Number of authors=" + authors.size() +
                "}";
    }
}