import org.junit.Assert;
import org.junit.Test;
import week2.SolutionsWeek2;

public class TestSolutionsWeek2 {

    @Test public void testSumForConsecutiveElements() {
        int[] input = {1, 2, 5, 4, 4, 6, 2, 7, 1};
        int result = SolutionsWeek2.maxSumForConsecutiveElements(input, 3);
        Assert.assertEquals(15, result);
    }

    @Test public void testMaximums() {
        int[] input = {1, 2, 5, 4, 4, 6, 2, 7, 1};
        int[] result = SolutionsWeek2.maximumFromConsecutiveKElements(input, 3);
        int[] expectedResult = {5, 5, 5, 6, 6, 7, 7};
        Assert.assertArrayEquals(expectedResult, result);
    }

    @Test public void testSortInK() {
        int[] input = {1, 2, 5, 4, 4, 6, 2, 7, 1};
        int[] result = SolutionsWeek2.sortInNk(input, 7);
        int[] expectedResult = {1, 1, 2, 2, 4, 4, 5, 6, 7};
        Assert.assertArrayEquals(expectedResult, result);
    }

    @Test public void testExecuteReversePolishNotation() {
        double result =
            SolutionsWeek2.executeReversePolishNotation("15 7 1 1 + - / 3 * 2 1 1 + + -");
        Assert.assertEquals(5.0, result, 0.00001);
    }

    @Test public void testSumSubRectangle() {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        int[][] queries = new int[3][4];
        queries[0][0] = 0;
        queries[0][1] = 0;
        queries[0][2] = 2;
        queries[0][3] = 3;
        int result0 = 78;

        queries[1][0] = 0;
        queries[1][1] = 0;
        queries[1][2] = 2;
        queries[1][3] = 2;
        int result1 = 45;


        queries[2][0] = 1;
        queries[2][1] = 1;
        queries[2][2] = 2;
        queries[2][3] = 3;
        int result2 = 51;


        int[] results = SolutionsWeek2.sumSubRectangles(array, queries);

        Assert.assertEquals(result0, results[0]);
        Assert.assertEquals(result1, results[1]);
        Assert.assertEquals(result2, results[2]);
    }

    /**
     * Works only for first 3 elements.
     */
    @Test public void findPairsMinDifference() {
        int[] array1 = {1, 2, 3, 4, 5, 6};
        int[] array2 = {10, 9, 8, 5, 235, 234, 1, 2, 3};
        int[] minDifferences = SolutionsWeek2.findPairsMinDifference(array1, array2);
        int[] expectedResult = {4, 3, 2, 0, 229, 228, 0, 0, 0};
        Assert.assertArrayEquals(expectedResult, minDifferences);
    }
}
