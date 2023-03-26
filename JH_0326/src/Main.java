import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        int settlement = 3;
        AtomicInteger resourses = new AtomicInteger();
        int houses = 10;
        ExecutorService executor;
        executor = Executors.newFixedThreadPool(4);
        Brigade brigade;
        List<Brigade> listBrigade = new ArrayList<>();
        Phaser phaser = new Phaser(4);
        Future future = null;
//        Brigade brigade = new Brigade();
//        while (houses > 0) {

            for (int i = 1; i <= 4; i++) {
    //            listBrigade.add(new Brigade("Brigade-"+i, new Phaser()));
                listBrigade.add(new Brigade("Brigade-" + i, phaser));
                executor.submit(listBrigade.get(i - 1));
    //            future = executor.submit(listBrigade.get(i));
            }
//        }
//        resourses = (int) (resourses + future.get());

//        System.out.println(phaser.getArrivedParties());
//        phaser.arriveAndDeregister();
//        System.out.println(phaser.getArrivedParties());
//        listBrigade.stream().forEach(x-> resourses.addAndGet(x.resourses));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        listBrigade.stream().forEach(x-> resourses.set(resourses.get() + x.resourses));
        System.out.println("-".repeat(50));
        listBrigade.stream().forEach(x-> System.out.println(x.name));
        System.out.println("-".repeat(50));
        System.out.println("Total used resourses: " + resourses);
        executor.shutdown();
    }
}