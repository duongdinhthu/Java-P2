package libraryManagement.entity;

public class Book {
    private int book_id;
    private String book_title;
    private Boolean book_available;

    public Book() {
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public Boolean getBook_available() {
        return book_available;
    }

    public void setBook_available(Boolean book_available) {
        this.book_available = book_available;
    }
}
