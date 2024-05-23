package libraryManagement.model;

import libraryManagement.entity.Book;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BookDAO {
    public void createBook(Book book) throws SQLException;
    public ArrayList<Book> getAllBook() throws SQLException;
    public Book getBookById(int bookId) throws SQLException;
    public void updateBook(Book book) throws SQLException;
    public boolean deleteBook(int bookId) throws SQLException;
}
