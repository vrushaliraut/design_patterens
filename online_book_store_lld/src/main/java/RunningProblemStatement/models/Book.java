package RunningProblemStatement.models;

public class Book {
    private int bookId;
    private String details;
    private String title;

    public Book(int bookId, String details, String title) {
        this.bookId = bookId;
        this.details = details;
        this.title = title;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
