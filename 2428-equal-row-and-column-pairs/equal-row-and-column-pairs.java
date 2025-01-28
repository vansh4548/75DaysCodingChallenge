import java.util.*;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowMap = new HashMap<>();
        for (int[] row : grid) {
            StringBuilder sb = new StringBuilder();
            for (int num : row) {
                sb.append(num).append(",");
            }
            String rowStr = sb.toString();
            rowMap.put(rowStr, rowMap.getOrDefault(rowStr, 0) + 1);
        }
        int count = 0;
        for (int j = 0; j < n; j++) {
            StringBuilder colStr = new StringBuilder();
            for (int i = 0; i < n; i++) {
                colStr.append(grid[i][j]).append(",");
            }
            count += rowMap.getOrDefault(colStr.toString(), 0);
        }
        return count;
    }
}
