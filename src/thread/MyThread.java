package thread;

public class MyThread extends Thread {

    private static String message;

    public MyThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println("Thread is running: " + message);
    }

    public void run2() {
        System.out.println("Second thread is running: " + message);
    }

    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Task 1");
        MyThread thread2 = new MyThread("Task 2");

        thread1.start(); // Bắt đầu thực thi Thread 1
        thread2.start();
        // Tạo một đối tượng mới từ lớp con của MyThread
        MyThread thread3 = new MyThread("Task 3") {
            @Override
            public void run() {
                System.out.println("Third thread is running: " + message);
            }
        };
        thread3.start(); // Bắt đầu thực thi Thread 3
    }
}