package week2;

import java.util.*;

public class SolutionsWeek2 {

    /**
     * 2)
     *
     * @param a
     * @param queries
     * @return
     */
    public static int[] sumSubRectangles(int[][] a, int[][] queries) {
        int amountQueries = queries.length;

        int[] output = new int[amountQueries];

        // O(n)
        for (int i = 0; i < amountQueries; i++) {
            int startX = queries[i][0];
            int startY = queries[i][1];
            int endX = queries[i][2];
            int endY = queries[i][3];

            int sum = 0;
            for (int y = startY; y < endY + 1; y++) {
                for (int x = startX; x < endX + 1; x++) {
                    int currentElement = a[y][x];
                    sum += currentElement;
                }
            }
            output[i] = sum;
        }
        return output;
    }

    /**
     * 3)
     * O(n * k) => O(n)
     */
    public static int[] maximumFromConsecutiveKElements(int[] a, int k) {
        int length = a.length;
        int outputLength = length - k + 1;
        int[] maximums = new int[outputLength];

        // O(n)
        for (int i = 0; i < outputLength; i++) {
            int currentMax = Integer.MIN_VALUE;
            // O(k)
            for (int j = 0; j < k; j++) {
                int currentValue = a[i + j];
                if (currentValue > currentMax) {
                    currentMax = currentValue;
                }
            }
            maximums[i] = currentMax;
        }

        return maximums;
    }

    /**
     * 4)
     *
     * @param array1
     * @param array2
     * @return
     */
    public static int[] findPairsMinDifference(int[] array1, int[] array2) {
        int length = array2.length;
        int[] output = new int[length];

        for (int i = 0; i < length; i++) {
            output[i] = binarySearchSmallestDifference(array1, 0, array1.length, array2[i],
                Integer.MAX_VALUE, 1);

        }
        return output;
    }


    /**
     * 4)
     *
     * @param array
     * @param left
     * @param right
     * @param searched
     * @return
     */
    public static int binarySearchSmallestDifference(int[] array, int left, int right, int searched,
        int minDifference, int previousWasRight) {
        int rightDirectionWasChosen = 0;

        if (right > left) {
            int mid = (left + right) / 2;

            int midValue = array[mid];
            int currentDifference = Math.abs(midValue - searched);
            if (currentDifference == 0) {
                return midValue;
            } else if (currentDifference < minDifference) {
                minDifference = currentDifference;
                rightDirectionWasChosen = 1;
            } else if (previousWasRight != 0) {
                rightDirectionWasChosen = -1;
            }

            if ((rightDirectionWasChosen == 1 && previousWasRight == 1) || (
                rightDirectionWasChosen == -1 & previousWasRight == -1)) {
                return binarySearchSmallestDifference(array, mid, right, searched, minDifference, 1);
            } else {
                return binarySearchSmallestDifference(array, left, mid, searched, minDifference, -1);
            }
        } else {
            return minDifference;
        }
    }



    /**
     * 5)
     * O(n) + O(n) + O(n) => O(3n) => O(n)
     *
     * @param input
     * @param k
     * @return
     */
    public static int[] sortInNk(int[] input, int k) {
        int length = input.length;
        int[] map = new int[k];
        int[] output = new int[length];

        // get min O(n)
        // this block can be replaced with
        // min = input[0];
        // it will reduce time complexity but
        //  than the size of the map would have to be increased
        int min = Integer.MAX_VALUE;
        for (int currentValue : input) {
            if (currentValue < min) {
                min = currentValue;
            }
        }

        // create map O(n)
        for (int currentValue : input) {
            map[currentValue - min]++;
        }

        // map to output O(n)
        int mapIter = 0;
        for (int i = 0; i < length; i++) {
            while (map[mapIter] == 0) {
                mapIter++;
                if (mapIter == length) {
                    break;
                }
            }
            // FIXME can this block be done better?
            while (map[mapIter] > 0) {
                output[i] = min + mapIter;
                map[mapIter]--;
                if (map[mapIter] > 0) {
                    i++;
                }
            }
        }

        return output;
    }

    /**
     * 7)
     *
     * @param input
     * @return
     */
    public static double executeReversePolishNotation(String input) {
        String[] tokens = input.split(" ");
        final char plus = '+';
        final char minus = '-';
        final char multiply = '*';
        final char divide = '/';
        HashSet<Character> operations = new HashSet<>();
        operations.add(plus);
        operations.add(minus);
        operations.add(multiply);
        operations.add(divide);
        Stack<Double> stack = new Stack<>();

        for (String stringToken : tokens) {
            char charToken = stringToken.charAt(0);
            if (operations.contains(charToken)) {
                double firstNumber = stack.pop();
                double secondNumber = stack.pop();
                switch (charToken) {
                    case plus:
                        stack.push(firstNumber + secondNumber);
                        break;
                    case minus:
                        stack.push(firstNumber - secondNumber);
                        break;
                    case multiply:
                        stack.push(firstNumber * secondNumber);
                        break;
                    case divide:
                        stack.push(firstNumber / secondNumber);
                        break;
                }
            } else {
                double number = Double.valueOf(stringToken);
                stack.push(number);
            }
        }

        double output = stack.pop();
        assert stack.empty();
        return output;
    }

    /**
     * Extra.
     * Finds max sum that consists of k consecutive elements.
     *
     * @param array
     * @param k
     * @return
     */
    public static int maxSumForConsecutiveElements(int[] array, int k) {
        int length = array.length;

        // O(n)
        for (int i = 0; i < length - 1; i++) {
            array[i + 1] += array[i];
        }

        int maxSum = 0;
        int startIndex = k - 1;
        // O(n)
        for (int i = startIndex; i < length; i++) {
            int firstElementIndex = i - startIndex;
            int currentSum;

            if (firstElementIndex == 0) {
                maxSum = array[i];
                continue;
            } else {
                currentSum = array[i] - array[firstElementIndex - 1];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }
}
