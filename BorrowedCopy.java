import java.util.Objects;

public class BorrowedCopy {
    private Book book;
    private BookCopy bookCopy;

    public BorrowedCopy(Book book, BookCopy bookCopy) {
        this.book = book;
        this.bookCopy = bookCopy;
    }

    public Book getBook() {
        return book;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        BorrowedCopy that = (BorrowedCopy) o;
        return book.equals(that.book) && bookCopy.equals(that.bookCopy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, bookCopy);
    }
}
