import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MailDeliveryService mds;
    //    mds = new DHL(); // defa

        System.out.println("Выбери способ отправки: 1.DHL 2.Email 3.Pigeon ");
        Scanner console = new Scanner(System.in);
        int choice = console.nextInt();

        switch (choice) {
            case (1): mds = new DHL(); break;
            case (2): mds = new Email(); break;
            case (3): mds = new Pigeon(); break;
             default: mds = new DHL();
        }

//        mds = new DHL();
//        mds.sendMail();
//
//        System.out.println("********************");
//
//        mds = new Email();
//        mds.sendMail();
//
//        System.out.println("********************");
//
//        mds = new Pigeon();
        mds.sendMail();

    }
}