import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("Book List:");
        System.out.printf("%-25s%-20s%-10s%n", "Title", "Author", "Year");
        for (Book book : books) {
            book.displayRow();
        }
    }

    public void searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found!");
                book.displayDetails();
                return;
            }
        }
        System.out.println("Book not found!");
    }
}
