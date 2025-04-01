class Solution {
    private int maxZigZag = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        dfs(root.left, 0, 1);  // Start left
        dfs(root.right, 1, 1); // Start right
        return maxZigZag;
    }

    private void dfs(TreeNode node, int direction, int length) {
        if (node == null) return;

        maxZigZag = Math.max(maxZigZag, length);

        if (direction == 0) { // Came from left → Move right
            dfs(node.right, 1, length + 1);
            dfs(node.left, 0, 1); // Restart from left
        } else { // Came from right → Move left
            dfs(node.left, 0, length + 1);
            dfs(node.right, 1, 1); // Restart from right
        }
    }
}
