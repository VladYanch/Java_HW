import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;

public class Main {
    public static void main(String[] args) {
//        Напишите программу которая принимает на вход текстовый файл содержащий числа. Для каждой строки:
//        1. отсортировать числа в порядке убывания. 
//        2. Записать отсортированные числа в файл: исходное_имя_файла_sorted.txt
//        3. Подсчитать сумму четных чисел для каждой строки. 
//        4. Подсчитать среднее значение для нечетных чисел каждой строки. 
//        5. Найти минимальное и максимальное значение для каждой строки.
//        Записать результаты в файл в формате:
//        Line: #  ; SEven: ; AOdd: ; Max: ; Min:


/* 6. Если файл содержит недопустимые данные выдать в результирующий файл
Line #, error message */

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("seq1.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("seq1_sorted.txt"));
             BufferedWriter resultWriter = new BufferedWriter(new FileWriter("result.txt"))) {

            try {
                List<String> list = bufferedReader.lines().toList();
                for (int i = 0; i < list.size(); i++) {

                    List<Integer> listInt = Arrays.stream(list.get(i).split(" ")).filter(x -> !x.equals(""))
                            .map(Integer::parseInt).sorted((x, y) -> y - x).toList();

                    bufferedWriter.write(toString(listInt));
                    bufferedWriter.write("\n");


                    int sEven = listInt.stream().filter(x -> x % 2 == 0).reduce(Integer::sum).get();
                    System.out.println(sEven);

                    double aOdd = (double) listInt.stream().filter(x -> x % 2 != 0).reduce(Integer::sum).get() /
                            listInt.stream().filter(x -> x % 2 != 0).count();
                    System.out.println(aOdd);

                    int max = listInt.get(0);
                    System.out.println(max);
                    int min = listInt.get(listInt.size() - 1);
                    System.out.println(min);

                    resultWriter.write(
                            String.format("# %d; SEven: %d; aOdd: %4.2f; Max: %d; Min: %d \n", (i + 1), sEven, aOdd, max, min));
                }
            } catch (NumberFormatException e) {
                System.out.println("Line " + "#" + " error message " + e.getMessage());
                return;
                // 4 строка аа вместо 69
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String toString(List<Integer> list) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            str.append(list.get(i) + "; ");
        }
        return str.toString();
    }

}
//            try {
//                List<Integer> listInt = Arrays.stream(list.get(i).split(" "))
//                        .mapToInt(Integer::parseInt).boxed().sorted((x, y) -> y - x).toList();
//            } catch (NumberFormatException e) {
//                System.out.println("Line " + "#" + i + " error message "+e.getMessage());
//                return;
//                // 4 строка аа вместо 69
//            }
