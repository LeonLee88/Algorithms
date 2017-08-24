package problems;

/**
 * Given an array A[n] with positive numbers from [1..N].
 * How to get an array B[N] such that B[i] represents the number of A[j] > A[i] (j > i)
 */
public class CountLessThan {
    static class Element {
        int number;
        int count;
    }

    public int[] count(int[] array) {
        if(array == null || array.length == 0) {
            return array;
        }
        return null;
    }

    public void mergeCount(Element[] array, int left, int right){

    }
}
