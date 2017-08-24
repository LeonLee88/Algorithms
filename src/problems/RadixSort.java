package problems;

public class RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {10, 25, 15, 6, 1, 9};
		RadixSort sol = new RadixSort();
		sol.radixSort(nums);
	}
	
	public int[] radixSort(int [] nums){
        //find the max value
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            max = nums[i] > max ? nums[i] : max;
        }
        
        // start from LSD
        int exp = 1;
        int[] res = new int[nums.length];
        
        while(exp <= max) {
        	int[] bucket = new int[10];
            for(int i=0; i<nums.length; i++) {
                bucket[(nums[i]/exp)% 10]++;
            }
            // prefix sum, now the value of bucket[i] is the actual position
            for(int i=1; i < 10; i++){
                bucket[i] += bucket[i-1];
            }
            // put the nums to the right position, scan the nums from right to left
            for(int i=res.length-1; i >= 0; i--){
                res[--bucket[(nums[i]/exp)% 10]] = nums[i];
            }
            // copy
            for(int i=0; i< nums.length; i++) {
                nums[i] = res[i];
            }
            // next LSD
            exp *= 10;
        }
        return res;
    }

}
