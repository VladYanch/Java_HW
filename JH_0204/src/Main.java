import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //    Создайте файл, используя FileOutputStream,
        //    с текстом: "This is my first experience when I myself work with IO API. I can do everything!"

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("file1.txt");
            String str = "This is my first experience when I myself work with IO API. I can do everything!.";

            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}