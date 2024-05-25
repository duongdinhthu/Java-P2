package baithi;

import baithi.view.ReadJson;
import baithi.view.View;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws SQLException, IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ParseException {
        View view = new View();
        ReadJson readJson = new ReadJson();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select choice:");
        System.out.println("1. Get All Student and writer to JSON");
        System.out.println("2. Read File Json");
        System.out.println("3. Read File Json search name");
        System.out.println("4. Read File Json search email");
        System.out.println("0. Exit");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                view.getAll();
                break;
            case 2:
                readJson.readJson();
                break;
            case 3:
                readJson.searchName();
                break;
            case 4:
                readJson.searchEmail();
            case 0:
                System.exit(0);
                break;
        }
    }
}
