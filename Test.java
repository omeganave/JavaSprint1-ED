import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Author author = new Author("Name", new Date());
        Book book = new Book("Title", author, "123456789", "Publisher", 1,
                Status.AVAILABLE);

        System.out.println(book);

        book.setStatus(Status.CHECKED_OUT);

        System.out.println(book);
    }
}
