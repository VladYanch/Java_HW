import java.io.*;

public class Main {
    public static <ex, e> void main(String[] args) {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("file.txt"));
             BufferedReader fileReader = new BufferedReader(new FileReader("file.txt"))) {

            Runnable taskWrite = (() -> {
                String[] arr = {"Hello", "Java", "and", "World"};
                for (int i = 0; i < arr.length; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        fileWriter.write(arr[i]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
//            Runnable taskRead = (() -> {
//                for (int i = 0; i < 4; i++) {
//                    try {
//                        Thread.sleep(8000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    try {
//                        System.out.println(fileReader.readLine());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    });

                    Thread threadWrite = new Thread(taskWrite);
//                    Thread threadRead = new Thread(taskRead);

                    threadWrite.start();


            } catch (FileNotFoundException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Hello world!");
    }
}