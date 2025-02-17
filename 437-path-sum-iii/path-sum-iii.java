import java.util.*;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L, 1);
        return dfs(root, 0, targetSum, prefixSum);
    }

    private int dfs(TreeNode node, long currSum, int target, Map<Long, Integer> prefixSum) {
        if (node == null) return 0;
        
        currSum += node.val;
        int count = prefixSum.getOrDefault(currSum - target, 0);
        
        prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        
        count += dfs(node.left, currSum, target, prefixSum);
        count += dfs(node.right, currSum, target, prefixSum);
        
        prefixSum.put(currSum, prefixSum.get(currSum) - 1);
        
        return count;
    }
}
