package session20.view;

import session20.controller.Controller;
import session20.entity.AddressBooks;
import session20.model.Model;

import java.util.List;
import java.util.Scanner;

public class View {
    static Model<AddressBooks> model = new Model<>();
    static Controller<AddressBooks> controller = new Controller<>(model);

    public static void addNewContact(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new name:");
        String name = scanner.nextLine();
        System.out.println("Enter the company:");
        String company = scanner.nextLine();
        System.out.println("Enter the email:");
        String email = scanner.nextLine();
        System.out.println("Enter the phone number:");
        int phone = scanner.nextInt();
        AddressBooks addressBooks = new AddressBooks(1, name, company, email, phone);
        controller.addEntity(addressBooks);
    }

    public static void getAll(){
        List<AddressBooks> list = controller.getAllEntities();
        for (AddressBooks l : list){
            System.out.println(l.toString());
        }
    }

    public static void getContactById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the phone search:");
        int phone = scanner.nextInt();

        AddressBooks foundAddressBook = controller.getEntityByPhone(phone);

        if(foundAddressBook != null){
            System.out.println(foundAddressBook.toString());
        } else {
            System.out.println("Address book not found for phone: " + phone);
        }
    } public static void menu(){
        System.out.println("1. Add new contact");
        System.out.println("2. Get all");
        System.out.println("3. Get contact by id");
        System.out.println("0. Exit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (true){

            switch (choice){
                case 1:
                    addNewContact();
                    menu();
                    break;
                case 2:
                    getAll();
                    menu();
                    break;
                case 3:
                    getContactById();
                    menu();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Khong co lua chon nay");
            }
        }
    }
}