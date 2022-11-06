import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MailDeliveryService mds;

//        System.out.println("Выбери способ отправки: 1.DHL 2.Email 3.Pigeon ");
//        Scanner console = new Scanner(System.in);
//        int choice = console.nextInt();

//        switch (choice) {
//            1: mds = new DHL(); break;
//            2: mds = new Email(); break;
//            3: mds = new Pigeon(); break;
//            default -> new DHL(); break;
//        }
//
        mds = new DHL();
        mds.sendMail();

        System.out.println("********************");

        mds = new Email();
        mds.sendMail();

        System.out.println("********************");

        mds = new Pigeon();
        mds.sendMail();

    }
}