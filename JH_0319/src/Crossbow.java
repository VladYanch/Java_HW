import java.util.Scanner;

public class Crossbow {

    private static int arrows = 0;

    // When the arrows end, the wait() method is called and releases.
    synchronized public void fire() {
        while (true) {
            for (int idx = arrows; idx >= 0; idx--) {

                if (idx != 0) {
                    System.out.println("The arrow is " + (arrows - idx + 1) + " right on the target!");
                } else {
                    System.out.println("The arrows are over");
                    arrows = 0;
                    System.out.println("Count arrows " + arrows);
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Carry a new quiver with arrows!!");
                    notify();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // reload() brings new arrows, calls the notify() method, which awakens the thread
    synchronized public void reload() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter how many arrows you need for relunch: ");
            arrows = scanner.nextInt();
            while (arrows<=0) {
                System.out.println("Number arrows is wrong, enter correct number");
                System.out.println("Enter how many arrows you need for relunch: ");
                arrows = scanner.nextInt();
            }
            System.out.println("New arrows on the way!");
            //arrows = 5;
            System.out.println("Count arrows = " + arrows);
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {

        Crossbow crossbow = new Crossbow();

        Thread robinHood = new Thread(crossbow::fire);
        Thread servant = new Thread(crossbow::reload);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter how many arrows you need to start: ");
        arrows = scanner.nextInt();
        while (arrows<=0) {
            System.out.println("Number arrows is wrong, enter correct number");
            System.out.println("Enter how many arrows you need for lunch: ");
            arrows = scanner.nextInt();
        }

        robinHood.start();
        servant.start();
    }
}