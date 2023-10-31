import java.util.Calendar;
// Used to use Date, but many of the Date constructors are deprecated.

public class Test {
    public static void main(String[] args) {
        Library library = new Library();

        Calendar tolkienBDay = Calendar.getInstance();
        tolkienBDay.set(1892, 0, 3);
        Author tolkien = new Author("J. R. R. Tolkien", tolkienBDay);

        library.addAuthors(tolkien);

        Book lotrFellowshipOfTheRing = new Book("The Fellowship of the Ring", tolkien, "9780007136599",
                "Harpercollins Pub Ltd", 6);
        Book lotrTwoTowers = new Book("The Two Towers", tolkien, "9780808520900", "Turtleback Books", 6);
        Book lotrReturnOfTheKing = new Book("The Return of the King", tolkien, "9780048230478",
                "George Allen & Unwin LTD", 6);
        Book theHobbit = new Book("The Hobbit", tolkien, "9780044403371", "Harpercollins Pub Ltd", 2);
        Book theSilmarillion = new Book("The Silmarillion", tolkien, "9780261103665", "Harpercollins Pub Ltd", 1);

        library.addBooks(lotrFellowshipOfTheRing, lotrTwoTowers, lotrReturnOfTheKing, theHobbit, theSilmarillion);

        Patron will = new Patron("Will", "666 Front Street", "555-123-4567");
        Patron joe = new Patron("Joe", "777 Back Street", "555-234-5678");
        Patron paul = new Patron("Paul", "888 Middle Street", "555-345-6789");
        Patron robert = new Patron("Robert", "999 Back Street", "555-456-7890");

        library.registerPatrons(will, joe, paul, robert);

        System.out.println(library);

        // Everything adds to the library successfully.

        library.borrowBook(theHobbit, robert, 1);
        library.borrowBook(theHobbit, paul, 1);

        // Books borrowed successfully.

        library.borrowBook(theHobbit, will, 1); // Not enough copies available.

        library.returnBook(theHobbit, robert, 2); // Only one copy available, doesn't return.

        library.returnBook(theHobbit, robert, 1); // Returns robert's copy.

        library.borrowBook(theHobbit, will, 1); // Will is now able to borrow the book.

        library.borrowBook(lotrFellowshipOfTheRing, joe, 2); // Joe borrows two copies.

        library.returnBook(lotrFellowshipOfTheRing, joe, 1); // Joe returns one copy.

        library.returnBook(lotrFellowshipOfTheRing, joe, 1); // Joe returns one more copy.

        library.returnBook(lotrFellowshipOfTheRing, robert, 1); // Robert fails to return a third copy.

        library.borrowBook(theSilmarillion, robert, 1);
        // MAKE IT NOT ALLOW RETURNING OR BORROWING 0 COPIES.
        System.out.println(theSilmarillion);

        System.out.println(robert);
        // REARANGE THE TOSTRING METHOD TO LOOK BETTER.

        System.out.println(library);
    }
}
