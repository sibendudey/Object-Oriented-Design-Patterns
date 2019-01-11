package designs.onlinebooksystem.reading;

import designs.onlinebooksystem.books.Book;
import designs.onlinebooksystem.users.User;

public interface BookReading {
    User readingUser();
    Book readingBook();
    int currentPage();
    boolean incrementPage();
    boolean decrementPage();
}
