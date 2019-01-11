package designs.onlinebooksystem.books;

public class BookImpl implements Book {

    private static int counter = 0;
    private int id;
    private int totalPages;
    private String name;

    @Override
    public int id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int totalPages() {
        return totalPages;
    }

    public BookImpl(String name, int totalPages)    {
        this.name = name;
        this.totalPages = totalPages;
        this.id = ++counter;
    }
}
