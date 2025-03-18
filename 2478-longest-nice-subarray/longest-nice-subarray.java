class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int l = 0, mask = 0, maxLength = 0;

        for (int r = 0; r < n; r++) {
            while ((mask & nums[r]) != 0) {
                mask ^= nums[l]; 
                l++; 
            }

            mask |= nums[r]; 
            maxLength = Math.max(maxLength, r - l + 1);
        }
        
        return maxLength;
    }
}
