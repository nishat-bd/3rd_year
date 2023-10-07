import java.util.ArrayList;

public class LibraryManagement {
    private ArrayList<String> books;
    private ArrayList<String> issuedBooks;

    public LibraryManagement() {
        books = new ArrayList<>();
        issuedBooks = new ArrayList<>();
    }

    public void addBook(String bookTitle) {
        books.add(bookTitle);
    }

    public void issueBook(String bookTitle) {
        if (books.contains(bookTitle)) {
            books.remove(bookTitle);
            issuedBooks.add(bookTitle);
            System.out.println(bookTitle + " has been issued.");
        } else {
            System.out.println("Sorry, " + bookTitle + " is not available in the library.");
        }
    }

    public void returnBook(String bookTitle) {
        if (issuedBooks.contains(bookTitle)) {
            issuedBooks.remove(bookTitle);
            books.add(bookTitle);
            System.out.println(bookTitle + " has been returned.");
        } else {
            System.out.println("Sorry, " + bookTitle + " is not currently issued.");
        }
    }

    public void displayAvailableBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Available books in the library:");
            for (String book : books) {
                System.out.println(book);
            }
        }
    }

    public void displayIssuedBooks() {
        if (issuedBooks.isEmpty()) {
            System.out.println("No books are currently issued.");
        } else {
            System.out.println("Books currently issued to library members:");
            for (String book : issuedBooks) {
                System.out.println(book);
            }
        }
    }

    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        library.addBook("Book 1");
        library.addBook("Book 2");
        library.addBook("Book 3");

        library.displayAvailableBooks();

        library.issueBook("Book 1");
        library.issueBook("Book 4");

        library.displayAvailableBooks();
        library.displayIssuedBooks();

        library.returnBook("Book 1");
        library.returnBook("Book 4");

        library.displayAvailableBooks();
        library.displayIssuedBooks();
    }
}
