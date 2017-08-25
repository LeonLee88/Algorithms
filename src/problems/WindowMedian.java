package problems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by leon on 9/27/17.
 *
 * Given an array of n integer, and a moving window of size k (k<n), return the median number of
 * (n-k+1) windows in an ordered collection. Note: median is of rank x/2 given x ordered elements
 */
public class WindowMedian {

    public int[] getMedians(int[] nums, int k) {

        int[] medians = new int[nums.length - k + 1];

        PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        PriorityQueue<Integer> right = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for(int i=0; i < nums.length; i++) {
            // maxHeap will has equal number of values as minheap if k is event number
            // maxHeap will has 1 more number of values than minheap if k is obb number
            if(left.size() < (k+1)/2) {
                left.offer(nums[i]);
            } else {
                if(nums[i] >= left.peek()) {
                    right.offer(nums[i]);
                } else {
                    right.offer(left.poll());
                    left.offer(nums[i]);
                }
            }

            if (i >= k-1) {
                if(k % 2 == 0) {
                    medians[i - k + 1] = (left.peek() + right.peek()) / 2;
                } else {
                    medians[i - k + 1] = left.peek();
                }
                // delete left bound of window
                if(left.contains(nums[i-k+1])) {
                    left.remove(nums[i-k+1]);
                    while(left.size() < right.size()) {
                        int temp = right.poll();
                        left.offer(temp);
                    }
                } else {
                    right.remove(nums[i-k+1]);
                }
            }
        }

        return medians;
    }

    public int[] getMedians1(int[] nums, int k) {

        int[] medians = new int[nums.length - k + 1];
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        int countLeft = 0;
        int countRight = 0;

        for(int i=0; i < nums.length; i++) {
            // left will has equal number of values as right if k is event number
            // left will has 1 more number of values than right if k is obb number
            if (countLeft < (k + 1) / 2) {
                left.put(nums[i], left.getOrDefault(nums[i], 0) + 1);
                countLeft++;
            } else {
                if (nums[i] >= left.lastKey()) {
                    right.put(nums[i], right.getOrDefault(nums[i], 0) + 1);
                    countRight++;
                } else {
                    // remove greatest value from left part
                    int maxLeft = left.lastKey();
                    int count = left.get(maxLeft);
                    if (count == 1) {
                        left.remove(maxLeft);
                    } else {
                        left.put(maxLeft, count - 1);
                    }
                    left.put(nums[i], left.getOrDefault(nums[i], 0) + 1);

                    // add the greatest value from left part to the right part
                    right.put(maxLeft, right.getOrDefault(maxLeft, 0) + 1);
                    countRight++;
                }
            }

            if (i >= k-1) {
                if(k % 2 == 0) {
                    medians[i - k + 1] = (left.lastKey() + right.firstKey()) / 2;
                } else {
                    medians[i - k + 1] = left.lastKey();
                }
                // delete left bound of window
                if(left.containsKey(nums[i-k+1])) {
                    removeKeyFromMap(left, nums[i-k+1]);
                    countLeft--;
                    while(countLeft < countRight) {
                        int minRight = right.firstKey();
                        removeKeyFromMap(right, minRight);
                        countRight--;
                        left.put(minRight, left.getOrDefault(minRight, 0) + 1);
                        countLeft++;
                    }
                } else {
                    removeKeyFromMap(right, nums[i-k+1]);
                    countRight--;
                }
            }
        }

        return medians;
    }

    private void removeKeyFromMap(TreeMap<Integer, Integer> treeMap, Integer key) {
        int count = treeMap.get(key);
        if (count == 1) {
            treeMap.remove(key);
        } else {
            treeMap.put(key, count - 1);
        }
    }
}
