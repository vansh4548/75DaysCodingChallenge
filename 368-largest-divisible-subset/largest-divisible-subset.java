import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];       // dp[i] = length of largest subset ending at i
        int[] parent = new int[n];   // parent[i] = previous index in subset
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxLen = 1;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }

        // Reconstruct subset
        List<Integer> subset = new ArrayList<>();
        while (maxIndex != -1) {
            subset.add(nums[maxIndex]);
            maxIndex = parent[maxIndex];
        }

        Collections.reverse(subset);
        return subset;
    }
}

