import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static int sec = 0;
    public static void main(String[] args) {

        AtomicInteger count1 = new AtomicInteger();
        AtomicInteger count2 = new AtomicInteger();
        AtomicInteger count3 = new AtomicInteger();
        AtomicInteger count4 = new AtomicInteger();
        int number = 5;
        long start = System.currentTimeMillis();

        Thread daemon = new Thread(() -> {
            while (true) {
//            int sec = 0;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Daemon work: " + ++sec*5 + " sec");}
        });

        daemon.setDaemon(true);
        daemon.start(); //TODO: Daemon start at start and say every 5 sec :)

        System.out.println("Последовательный процесс");
        System.out.println("Total divisible by " + number + ": " + counter(number,Integer.MIN_VALUE,Integer.MAX_VALUE) + " time: " +
                (System.currentTimeMillis() - start) ); //TODO: Total divisible by 5: 858993459 time: 16323
        System.out.println("-".repeat(50));

        Runnable task1 = () -> {count1.set(counter(number, Integer.MIN_VALUE, 0));
            System.out.println("task1");
            System.out.println(count1.get()); };
        Runnable task2 = () -> {count2.set(counter(number,0, Integer.MAX_VALUE));
            System.out.println("task2");
            System.out.println(count2.get()); };



        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        start = System.currentTimeMillis();
        System.out.println("2 процесса");

        thread1.start();
        thread2.start();

        try {
        thread1.join();
        thread2.join();
        } catch (InterruptedException e) {
        e.printStackTrace();
        }

//        System.out.println("Total divisible by " + number + ": " + counter(number,Integer.MIN_VALUE,Integer.MAX_VALUE) + " time: " +
                System.out.println("Time " + (System.currentTimeMillis() - start) + " Amount: " +
                (long) (count1.get()+count1.get())); //TODO: Time 8466 Amount: 858993458
        System.out.println("-".repeat(50));

        System.out.println("4 процесса");

        Runnable task3 = () -> {count1.set(counter(number, Integer.MIN_VALUE, (int) (Integer.MIN_VALUE * 0.2)));
            System.out.println("task1");
            System.out.println(count1.get()); };
        Runnable task4 = () -> {count2.set(counter(number, (int) (Integer.MIN_VALUE*0.2), 0));
            System.out.println("task2");
            System.out.println(count2.get()); };
        Runnable task5 = () -> {count3.set(counter(number, 0, Integer.MAX_VALUE/3));
            System.out.println("task3");
            System.out.println(count3.get()); };
        Runnable task6 = () -> {count4.set(counter(number,Integer.MAX_VALUE/3, Integer.MAX_VALUE));
            System.out.println("task4");
            System.out.println(count4.get()); };

        Thread thread3 = new Thread(task3);
        Thread thread4 = new Thread(task4);
        Thread thread5 = new Thread(task5);
        Thread thread6 = new Thread(task6);

        start = System.currentTimeMillis();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();

        try {
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        System.out.println("Total divisible by " + number + ": " + counter(number,Integer.MIN_VALUE,Integer.MAX_VALUE) + " time: " +
        System.out.println("Time " + (System.currentTimeMillis() - start) + " Amount: " +
                    (long) (count1.get()+count2.get()+count3.get()+count4.get())); //TODO: Time 8986 Amount: 858993459

        System.out.println("Daemon work total: " + ++sec*5 + " sec");
        //TODO ВЫВОД: т.к у меня компьютер 2 ядерный то дальнейшее увеличение потоков более чем 2 неэффективно
    }

    public static int counter(int number,int startRange, int endRange) {
        int count = 0;

        for (int i=startRange; i < endRange; i++) {
            if (i % number == 0)
                count++;
        }
        return count;
    }

}

//    Взять пример расчетной задачи (см. слайды к занятию) - задача 1:
//    посчитать количество целых чисел в диапазоне от Integer.MIN_VALUE до Integer.MAX_VALUE,
//    которые делятся на заданное целое число без остатка.
//    Решить данную задачу последовательно и параллельно в нескольких потоках. Сравнить время выполнения.



