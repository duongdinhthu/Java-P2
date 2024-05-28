package baithi.view;

import baithi.controller.Controller;
import baithi.entity.Student;

import baithi.model.Model;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;


public class View {
    Model<Student> studentModel = new Model<Student>();
    Controller<Student> studentController = new Controller<>(studentModel);

    public void getAll() throws SQLException, IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Student student = new Student();

        System.out.println("Get All Student:");
        System.out.println("===========");

        List<Student> list= studentController.list(student);
        for (Student l : list){
            System.out.println(l.toString());
        }
    }
}
