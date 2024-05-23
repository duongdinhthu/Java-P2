package session12.relearn;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Application {
    public static void main(String[] args) {
        GenerateType<String,Student,Customer> list = new GenerateType<>();
        Map<String,GenerateType> map = new HashMap<>();
        Student student = new Student();
        Customer customer = new Customer();
        System.out.println(list);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the key:");
        String key = scanner.nextLine();
        System.out.println("Enter the student id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the student name : ");
        String name = scanner.nextLine();
        System.out.println("Enter the student email: ");
        String email = scanner.nextLine();
        System.out.println("Enter the student address:");
        String address = scanner.nextLine();
        System.out.println("Enter the customer id:");
        int cId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the customer first name: ");
        String fName = scanner.nextLine();
        System.out.println("Enter the customer last name: ");
        String lName = scanner.nextLine();
        list.setKey(key);
        list.setValue(new Student(id,name,email,address));
        list.setValue1(new Customer(cId,fName,lName));
        map.put(key,list);
        System.out.println(map);
        System.out.println(map.get(key));
    }
}
