class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }

        double currentSum = maxSum;

        for (int i = k; i < n; i++) {
            currentSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum / k;
    }
}
