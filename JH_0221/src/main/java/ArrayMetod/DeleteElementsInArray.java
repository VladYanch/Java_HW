package ArrayMetod;

import java.util.Arrays;

public class DeleteElementsInArray {
    public static void main(String[] args) {
        int[] arr = {0,3,-2,4,3,2};
//        int[] arr = null;
        System.out.println(Arrays.toString(deleteSameElementsInArray(arr)));
    }


    public static int[] deleteSameElementsInArray(int[] arr) {
        if (arr == null) return new int[0];
        return Arrays.stream(arr).distinct()
                .toArray();
    }
}
//        2. Напишите программу на Java и тест для нее для удаления повторяющихся элементов из массива.
//        example input:
//        [0,3,-2,4,3,2]
//        example expected:
//        [0,3,-2,4,2]