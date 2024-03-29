package ArrayMetod;
import java.util.Arrays;

public class CommonElementsInArray {
    public static void main(String[] args) {
//        int[] arr1 = {1, 2, 5, 5, 8, 9, 7, 10};
//        int[] arr2 = {1, 0, 6, 15, 6, 4, 7, 0};
//        int[] arr1 = {1, 2, 1, 5, 8, 9, 7, 10};
        int[] arr2 = {7, 0, 6, 1, 6, 4, 6, 0};
        int[] arr1 = {};
//        int[] arr1 = null;

        System.out.println(Arrays.toString(findCommonElementsInArray(arr1, arr2)));
//        compareArr(arr1, arr2);
    }

    public static int[] findCommonElementsInArray(int[] arrA, int[] arrB) {
        if (arrA == null || arrB == null || arrA.length == 0 || arrB.length == 0) return new int[0];

        Arrays.sort(arrB);
        return Arrays.stream(arrA).distinct()
                .filter(x -> Arrays.binarySearch(arrB, x) > 0)
                .toArray();
    }
}
