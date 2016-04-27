public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] L = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            L[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    L[i] = Math.max(L[i], L[j] + 1);
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, L[i]);
        }
        return max;
    }
}