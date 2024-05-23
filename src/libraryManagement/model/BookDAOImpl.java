package libraryManagement.model;

import connectDatabase.MySqlConnect;
import libraryManagement.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAOImpl implements BookDAO{
    public static Connection connection;
    public static Connection openConnection() throws SQLException{
        connection = MySqlConnect.getMySQLConnection();
        return connection;
    }
    public static PreparedStatement pstm;
    public static PreparedStatement openPrepareStatement(String query) throws SQLException{
        pstm = openConnection().prepareStatement(query);
        return pstm;
    }
    public static void exUpdate() throws SQLException{
        pstm.executeUpdate();
    }
    public static ResultSet exQuery()throws SQLException{
        ResultSet rs = pstm.executeQuery();
        return rs;
    }
    private final String CREATE_BOOK = "insert into book values(?,?,?)";
    private final String GET_ALL_BOOK = "SELECT * FROM book";
    public static final String GET_BOOK_BY_ID = "SELECT * FROM book where book_id = ?";
    private final String UPDATE_BOOK_BY_ID = "update book set book_title = ? , book_available = ? where book_id = ?";
    private final String DELETE_BOOK = "delete from book where book_id = ?";
    @Override
    public void createBook(Book book) throws SQLException {
        openPrepareStatement(CREATE_BOOK);
        pstm.setInt(1,book.getBook_id());
        pstm.setString(2,book.getBook_title());
        pstm.setBoolean(3,book.getBook_available());
        exUpdate();
    }

    @Override
    public ArrayList<Book> getAllBook() throws SQLException {
        ArrayList<Book> listBook = new ArrayList<>();
        openPrepareStatement(GET_ALL_BOOK);
        ResultSet rs = exQuery();
        while (rs.next()){
            Book book = new Book();
            book.setBook_id(rs.getInt(1));
            book.setBook_title(rs.getString(2));
            book.setBook_available(rs.getBoolean(3));
            listBook.add(book);
        }
        return listBook;
    }

    @Override
    public Book getBookById(int bookId) throws SQLException {
        Book book = new Book();
        PreparedStatement pstm = openPrepareStatement(GET_BOOK_BY_ID);
        pstm.setInt(1,bookId);

        ResultSet rs = exQuery();
        while (rs.next()){
            System.out.println("Book id: " + rs.getInt(1));
            System.out.println("Book title: " +rs.getString(2));
            System.out.println("Book available: " + rs.getBoolean(3));
        }
        return book;
    }

    @Override
    public void updateBook(Book book) throws SQLException {
        PreparedStatement pstm = openPrepareStatement(UPDATE_BOOK_BY_ID);
        pstm.setInt(3,book.getBook_id());
        pstm.setString(1,book.getBook_title());
        pstm.setBoolean(2,book.getBook_available());
        exUpdate();
    }

    @Override
    public boolean deleteBook(int bookId) throws SQLException {
        PreparedStatement pstm = openPrepareStatement(DELETE_BOOK);
        pstm.setInt(1,bookId);
        int check = pstm.executeUpdate();
        if (check>0){
            System.out.println("Delete success!");
            return true;

        }else {
            System.out.println("Delete Failure!");
            return false;
        }

    }

}
