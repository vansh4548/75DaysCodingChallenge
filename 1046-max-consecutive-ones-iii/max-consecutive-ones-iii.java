class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int start = 0; 
        int maxLength = 0;
        int zeroCount = 0; 

        for (int end = 0; end < n; end++) {
            if (nums[end] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[start] == 0) {
                    zeroCount--;
                }
                start++; 
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
