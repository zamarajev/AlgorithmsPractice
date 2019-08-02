package week1;

import java.util.*;

public class SolutionsWeek1 {

    /**
     * 1)
     * O(n log n) + O(n) => O(n log n)
     *
     * @param s1
     * @param s2
     * @return
     */
    boolean areAnagrams(String s1, String s2) {
        char array1[] = s1.toCharArray();
        char array2[] = s2.toCharArray();
        int length = array1.length;

        if (length != array2.length) {
            return false;
        }

        // O(n log n)
        Arrays.sort(array1);
        // O(n log n)
        Arrays.sort(array2);

        // O(n)
        for (int i = 0; i < length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 2)
     * O(n+k)
     *
     * @param a
     * @param n
     * @param k max number. k<=10^5
     * @return
     */
    int[] sort(int[] a, int n, int k) {
        int length = a.length;
        int[] output = new int[length];

        // O(n)
        Set<Integer> set = new HashSet(Arrays.asList(a));

        // O(k)
        for (int i = 0; i < k; i++) {
            if (set.contains(i)){
                output[i] = i;
            }
        }
        return output;
    }


    /**
     * 3)
     * O(n) + O(n) => O(n)
     *
     * @param a
     * @param d
     * @return
     */
    boolean has(int[] a, int d) {
        Set<Integer> hashSet = new HashSet<>();

        // O(n)
        for (int i : a) {
            // amortized O(1)
            hashSet.add(i);
        }

        // O(n)
        for (int i : a) {
            int searchedValue = i + d;
            // amortized O(1)
            if (hashSet.contains(searchedValue)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 4)
     * O(n) + O(n) => O(n)
     */
    boolean[] isInFirstArray(int[] a, int[] b) {
        boolean[] output = new boolean[b.length];
        Set<Integer> hashSet = new HashSet<>();

        // O(n)
        for (int i : a) {
            // amortized O(1)
            hashSet.add(i);
        }

        // O(n)
        for (int i = 0; i < b.length; i++) {
            // amortized O(1)
            output[i] = hashSet.contains(b[i]);
        }

        return output;
    }

    /**
     * 5)
     * Adds true to the stack if '(', otherwise removes value.
     * O(n)
     *
     * @param s
     * @return
     */
	boolean isCorrectSimpleBrackets(String s) {
        Stack<Boolean> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(') {
                stack.push(true);
            } else if (currentChar == ')') {
                if (stack.empty()){
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
        return stack.size() == 0;
    }

    /**
     * 6)
     * O(n)
     *
     * @param s
     * @return
     */
    boolean isCorrect(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        final int OPEN_BRACKET = '(';
        final int CLOSED_BRACKET = ')';
        final int OPEN_SQUARE = '[';
        final int CLOSED_SQUARE = ']';
        final int OPEN_CURLY = '{';
        final int CLOSED_CURLY = '}';

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            switch (currentChar) {
                case OPEN_BRACKET:
                    stack.push(OPEN_BRACKET);
                    break;
                case OPEN_SQUARE:
                    stack.push(OPEN_SQUARE);
                    break;
                case OPEN_CURLY:
                    stack.push(OPEN_CURLY);
                    break;
                case CLOSED_BRACKET:
                    if (stack.pop() != OPEN_BRACKET) {
                        return false;
                    } else {
                        break;
                    }
                case CLOSED_SQUARE:
                    if (stack.pop() != OPEN_SQUARE) {
                        return false;
                    } else {
                        break;
                    }
                case CLOSED_CURLY:
                    if (stack.pop() != OPEN_CURLY) {
                        return false;
                    } else {
                        break;
                    }
                default:
                    throw new IllegalArgumentException();
            }
        }
        return stack.size() == 0;
    }

    /**
     * 7)
     * O(n) * O(n) = O (n^2)
     *
     * @param a
     * @param l
     * @param r
     * @return
     */
    int[] sum(int[] a, int[] l, int[] r) {
        int length = l.length;
        if (length != r.length) {
            throw new IllegalArgumentException();
        }

        int[] output = new int[length];

        for (int i = 0; i < length; i++) {
            int start = l[i];
            int end = r[i];
            int sum = 0;
            for (int j = start; j < end; j++) {
                sum += a[j];
            }
            output[i] = sum;
        }

        return output;
    }
}
