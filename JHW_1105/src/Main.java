import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MailDeliveryService mds = new DHL();
        Sender sender = new Sender();
        sender.sender(mds);
        mds.sendMail();
    }
}