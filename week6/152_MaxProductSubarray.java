public class Solution {
    public int maxProduct(int[] nums) {
        int[] min = new int[2];
        int[] max = new int[2];
        min[0] = max[0] = nums[0];
        int index = 0;
        int res = max[index];
        for (int i = 1; i < nums.length; i++) {
            max[i % 2] = min[i % 2] = nums[i];
            if (nums[i] > 0) {
                max[i % 2] = Math.max(max[i % 2], max[index] * nums[i]);
                min[i % 2] = Math.min(min[i % 2], min[index] * nums[i]);
            }
            if (nums[i] <= 0) {
                max[i % 2] = Math.max(max[i % 2], min[index] * nums[i]);
                min[i % 2] = Math.min(min[i % 2], max[index] * nums[i]);
            }
            res = Math.max(res, max[i % 2]);
            index = i % 2;
        }
        return res;
    }
}