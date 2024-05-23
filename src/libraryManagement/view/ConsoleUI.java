package libraryManagement.view;

import libraryManagement.controller.Controller;
import libraryManagement.entity.Book;
import libraryManagement.entity.Librarian;
import libraryManagement.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI {
    public static Student student = new Student();
    public static Book book = new Book();
    public static Librarian librarian = new Librarian();
    public static Controller controller = new Controller();
    public static void menu(){
        System.out.println("Bạn cần thao tác gì:");
        System.out.println("1.Thao tác với Sách");
        System.out.println("2.Thao tác với sinh viên");
        System.out.println("3.Thao tác với danh sách sinh viên mượn sách");
    }
    public static void getAllBook() throws SQLException {
        ArrayList<Book> listBook = controller.getAllBook();
        listBook.forEach((book ->
                System.out.println("Book id: " + book.getBook_id()+"\nBook title: "+book.getBook_title()+"\nBook available: "+book.getBook_available()+"\n===========================")
                ));
    }
    public static void createBook() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new book id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the book title:");
        String title = scanner.nextLine();
        System.out.println("Is this book available (true / false )");
        Boolean available = scanner.nextBoolean();
        book.setBook_id(id);
        book.setBook_title(title);
        book.setBook_available(available);
        controller.createBookController(book);
    }
    public static void updateBook() throws SQLException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the book id update:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the new book title:");
        String title =scanner.nextLine();
        System.out.println("Is this book available ? (true/false)");
        Boolean available = scanner.nextBoolean();
        book.setBook_id(id);
        book.setBook_available(available);
        book.setBook_title(title);
        controller.updateBook(book);
    }
    public static void deleteBook() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the book id delete:");
        int id = scanner.nextInt();
        controller.deleteBook(id);
    }
    public static void searchBook() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the book id search:");
        int id = scanner.nextInt();
        controller.getBookByIdController(id);
    }
    public static void menuBook() throws SQLException {
        System.out.println("1.Get all");
        System.out.println("2.Create book");
        System.out.println("3.Update book");
        System.out.println("4.Delete book");
        System.out.println("5.Search book");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("Get all book:");
                getAllBook();
                break;
            case 2:
                System.out.println("Create book:");
                createBook();
                break;
            case 3:
                System.out.println("Update book");
                updateBook();
                break;
            case 4:
                System.out.println("Delete book:");
                deleteBook();
                break;
            case 5:
                System.out.println("Search book:");
                searchBook();
                break;
            case 0:
                System.out.println("Back");
                start();
                break;
            default:
                System.out.println("Khong co lua chon nay");
        }
    }
    public static void getAllStudent() throws SQLException {
        ArrayList<Student> listStudent = controller.getAllStudent();
        listStudent.forEach((student ->
                System.out.println("Student id: " + student.getStudent_id()+"\nStudent name: "+student.getStudent_name()+"\nClass: "+student.getStudent_class()+"\n===========================")
        ));
    }
    public static void createStudent() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new student id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the student name:");
        String name = scanner.nextLine();
        System.out.println("Enter the class of student:");
        String clas = scanner.nextLine();
        student.setStudent_id(id);
        student.setStudent_name(name);
        student.setStudent_class(clas);
        controller.createStudentController(student);
    }
    public static void updateStudent() throws SQLException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the student id update:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the new student name:");
        String name =scanner.nextLine();
        System.out.println("Enter the class of student");
        String clas = scanner.nextLine();
        student.setStudent_id(id);
        student.setStudent_name(name);
        student.setStudent_class(clas);
        controller.updateStudent(student);
    }
    public static void deleteStudent() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the student id delete:");
        int id = scanner.nextInt();
        controller.deleteStudent(id);
    }
    public static void searchStudent() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the student id search:");
        int id = scanner.nextInt();
        controller.getStudentByIdController(id);
    }
    public static void menuStudent() throws SQLException {
        System.out.println("1.Get all student");
        System.out.println("2.Create student");
        System.out.println("3.Update student");
        System.out.println("4.Delete student");
        System.out.println("5.Search student");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("Get all student:");
                getAllStudent();
                break;
            case 2:
                System.out.println("Create student:");
                createStudent();
                break;
            case 3:
                System.out.println("Update student");
                updateStudent();
                break;
            case 4:
                System.out.println("Delete student:");
                deleteStudent();
                break;
            case 5:
                System.out.println("Search student:");
                searchStudent();
                break;
            case 0:
                System.out.println("Back");
                start();
                break;
            default:
                System.out.println("Khong co lua chon nay");
        }
    }
    public static void getAllList() throws SQLException {
        ArrayList<Librarian> list = controller.getAllList();
        list.forEach((librarian ->
                System.out.println("Student id: " + librarian.getStudent_id()+"\nBook id:: "+librarian.getBook_id()+ "\nBook Name:"+librarian.getBook_name()+"\nStudent name:" + librarian.getStudent_name()+"\n===========================")
        ));
    }
    public static void createList() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the book id search:");
        int book_id = scanner.nextInt();
        scanner.nextLine();
        Book book = controller.getBookByIdController(book_id);

        if (book != null) {
            System.out.println("Enter the student id search:");
            int student_id = scanner.nextInt();
            scanner.nextLine();
            Student student = controller.getStudentByIdController(student_id);
            librarian.setBook_id(book_id);
            librarian.setStudent_id(student_id);
            if (student != null) {
                // Tiến hành cho sinh viên mượn sách
                controller.createListController(librarian);
                System.out.println("Cho sinh vien muon sach thanh cong!");
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }
    public static void getListById() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the list id search:");
        int id = scanner.nextInt();
        controller.getListByIdController(id);
    }
    public static void deleteList() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the student id delete:");
        int id = scanner.nextInt();
        controller.deleteList(id);
    }
    public static void updateList() throws SQLException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the student id update:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the new book id:");
        int book_id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the new student id:");
        int student_id = scanner.nextInt();
        librarian.setId(id);
        librarian.setBook_id(book_id);
        librarian.setStudent_id(student_id);
        controller.updateList(librarian);
    }
    public static void menuManager() throws SQLException {
        System.out.println("1.List of students borrowing books");
        System.out.println("2.Create students to borrow books");
        System.out.println("3.Search list");
        System.out.println("4.Students return books");
        System.out.println("5.Update students to borrow book");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("Get all list:");
                getAllList();
                break;
            case 2:
                System.out.println("Create list:");
                createList();
                break;
            case 3:
                System.out.println("Search list");
                getListById();
                break;
            case 4:
                System.out.println("Delete list:");
                deleteList();
                break;
            case 5:
                System.out.println("Update list:");
                updateList();
                break;
            case 0:
                System.out.println("Back");
                start();
                break;
            default:
                System.out.println("Khong co lua chon nay");
        }
    }
    public static void start() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit){
            menu();
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Book table:");
                    menuBook();
                    break;
                case 2:
                    System.out.println("Student table:");
                    menuStudent();
                    break;
                case 3:
                    System.out.println("Manage student loan books");
                    menuManager();
                case 0:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Khong co lua chon nay");
                    break;
            }
        }

    }
}
