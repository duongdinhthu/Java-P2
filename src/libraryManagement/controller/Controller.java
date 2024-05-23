package libraryManagement.controller;
import libraryManagement.entity.Book;
import libraryManagement.entity.Librarian;
import libraryManagement.entity.Student;
import libraryManagement.model.BookDAOImpl;
import libraryManagement.model.LibraryDAO;
import libraryManagement.model.LybraryDaoImpl;
import libraryManagement.model.StudentDAOImpl;
import java.sql.SQLException;
import java.util.ArrayList;
public class Controller {
    LibraryDAO lybraryDao = new LybraryDaoImpl();
    BookDAOImpl bookDAO = new BookDAOImpl();
    StudentDAOImpl studentDAO = new StudentDAOImpl();
    public void createBookController(Book book) throws SQLException {
        bookDAO.createBook(book);
    }
    public Book getBookByIdController(int bookId) throws SQLException{
        return  bookDAO.getBookById(bookId);
    }
    public ArrayList<Book> getAllBook() throws SQLException {
        return bookDAO.getAllBook();
    }
    public boolean deleteBook(int bookId) throws SQLException {
        return bookDAO.deleteBook(bookId);
    }
    public void updateBook(Book book) throws SQLException {
        bookDAO.updateBook(book);
    }

    public void createStudentController(Student student) throws SQLException {
        studentDAO.createStudent(student);
    }
    public Student getStudentByIdController(int studentId) throws SQLException{
        return  studentDAO.getStudentById(studentId);
    }
    public ArrayList<Student> getAllStudent() throws SQLException {
        return studentDAO.getAllStudent();
    }
    public boolean deleteStudent(int studentId) throws SQLException {
        return studentDAO.deleteStudent(studentId);
    }
    public void updateStudent(Student student) throws SQLException {
        studentDAO.updateStudent(student);
    }
    public void createListController(Librarian librarian) throws SQLException {
        lybraryDao.createLibrarian(librarian);
    }
    public Librarian getListByIdController(int id) throws SQLException{
        return  lybraryDao.getLibrarianById(id);
    }
    public ArrayList<Librarian> getAllList() throws SQLException {
        return lybraryDao.getAllLibrarian();
    }
    public boolean deleteList(int liId) throws SQLException {
        return lybraryDao.deleteLibrarian(liId);
    }
    public void updateList(Librarian librarian) throws SQLException {
        lybraryDao.updateLibrarian(librarian);
    }
}
