package ArrayMetod;

import ArrayMetod.DeleteElementsInArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DeleteElementsInArrayTest {

    private static DeleteElementsInArray checker;

    @BeforeAll
    public static void init () {
        checker = new DeleteElementsInArray();
    }

    @Test
    void deleteSameElementsInArrayTest() {
        int[] arr = {0,3,-2,4,3,2};
        int[] expected = {0,3,-2,4,2};
        Assertions.assertArrayEquals(expected, checker.deleteSameElementsInArray(arr));

        arr = new int[]{};
        expected = new int[] {};
        Assertions.assertArrayEquals(expected, checker.deleteSameElementsInArray(arr));

        arr = null;
        expected = new int[] {};
        Assertions.assertArrayEquals(expected, checker.deleteSameElementsInArray(arr));
    }
}