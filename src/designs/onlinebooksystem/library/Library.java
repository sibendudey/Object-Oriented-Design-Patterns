package designs.onlinebooksystem.library;

import designs.onlinebooksystem.books.Book;
import designs.onlinebooksystem.reading.BookReading;
import designs.onlinebooksystem.users.User;

public interface Library {
    boolean addBook();
    Book searchBook(int id);
    boolean loginUser(User user);
    boolean logoffUser();
    User currentUser();
    BookReading readNewBook();
}
