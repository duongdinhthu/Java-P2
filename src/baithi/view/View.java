package baithi.view;

import baithi.controller.Controller;
import baithi.entity.Student;

import baithi.model.Model;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class View {
    Model<Student> studentModel = new Model<Student>();
    Controller<Student> studentController = new Controller<>(studentModel);

    public void getAll() throws SQLException, IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Get All Student:");
        System.out.println("===========");

        List<Student> list= studentController.list(student);
        for (Student l : list){
            System.out.println(l.toString());
        }
    }
}
