import java.util.Random;
import java.util.concurrent.Phaser;

public class Brigade implements Runnable {
    String name;
    int resourses;

    Phaser phaser;

//    public Brigade(String name) {
    public Brigade(String name, Phaser phaser) {
        this.name = name;
        this.phaser = phaser;
    }

    public void run() {
        int rand = new Random().nextInt(1, 3);

        try {
            System.out.println("Brigade-"+name+" is building");
            Thread.sleep(1000*rand);
            System.out.println("Buildind :"+name+" is done and use " + rand + " resourses" );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resourses = rand;
//        phaser.arriveAndAwaitAdvance();

//        return res;
    }

}
