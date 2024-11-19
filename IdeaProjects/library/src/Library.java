import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    // Kitab əlavə etmək
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    // Kitab siyahısını göstərmək
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Kitabı icarəyə vermək
    public void borrowBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                if (!book.isBorrowed()) {
                    book.setBorrowed(true);
                    System.out.println("Book borrowed: " + book.getTitle());
                } else {
                    System.out.println("Book is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // İcarəyə verilmiş kitabları göstərmək
    public void listBorrowedBooks() {
        boolean hasBorrowed = false;
        for (Book book : books) {
            if (book.isBorrowed()) {
                System.out.println(book);
                hasBorrowed = true;
            }
        }
        if (!hasBorrowed) {
            System.out.println("No books are currently borrowed.");
        }
    }
}
