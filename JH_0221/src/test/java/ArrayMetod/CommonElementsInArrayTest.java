package ArrayMetod;

import ArrayMetod.CommonElementsInArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

class CommonElementsInArrayTest {

    private static CommonElementsInArray checker;

    @BeforeAll
    public static void init () {
        checker = new CommonElementsInArray();
    }

    @org.junit.jupiter.api.Test
    void findCommonElementsInArrayTest() {
        int[] a = {1, 2, 5, 5, 8, 9, 7, 10};
        int[] b = {1, 0, 6, 15, 6, 4, 7, 0};
        int[] expected = {1,7};
        Assertions.assertArrayEquals(expected, checker.findCommonElementsInArray(a,b));

        a = new int[] {};
        b = new int[] {1, 0, 6, 15, 6, 4, 7, 0};
        expected = new int[] {};
        Assertions.assertArrayEquals(expected, checker.findCommonElementsInArray(a,b));

        a = null;
        b = new int[] {1, 0, 6, 15, 6, 4, 7, 0};
        expected = new int[] {};
        Assertions.assertArrayEquals(expected, checker.findCommonElementsInArray(a,b));

        a = null;
        b = null;
        expected = new int[] {};
        Assertions.assertArrayEquals(expected, checker.findCommonElementsInArray(a,b));
    }
}