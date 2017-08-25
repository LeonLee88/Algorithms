package problems;

/**
 * Given an array A[n] with positive numbers from [1..N].
 * How to get an array B[N] such that B[i] represents the number of A[j] > A[i] (j > i)
 */
public class CountLessThan {
    static class Element {
        int number;
        int count;
        int index;

        public Element(int number, int count, int index) {
            this.number = number;
            this.count = count;
            this.index = index;
        }
    }

    public int[] count(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        Element[] elements = convertToElementArray(array);
        Element[] helper = new Element[elements.length];
        mergeSort(elements, 0, elements.length-1, helper);
        int[] res = new int[elements.length];
        for(int i=0; i<res.length; i++) {
            res[elements[i].index] = elements[i].count;
        }
        return res;
    }

    public void mergeSort(Element[] array, int left, int right, Element[] helper) {
        if(right <= left) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid, helper);
        mergeSort(array, mid+1, right, helper);
        mergeCount(array, left, mid, mid+1, right, helper);
    }

    public void mergeCount(Element[] array, int l1, int r1, int l2, int r2, Element[] helper) {
        int i = l1; // pointer of the left partition
        int j = l2; // pointer of the right partition
        int k = l1; // pointer of helper array
        while (i <= r1 && j <= r2) {
            if(array[i].number <= array[j].number) {
                array[i].count += j - l2;
                helper[k++] = array[i++];
            } else {
                helper[k++] = array[j++];
            }
        }

        // post processing, copy the remaining elements if there is any
        while (i <= r1) {
            array[i].count += j - l2; // merge {3[0], 5[0]} with {1[0], 2[1]}
            helper[k++] = array[i++];
        }

        while (j <= r2) {
            helper[k++] = array[j++];
        }
        // copy elements back from helper array to original array
        copyElements(array, helper, l1, r2);
    }

    public Element[] convertToElementArray(int[] array) {
        Element[] elements = new Element[array.length];
        for (int i = 0; i < array.length; i++) {
            elements[i] = new Element(array[i], 0, i);
        }
        return elements;
    }

    public void copyElements(Element[] array, Element[] helper, int left, int right) {
        for(int i=left; i<=right; i++) {
            array[i] = helper[i];
        }
    }
}
