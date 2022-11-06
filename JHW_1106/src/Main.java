import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CreateArray arr = null;

        System.out.println("Выбери способ ввода массива: 1.DHL 2.Email 3.Pigeon ");
        Scanner console = new Scanner(System.in);
        int choice = console.nextInt();

        switch (choice) {
            case (1): mds = new DHL(); break;
            case (2): mds = new Email(); break;
            case (3): mds = new Pigeon(); break;
             default: mds = new DHL();
        }

        arr.createArray();
    }
}