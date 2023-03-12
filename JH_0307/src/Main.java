import java.util.ArrayList;
import java.util.List;

//todo вывести на экран по нормальному
public class Main {
    private static List<List<Integer>> paskal(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }

        List<Integer> firstRaw = new ArrayList<>();
        firstRaw.add(1);
        triangle.add(firstRaw);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRaw = triangle.get(i - 1);
            List<Integer> raw = new ArrayList<>();

            raw.add(1);

            for (int j = 1; j < i; j++) {
                raw.add(prevRaw.get(j - 1) + prevRaw.get(j));
            }

            raw.add(1);
            triangle.add(raw);
        }
        return triangle;
    }

    public static void main(String[] args) {
//        System.out.println(paskal(5));
        int number = 10;
        int[] length = new int[1];
        length[0] = number;
        paskal(number).stream().
            forEach(x-> System.out.println(" ".repeat(length[0]-x.size()+(length[0]- x.size())/2)+ x));
    }
}
